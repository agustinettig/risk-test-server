package br.com.sburble.risktestserver.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.sburble.risktestserver.exception.ClearSaleException;
import br.com.sburble.risktestserver.repository.AnalysisRepository;

@ExtendWith(MockitoExtension.class)
class AnalysisRepositoryTest {
	
	@InjectMocks
	private AnalysisRepository analysisRepository;
	
	@Test
	void save_whenDoesNotExists_expectLastDigitToBeSaved() {
		Integer document = 123456;
		String orderId = "123";
		
		analysisRepository.save(orderId, document.toString());
		var savedDigit = analysisRepository.getDocumentLastDigit(orderId);
		
		assertNotNull(savedDigit);
		assertEquals(Integer.valueOf(6), savedDigit);
	}
	
	@Test
	void save_whenAlreadyExists_expectException() {
		Integer document = 123456;
		String orderId = "123";
		String documentSrting = document.toString();
		analysisRepository.save(orderId, documentSrting);
		
		assertThrows(ClearSaleException.class, () -> 
			analysisRepository.save(orderId, documentSrting)
		);
	}
	
	@Test
	void getDocumentLastDigit_whenExists_expectToReturn() {
		Integer documentLastDigit = 1;
		String orderId = "123";
		analysisRepository.save(orderId, documentLastDigit.toString());
		
		var response = analysisRepository.getDocumentLastDigit(orderId);
		
		assertNotNull(response);
		assertEquals(documentLastDigit, response);
	}
	
	@Test
	void getDocumentLastDigit_whenDoesNotExists_expectException() {		
		assertThrows(ClearSaleException.class, () -> 
			analysisRepository.getDocumentLastDigit("123")
		);
	}

}
