package br.com.sburble.risktestserver.service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import br.com.sburble.risktestserver.configuration.properties.WebhookProperties;
import br.com.sburble.risktestserver.domain.dto.AnalysisRequestDTO;
import br.com.sburble.risktestserver.domain.dto.AnalysisResponseDTO;
import br.com.sburble.risktestserver.domain.dto.StatusResponseDTO;
import br.com.sburble.risktestserver.notifier.WebhookNotifier;
import br.com.sburble.risktestserver.repository.AnalysisRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreateAnalysisService {
	
	private final WebhookProperties webhookProperties;
	
	private final WebhookNotifier webhookNotifier;
	
	private final AnalysisRepository analysisRepository;

	public AnalysisResponseDTO create(AnalysisRequestDTO analysis) {
		
		analysisRepository.save(analysis.getCode(), analysis.getBilling().getPrimaryDocument());
		
		notifyWithDelay(analysis);
		
		var orders = List.of(StatusResponseDTO.builder()
				.code(analysis.getCode())
				.status("NVO")				
				.build());
		
		return AnalysisResponseDTO.builder()
				.packageID(UUID.randomUUID().toString())
				.orders(orders)
				.build();
	}

	private void notifyWithDelay(AnalysisRequestDTO analysis) {
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		executorService.schedule(() -> webhookNotifier.callWebhook(analysis.getCode()), webhookProperties.getNotificationDelay(), TimeUnit.SECONDS);
	}
}
