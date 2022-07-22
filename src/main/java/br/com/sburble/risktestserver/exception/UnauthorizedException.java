package br.com.sburble.risktestserver.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends BusinessException {

	private static final long serialVersionUID = 1892670534005111991L;

	public UnauthorizedException() {
		super(HttpStatus.UNAUTHORIZED, null, HttpStatus.UNAUTHORIZED.getReasonPhrase(), "Authorization token is missing.");
	}
}
