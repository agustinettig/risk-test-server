package br.com.sburble.risktestserver.exception;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper=false)
public class ClearSaleException extends RuntimeException {

	private static final long serialVersionUID = -8836012690546917372L;
	
	@JsonIgnore
    private final HttpStatus httpStatusCode;
	
	private final String message;
	
	private final Map<String, List<String>> modelState;
	
	public ClearSaleExceptionBody getBody() {
        return ClearSaleExceptionBody.builder()
                .message(this.message)
                .modelState(this.modelState)
                .build();
    }
	
	@Getter
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ClearSaleExceptionBody {
		
		@JsonProperty("Message")
        private String message;

		@JsonProperty("ModelState")
        private Map<String, List<String>> modelState;

    }
}
