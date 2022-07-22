package br.com.sburble.risktestserver.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.sburble.risktestserver.configuration.properties.WebhookProperties;
import br.com.sburble.risktestserver.domain.dto.AnalysisRequestDTO;
import br.com.sburble.risktestserver.domain.dto.BillingDTO;
import br.com.sburble.risktestserver.notifier.WebhookNotifier;
import br.com.sburble.risktestserver.repository.AnalysisRepository;
import br.com.sburble.risktestserver.service.CreateAnalysisService;

@ExtendWith(MockitoExtension.class)
class CreateAnalysisServiceTest {

	private static final String ORDER_ID = "1";
	private static final String DOCUMENT = "1234567890";
	
	@InjectMocks
	private CreateAnalysisService createAnalysisService;
	
	@Mock
	private WebhookProperties webhookProperties;
	
	@Mock
	private WebhookNotifier webhookNotifier;
	
	@Mock
	private AnalysisRepository analysisRepository;
	
	@Test
	void create_whenValid_expectNVO() {
		var response = createAnalysisService.create(createRequest());
		
		assertNotNull(response);
		assertNotNull(response.getPackageID());
		assertNotNull(response.getOrders());
		assertEquals(ORDER_ID, response.getOrders().get(0).getCode());
		assertEquals("NVO", response.getOrders().get(0).getStatus());
		assertNull(response.getOrders().get(0).getScore());
	}
	
	@Test
	void create_whenValid_expectWebhookToBeCalled() {		
		createAnalysisService.create(createRequest());
		
		verify(webhookNotifier).callWebhook(ORDER_ID);
	}
	
	@Test
	void create_whenValid_expectOrderIdAndDocumentToBeSaved() {		
		createAnalysisService.create(createRequest());

		verify(analysisRepository).save(ORDER_ID, DOCUMENT);
	}
	
	private AnalysisRequestDTO createRequest() {
		return AnalysisRequestDTO.builder()
				.code(ORDER_ID)
				.billing(BillingDTO.builder().primaryDocument(DOCUMENT).build())
				.build();
	}
}
