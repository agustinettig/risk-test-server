package br.com.sburble.risktestserver.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import br.com.sburble.risktestserver.domain.dto.StatusResponseDTO;
import br.com.sburble.risktestserver.domain.enums.Status;
import br.com.sburble.risktestserver.repository.AnalysisRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GetStatusService {
	
	private final AnalysisRepository analysisRepository;
	
	public StatusResponseDTO getStatusByOrderId(String orderId) {
		var lastDigit = analysisRepository.getDocumentLastDigit(orderId);
		var orderStatus = Status.getStatusByLastDigit(lastDigit).getCode();
		
		return StatusResponseDTO.builder()
				.code(orderId)
				.status(orderStatus)
				.score(BigDecimal.TEN)				
				.build();
	}
}
