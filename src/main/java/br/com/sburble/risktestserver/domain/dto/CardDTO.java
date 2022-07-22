package br.com.sburble.risktestserver.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.Size;

import io.micrometer.core.lang.NonNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CardDTO implements Serializable {

	private static final long serialVersionUID = -775952197733896863L;
	
	@NonNull
	@Size(min = 6, max = 6)
	private String bin;
	
	@NonNull
	@Size(min = 4, max = 4)
	private String end;
	
	@NonNull
	@Size(max = 150)
	private String ownerName;	

}
