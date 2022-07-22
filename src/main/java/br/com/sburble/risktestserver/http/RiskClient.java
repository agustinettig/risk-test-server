package br.com.sburble.risktestserver.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.sburble.risktestserver.domain.dto.WebhookNotificationDTO;
import feign.Headers;

@FeignClient(name = "riskClient", url = "${webhook.endpoint}")
public interface RiskClient {

	@PostMapping
	@Headers("Content-Type: application/json")
	void notifyStatusChange(@RequestBody WebhookNotificationDTO status);

}


