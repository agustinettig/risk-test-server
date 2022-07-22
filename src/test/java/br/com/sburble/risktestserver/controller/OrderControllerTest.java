package br.com.sburble.risktestserver.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcSecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import br.com.sburble.risktestserver.controller.OrderController;
import br.com.sburble.risktestserver.service.CreateAnalysisService;
import br.com.sburble.risktestserver.service.GetStatusService;

@WebMvcTest(controllers = {OrderController.class}, excludeAutoConfiguration = { MockMvcSecurityAutoConfiguration.class })
class OrderControllerTest {
	
	private static final String BASE_URL = "/risks/tests/orders/";
	private static final String VALID_CREATE_REQUEST_BODY = "{\"code\":\"ORDER_EXAMPLE_2_0_1\",\"sessionID\":\"SessionIDValue\",\"date\":\"2017-03-22T13:38:59.9894222\",\"email\":\"email@email.com.br\",\"totalValue\":15,\"observation\":\"Observation example\",\"origin\":\"Origin example\",\"customSla\":60,\"billing\":{\"type\":1,\"primaryDocument\":\"12345678910\",\"name\":\"Complete Client Name\",\"birthDate\":\"1990-01-10T00:00:00.000\",\"email\":\"email@email.com.br\",\"gender\":\"M\",\"address\":{\"street\":\"Street name example\",\"number\":\"100\",\"additionalInformation\":\"Additional information example\",\"county\":\"County Example\",\"city\":\"City Example\",\"state\":\"SP\",\"zipcode\":\"12345678\",\"country\":\"Brasil\",\"reference\":\"Address reference example\"},\"phones\":[{\"type\":1,\"ddi\":55,\"ddd\":11,\"number\":33333333,\"extension\":\"1111\"}]},\"shipping\":{\"type\":1,\"primaryDocument\":\"12345678910\",\"secondaryDocument\":\"12345678\",\"name\":\"Complete Client Name\",\"birthDate\":\"1990-01-10T00:00:00.000\",\"email\":\"email@email.com.br\",\"gender\":\"M\",\"address\":{\"street\":\"Street name example\",\"number\":\"100\",\"additionalInformation\":\"Additional information example\",\"county\":\"County Example\",\"city\":\"City Example\",\"state\":\"SP\",\"zipcode\":\"12345678\",\"country\":\"Brasil\",\"reference\":\"Address reference example\"},\"phones\":[{\"type\":1,\"ddi\":55,\"ddd\":11,\"number\":33333333,\"extension\":\"1111\"}],\"deliveryType\":\"1\",\"price\":5},\"payments\":[{\"type\":1,\"card\":{\"bin\":\"123456\",\"end\":\"1234\",\"ownerName\":\"Owner Card Name\"},\"address\":{\"street\":\"Street name example\",\"number\":\"10\",\"additionalInformation\":\"Additional information example\",\"county\":\"County Example\",\"city\":\"City Example\",\"state\":\"SP\",\"zipcode\":\"12345678\",\"country\":\"Brasil\",\"reference\":\"Address reference example\"}}],\"items\":[{\"name\":\"Item description\",\"value\":10,\"amount\":1}]}";
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private GetStatusService getStatusService;
	
	@MockBean
	private CreateAnalysisService createAnalysisService;
	
	@Test
	void getStatus_whenValid_expectOk() throws Exception {		
		mockMvc.perform(get(BASE_URL + "1/status")
				.header("Authorization", "Bearer securetoken"))
			.andExpect(status().isOk());
	}
	
	@Test
	void getStatus_whenNoToken_expectUnauthorized() throws Exception {		
		mockMvc.perform(get(BASE_URL + "1/status"))
			.andExpect(status().isUnauthorized());
	}
	
	@Test
	void createAnalysis_whenValid_expectCreated() throws Exception {		
		mockMvc.perform(post(BASE_URL)
				.header("Authorization", "Bearer securetoken")
				.content(VALID_CREATE_REQUEST_BODY)
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated());
	}
	
	@Test
	void createAnalysis_whenInvalid_expectBadRequest() throws Exception {		
		mockMvc.perform(post(BASE_URL)
				.header("Authorization", "Bearer securetoken")
				.content("{}")
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isBadRequest());
	}
	
	@Test
	void createAnalysis_whenNoToken_expectUnauthorized() throws Exception {		
		mockMvc.perform(post(BASE_URL)
				.content(VALID_CREATE_REQUEST_BODY)
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isUnauthorized());
	}

}
