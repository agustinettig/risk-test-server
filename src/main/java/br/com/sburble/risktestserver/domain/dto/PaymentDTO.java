package br.com.sburble.risktestserver.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PaymentDTO implements Serializable {

	private static final long serialVersionUID = 8763802569968270019L;

	@NotNull
	@Max(21)
	private Integer type;
	
	private CardDTO card;
}
