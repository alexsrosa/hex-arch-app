package pt.example.hexarchapp.adapters.input.endpoints;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import pt.example.hexarchapp.config.TestConfiguration;
import pt.example.hexarchapp.domains.exceptions.AccountNotFoundException;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles( { "test" } )
@SpringBootTest( classes = { MockServletContext.class, TestConfiguration.class } )
@AutoConfigureMockMvc
@TestInstance( PER_CLASS )
class FetchAccountEndpointTest {

	@Autowired
	private MockMvc mvc;

	@Test
	void Given_EndpointAccountFetchAccountById_When_IdNotExists_Then_ReturnNotFound() throws Exception {
		mvc.perform( get( "/accounts/999" ) )
				.andExpect( status().isNotFound() )
				.andExpect( content().contentType( MediaType.APPLICATION_JSON ) )
				.andExpect( jsonPath( "$.time" ).exists() )
				.andExpect( jsonPath( "$.message" ).value( AccountNotFoundException.ACCOUNT_NOT_FOUND ) )
				.andDo( print() );
	}

}