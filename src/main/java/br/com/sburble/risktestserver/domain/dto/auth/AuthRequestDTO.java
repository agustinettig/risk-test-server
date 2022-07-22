package br.com.sburble.risktestserver.domain.dto.auth;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AuthRequestDTO implements Serializable {


	private static final long serialVersionUID = 3019784641330755832L;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String password;
}
