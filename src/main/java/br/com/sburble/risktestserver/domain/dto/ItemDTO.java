package br.com.sburble.risktestserver.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ItemDTO implements Serializable {

	private static final long serialVersionUID = 7212316388504477754L;

	@NotBlank
	@Size(max = 150)
	private String name;
	
	@Digits(integer=20, fraction=4)
	private BigDecimal value;
	
	private Integer amount;
}
