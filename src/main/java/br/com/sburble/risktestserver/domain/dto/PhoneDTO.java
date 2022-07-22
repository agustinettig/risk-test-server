package br.com.sburble.risktestserver.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PhoneDTO implements Serializable {
	
	private static final long serialVersionUID = 1784283375058234663L;
	
	@NotNull
	@PositiveOrZero
	@Max(6)
	private Integer type;
	
	@NotNull
	@Digits(integer = 9, fraction = 0)
	private Integer number;
	
	@NotNull
	@Digits(integer = 2, fraction = 0)
	private Integer ddd;
	
	@Size(max = 10)
	private String extension;

}
