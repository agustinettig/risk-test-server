package br.com.sburble.risktestserver.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.sburble.risktestserver.exception.ClearSaleException;

@Repository
public class AnalysisRepository {

	private Map<String, Integer> orders = new HashMap<>();
	
	public void save(String orderId, String document) {
		if (orders.containsKey(orderId)) {
			Map<String, List<String>> model = Map.of("existing-orders", List.of(orderId));
			throw new ClearSaleException(HttpStatus.BAD_REQUEST, "The request is invalid.", model);
		}
		Integer lastDigit = Character.getNumericValue(document.charAt(document.length() -1));
		this.orders.put(orderId, lastDigit);
	}
	
	public Integer getDocumentLastDigit(String orderId) {
		Integer value = this.orders.get(orderId);
		
		if (value == null ) {
			throw new ClearSaleException(HttpStatus.NOT_FOUND, null, null);
		}
		
		return value;
	}
}
