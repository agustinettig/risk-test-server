package br.com.sburble.risktestserver.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.sburble.risktestserver.domain.dto.auth.AuthRequestDTO;
import br.com.sburble.risktestserver.domain.dto.auth.AuthResponseDTO;
import br.com.sburble.risktestserver.service.AuthService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/risks/tests/authenticate")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthService authService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.OK)
    public AuthResponseDTO authenticate(@RequestBody @Valid AuthRequestDTO request) {
        return authService.authenticate(request);
    }

}
