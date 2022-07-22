package br.com.sburble.risktestserver.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcSecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import br.com.sburble.risktestserver.controller.AuthController;
import br.com.sburble.risktestserver.service.AuthService;

@WebMvcTest(controllers = {AuthController.class}, excludeAutoConfiguration = { MockMvcSecurityAutoConfiguration.class })
class AuthControllerTest {
	
	private static final String BASE_URL = "/risks/tests/authenticate";
	private static final String VALID_REQUEST_BODY = "{\"name\":\"username\",\"password\":\"securepass\"}";

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AuthService authService;
	
	@Test
	void authenticate_whenValid_expectOk() throws Exception {		
		mockMvc.perform(post(BASE_URL)
				.content(VALID_REQUEST_BODY)
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}
	
	@Test
	void authenticate_whenInvalid_expectBadRequest() throws Exception {		
		mockMvc.perform(post(BASE_URL)
				.content("{}")
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isBadRequest());
	}
}
