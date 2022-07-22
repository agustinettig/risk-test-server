package br.com.sburble.risktestserver.notifier;

import java.time.LocalDateTime;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import br.com.sburble.risktestserver.domain.dto.WebhookNotificationDTO;
import br.com.sburble.risktestserver.http.RiskClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class WebhookNotifier {

	private final RiskClient riskClient;

	@Retryable(value = Exception.class, maxAttemptsExpression = "${webhook.retry-attemps}", backoff = @Backoff(delayExpression = "${webhook.retry-delay}"))
	public void callWebhook(String orderId) {
		log.info("method=callWebook orderId={}", orderId);
		riskClient.notifyStatusChange(WebhookNotificationDTO.builder()
				.code(orderId)
				.date(LocalDateTime.now())
				.type("status")
				.build());
	}
	
	@Recover
	private void callWebhookRecover(Exception e, String orderId) {
		log.error("method=sendWebhookRecover orderId={} - Failed to call webhook reason={}", orderId, e.getMessage());
	}
}
