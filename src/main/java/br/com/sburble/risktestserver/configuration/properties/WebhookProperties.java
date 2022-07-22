package br.com.sburble.risktestserver.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "webhook")
public class WebhookProperties {

	private Long notificationDelay;
	private String endpoint;
	private Integer retryAttemps;
	private Long retryDelay;
}
