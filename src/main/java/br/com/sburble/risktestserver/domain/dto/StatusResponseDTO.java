package br.com.sburble.risktestserver.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StatusResponseDTO implements Serializable {

	private static final long serialVersionUID = -5876736567914137814L;
	
	private String code;
	private String status;
	private BigDecimal score;

}
