package br.com.sburble.risktestserver.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddressDTO implements Serializable {
	
	private static final long serialVersionUID = 5850098065784519636L;

	@NotBlank
	@Size(max = 200)
	private String street;
	
	@NotBlank
	@Size(max = 15)
	private String number;
	
	@Size(max = 250)
	private String additionalInformation;
	
	@NotBlank
	@Size(max = 150)
	private String county;
	
	@NotBlank
	@Size(max = 150)
	private String city;
	
	@NotBlank
	@Size(max = 2)
	private String state;
	
	@NotBlank
	@Size(max = 10)
	private String zipcode;
	
	@Size(max = 250)
	private String reference;

}
