package br.com.sburble.risktestserver.service;

import java.time.ZonedDateTime;

import org.springframework.stereotype.Service;

import br.com.sburble.risktestserver.domain.dto.auth.AuthRequestDTO;
import br.com.sburble.risktestserver.domain.dto.auth.AuthResponseDTO;

@Service
public class AuthService {

	public AuthResponseDTO authenticate(AuthRequestDTO request) {
		return AuthResponseDTO.builder()
				.token("somtiroglaserohlemsolepodaregorugesrepusnekot")
				.expirationDate(ZonedDateTime.now().plusHours(3))
				.build();
	}

}
