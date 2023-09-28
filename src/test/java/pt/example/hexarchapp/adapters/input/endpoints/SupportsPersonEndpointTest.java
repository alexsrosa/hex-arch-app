package pt.example.hexarchapp.adapters.input.endpoints;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
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
import pt.example.hexarchapp.adapters.input.endpoints.data.CreatePersonCommandData;
import pt.example.hexarchapp.application.usecases.data.commands.CreatePersonCommand;
import pt.example.hexarchapp.config.TestConfiguration;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles({"test"})
@SpringBootTest(classes = {MockServletContext.class, TestConfiguration.class})
@AutoConfigureMockMvc
@TestInstance(PER_CLASS)
@Sql("/data/delete_all_tables.sql")
class SupportsPersonEndpointTest implements CreatePersonCommandData {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void Given_SupportsPersonEndpointCreate_When_ReceivesCorrectlyObject_Then_ReturnHttp201Created() throws Exception {

        CreatePersonCommand createPersonCommand = getCreatePersonCommand();

        mvc.perform(post("/persons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createPersonCommand)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(header().exists("Location"))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.first_name").value(createPersonCommand.getFirstName()))
                .andExpect(jsonPath("$.last_name").value(createPersonCommand.getLastName()))
                .andExpect(jsonPath("$.date_of_birth").value(createPersonCommand.getDateOfBirth().toString()))
                .andExpect(jsonPath("$.email").value(createPersonCommand.getEmail()))
                .andExpect(jsonPath("$.phone_number").value(createPersonCommand.getPhoneNumber()))
                .andExpect(jsonPath("$.address").value(createPersonCommand.getAddress()))
                .andExpect(jsonPath("$.tax_identifier").value(createPersonCommand.getTaxIdentifier()))
                .andDo(print());
    }

    @Test
    void Given_SupportsPersonEndpointCreate_When_ReceivesFirstNameNullOrEmpty_Then_ReturnHttp400() throws Exception {

        CreatePersonCommand createPersonCommand = getCreatePersonCommand();
        createPersonCommand.setFirstName(null);

        mvc.perform(post("/persons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createPersonCommand)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.time").exists())
                .andExpect(jsonPath("$.message").isArray())
                .andExpect(jsonPath("$.message[0]").value("firstName: must not be empty"))
                .andDo(print());

        createPersonCommand.setFirstName(StringUtils.EMPTY);

        mvc.perform(post("/persons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createPersonCommand)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.time").exists())
                .andExpect(jsonPath("$.message").isArray())
                .andExpect(jsonPath("$.message[0]").value("firstName: must not be empty"))
                .andDo(print());
    }

    @Test
    void Given_SupportsPersonEndpointCreate_When_ReceivesLastNameNullOrEmpty_Then_ReturnHttp400() throws Exception {

        CreatePersonCommand createPersonCommand = getCreatePersonCommand();
        createPersonCommand.setLastName(null);

        mvc.perform(post("/persons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createPersonCommand)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.time").exists())
                .andExpect(jsonPath("$.message").isArray())
                .andExpect(jsonPath("$.message[0]").value("lastName: must not be empty"))
                .andDo(print());

        createPersonCommand.setLastName(StringUtils.EMPTY);

        mvc.perform(post("/persons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createPersonCommand)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.time").exists())
                .andExpect(jsonPath("$.message").isArray())
                .andExpect(jsonPath("$.message[0]").value("lastName: must not be empty"))
                .andDo(print());
    }

    @Test
    void Given_SupportsPersonEndpointCreate_When_ReceivesDateOfBirthNullOrEmpty_Then_ReturnHttp400() throws Exception {

        CreatePersonCommand createPersonCommand = getCreatePersonCommand();
        createPersonCommand.setDateOfBirth(null);

        mvc.perform(post("/persons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createPersonCommand)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.time").exists())
                .andExpect(jsonPath("$.message").isArray())
                .andExpect(jsonPath("$.message[0]").value("dateOfBirth: must not be null"))
                .andDo(print());
    }

    @Test
    void Given_SupportsPersonEndpointCreate_When_ReceivesEmailNullOrEmptyOrWrong_Then_ReturnHttp400() throws Exception {

        CreatePersonCommand createPersonCommand = getCreatePersonCommand();

        createPersonCommand.setEmail("wrong.mail.pt");

        mvc.perform(post("/persons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createPersonCommand)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.time").exists())
                .andExpect(jsonPath("$.message").isArray())
                .andExpect(jsonPath("$.message[0]").value("email: must be a well-formed email address"))
                .andDo(print());

        createPersonCommand.setEmail(null);

        mvc.perform(post("/persons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createPersonCommand)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.time").exists())
                .andExpect(jsonPath("$.message").isArray())
                .andExpect(jsonPath("$.message[0]").value("email: must not be empty"))
                .andDo(print());

        createPersonCommand.setEmail(StringUtils.EMPTY);

        mvc.perform(post("/persons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createPersonCommand)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.time").exists())
                .andExpect(jsonPath("$.message").isArray())
                .andExpect(jsonPath("$.message[0]").value("email: must not be empty"))
                .andDo(print());
    }
}