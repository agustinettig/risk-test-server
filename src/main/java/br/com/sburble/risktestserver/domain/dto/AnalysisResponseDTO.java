package br.com.sburble.risktestserver.domain.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AnalysisResponseDTO implements Serializable {

	private static final long serialVersionUID = -1212967831073739304L;
	
	private String packageID;
	
	private List<StatusResponseDTO> orders;	

}
