package br.com.sburble.risktestserver.domain.enums;

import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {

	APA("APA", 0),
	APM("APM", 1),
	RPM("RPM", 2),
	AMA("AMA", 3),
	SUS("SUS", 4),
	CAN("CAN", 5),
	FRD("FRD", 6),
	RPA("RPA", 7),
	RPP("RPP", 8),
	APP("APP", 9);
	
	private String code;
	private int endsWith;
	
	public static Status getStatusByLastDigit(int lastDigit) {
		return Stream.of(Status.values())
				.filter(status -> status.getEndsWith() == lastDigit)
				.findFirst()
				.orElse(RPA);
	}
	
}