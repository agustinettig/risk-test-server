package br.com.sburble.risktestserver.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.sburble.risktestserver.domain.enums.Status;
import br.com.sburble.risktestserver.repository.AnalysisRepository;
import br.com.sburble.risktestserver.service.GetStatusService;

@ExtendWith(MockitoExtension.class)
class GetStatusServiceTest {
	
	private static final String ORDER_ID = "123";
	
	@InjectMocks
	private GetStatusService getStatusService;
	
	@Mock
	private AnalysisRepository analysisRepository;
	
	@Test
	void getStatusByOrderId_whenValid_expectScoreAndCode() {
		var response = getStatusService.getStatusByOrderId(ORDER_ID);
		assertNotNull(response);
		assertNotNull(response.getScore());
		assertEquals(ORDER_ID, response.getCode());
		verify(analysisRepository).getDocumentLastDigit(ORDER_ID);
	}
	
	@Test
	void getStatusByOrderId_whenDocumentEndsWithZero_expectAPA() {
		when(analysisRepository.getDocumentLastDigit(ORDER_ID)).thenReturn(0);
		var response = getStatusService.getStatusByOrderId(ORDER_ID);
		assertNotNull(response);
		assertEquals(Status.APA.getCode(), response.getStatus());
	}
	
	@Test
	void getStatusByOrderId_whenDocumentEndsWithOne_expectAPM() {
		when(analysisRepository.getDocumentLastDigit(ORDER_ID)).thenReturn(1);
		var response = getStatusService.getStatusByOrderId(ORDER_ID);
		assertNotNull(response);
		assertEquals(Status.APM.getCode(), response.getStatus());
	}
	
	@Test
	void getStatusByOrderId_whenDocumentEndsWithTwo_expectRPM() {
		when(analysisRepository.getDocumentLastDigit(ORDER_ID)).thenReturn(2);
		var response = getStatusService.getStatusByOrderId(ORDER_ID);
		assertNotNull(response);
		assertEquals(Status.RPM.getCode(), response.getStatus());
	}
	
	@Test
	void getStatusByOrderId_whenDocumentEndsWithThree_expectAMA() {
		when(analysisRepository.getDocumentLastDigit(ORDER_ID)).thenReturn(3);
		var response = getStatusService.getStatusByOrderId(ORDER_ID);
		assertNotNull(response);
		assertEquals(Status.AMA.getCode(), response.getStatus());
	}
	
	@Test
	void getStatusByOrderId_whenDocumentEndsWithFour_expectSUS() {
		when(analysisRepository.getDocumentLastDigit(ORDER_ID)).thenReturn(4);
		var response = getStatusService.getStatusByOrderId(ORDER_ID);
		assertNotNull(response);
		assertEquals(Status.SUS.getCode(), response.getStatus());
	}
	
	@Test
	void getStatusByOrderId_whenDocumentEndsWithFive_expectCAN() {
		when(analysisRepository.getDocumentLastDigit(ORDER_ID)).thenReturn(5);
		var response = getStatusService.getStatusByOrderId(ORDER_ID);
		assertNotNull(response);
		assertEquals(Status.CAN.getCode(), response.getStatus());
	}
	
	@Test
	void getStatusByOrderId_whenDocumentEndsWithSix_expectFRD() {
		when(analysisRepository.getDocumentLastDigit(ORDER_ID)).thenReturn(6);
		var response = getStatusService.getStatusByOrderId(ORDER_ID);
		assertNotNull(response);
		assertEquals(Status.FRD.getCode(), response.getStatus());
	}
	
	@Test
	void getStatusByOrderId_whenDocumentEndsWithSeven_expectRPA() {
		when(analysisRepository.getDocumentLastDigit(ORDER_ID)).thenReturn(7);
		var response = getStatusService.getStatusByOrderId(ORDER_ID);
		assertNotNull(response);
		assertEquals(Status.RPA.getCode(), response.getStatus());
	}
	
	@Test
	void getStatusByOrderId_whenDocumentEndsWithEight_expectRPP() {
		when(analysisRepository.getDocumentLastDigit(ORDER_ID)).thenReturn(8);
		var response = getStatusService.getStatusByOrderId(ORDER_ID);
		assertNotNull(response);
		assertEquals(Status.RPP.getCode(), response.getStatus());
	}
	
	@Test
	void getStatusByOrderId_whenDocumentEndsWithNine_expectAPP() {
		when(analysisRepository.getDocumentLastDigit(ORDER_ID)).thenReturn(9);
		var response = getStatusService.getStatusByOrderId(ORDER_ID);
		assertNotNull(response);
		assertEquals(Status.APP.getCode(), response.getStatus());
	}

}
