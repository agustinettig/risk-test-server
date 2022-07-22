package br.com.sburble.risktestserver.domain.dto.auth;

import java.io.Serializable;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthResponseDTO implements Serializable {

	private static final long serialVersionUID = -2205224730415703768L;
	
	@JsonProperty("Token")
	private String token;
	
	@JsonProperty("ExpirationDate")
	private ZonedDateTime expirationDate;

	
}
