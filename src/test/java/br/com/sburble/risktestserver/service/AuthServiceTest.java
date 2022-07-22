package br.com.sburble.risktestserver.service;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.sburble.risktestserver.domain.dto.auth.AuthRequestDTO;
import br.com.sburble.risktestserver.domain.dto.auth.AuthResponseDTO;
import br.com.sburble.risktestserver.service.AuthService;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {
	
	@InjectMocks
	private AuthService authService;
	
	@Test
	void authenticate_whenCalled_expectToken() {
		AuthResponseDTO response = authService.authenticate(AuthRequestDTO.builder()
				.name("name")
				.password("password")
				.build());
		
		assertNotNull(response);
		assertNotNull(response.getToken());
		assertNotNull(response.getExpirationDate());
	}

}
