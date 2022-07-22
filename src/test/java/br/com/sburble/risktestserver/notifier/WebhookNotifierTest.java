package br.com.sburble.risktestserver.notifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.sburble.risktestserver.domain.dto.WebhookNotificationDTO;
import br.com.sburble.risktestserver.http.RiskClient;
import br.com.sburble.risktestserver.notifier.WebhookNotifier;

@EnableRetry
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WebhookNotifier.class })
@TestPropertySource("/application.properties")
class WebhookNotifierTest {

	@Autowired
	private WebhookNotifier webhookNotifier;
	
	@MockBean
	private RiskClient riskClient;
	
	@Test
	void callWebhook_whenCalled_expectSuccess() {
		webhookNotifier.callWebhook("123");
		
		verify(riskClient).notifyStatusChange(any(WebhookNotificationDTO.class));
	}
	
	@Test
	void callWebhook_whenFailed_expectRecoverToBeCalled() {	
		doThrow(RuntimeException.class).when(riskClient).notifyStatusChange(any());
		
		webhookNotifier.callWebhook("123");
		
		verify(riskClient, times(5)).notifyStatusChange(any(WebhookNotificationDTO.class));		
	}
	
}
