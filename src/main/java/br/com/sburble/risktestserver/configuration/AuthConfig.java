package br.com.sburble.risktestserver.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AuthConfig implements WebMvcConfigurer {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {	
		registry.addInterceptor(new AuthInterceptor())			
			.excludePathPatterns("/risks/tests/authenticate/**"); 
	}

}
