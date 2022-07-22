package br.com.sburble.risktestserver.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AnalysisRequestDTO implements Serializable {

	private static final long serialVersionUID = 3222360124975317724L;

	@NotBlank
	@Size(max = 50)
	private String code;
	
	@NotBlank
	@Size(max = 128)
	private String sessionID;
	
	@NotNull
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", locale = "pt-BR", timezone = "Brazil/East")
	private LocalDateTime date;
	
	@NotBlank
	@Size(max = 150)
	private String email;
	
	@NotNull	
	@Digits(integer=20, fraction=4)
	private BigDecimal totalValue;
	
	@Size(max = 250)
	private String observation;
	
	@Size(max = 150)
	private String origin;
	
	private Integer customSla;
	
	@NotNull
	@Valid
	private BillingDTO billing;
	
	@Valid
	private ShippingDTO shipping;
	
	@Valid
	private List<ItemDTO> items;

	@Valid
	private List<PaymentDTO> payments;
	
}
