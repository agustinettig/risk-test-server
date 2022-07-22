package br.com.sburble.risktestserver.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.sburble.risktestserver.domain.dto.AnalysisRequestDTO;
import br.com.sburble.risktestserver.domain.dto.AnalysisResponseDTO;
import br.com.sburble.risktestserver.domain.dto.StatusResponseDTO;
import br.com.sburble.risktestserver.service.CreateAnalysisService;
import br.com.sburble.risktestserver.service.GetStatusService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/risks/tests/orders")
@RequiredArgsConstructor
public class OrderController {
	
	private final GetStatusService getStatusService;
	
	private final CreateAnalysisService createAnalysisService;
	
	@GetMapping("/{orderId}/status")
	@ResponseStatus(code = HttpStatus.OK)
    public StatusResponseDTO getStatus(@PathVariable String orderId) {
        return getStatusService.getStatusByOrderId(orderId);
    }
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
    public AnalysisResponseDTO createAnalysis(@RequestBody @Valid AnalysisRequestDTO request) {
        return createAnalysisService.create(request);
    }

}
