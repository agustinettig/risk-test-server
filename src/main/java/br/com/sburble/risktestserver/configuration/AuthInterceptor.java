package br.com.sburble.risktestserver.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import br.com.sburble.risktestserver.exception.UnauthorizedException;

@Component
public class AuthInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (request.getHeader("Authorization") == null || request.getHeader("Authorization").isEmpty()) {
			throw new UnauthorizedException();			
		}
		return true;
	}
}
