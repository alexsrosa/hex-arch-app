package pt.example.hexarchapp.adapters.input.endpoints;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import pt.example.hexarchapp.application.usecases.FetchPersonUseCase;
import pt.example.hexarchapp.config.TestConfiguration;
import pt.example.hexarchapp.domains.model.Person;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static pt.example.hexarchapp.application.ports.input.PersonInputPort.PERSON_NOT_FOUND;

@ActiveProfiles({"test"})
@SpringBootTest(classes = {MockServletContext.class, TestConfiguration.class})
@AutoConfigureMockMvc
@TestInstance(PER_CLASS)
@Sql("/data/delete_all_tables.sql")
@Sql("/data/create_persons_01.sql")
class FetchPersonEndpointTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private FetchPersonUseCase fetchPersonUseCase;

    @Test
    void Given_EndpointPersonFetchById_When_IdNotExists_Then_ReturnNotFound() throws Exception {
        mvc.perform(get("/persons/999"))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.time").exists())
                .andExpect(jsonPath("$.message").value(PERSON_NOT_FOUND))
                .andDo(print());
    }

    @Test
    void Given_EndpointPersonFetchById_When_IdExists_Then_ReturnPerson() throws Exception {

        Person person = fetchPersonUseCase.findById(1000L).orElse(null);

        assertNotNull(person);

        mvc.perform(get("/persons/{id}", person.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(person.getId()))
                .andExpect(jsonPath("$.first_name").value(person.getFirstName()))
                .andExpect(jsonPath("$.last_name").value(person.getLastName()))
                .andExpect(jsonPath("$.date_of_birth").value(person.getDateOfBirth().toString()))
                .andExpect(jsonPath("$.email").value(person.getEmail()))
                .andExpect(jsonPath("$.phone_number").value(person.getPhoneNumber()))
                .andExpect(jsonPath("$.address").value(person.getAddress()))
                .andExpect(jsonPath("$.tax_identifier").value(person.getTaxIdentifier()))
                .andDo(print());
    }
}