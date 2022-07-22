package br.com.sburble.risktestserver.domain.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import br.com.sburble.risktestserver.domain.enums.Gender;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BillingDTO implements Serializable {

	private static final long serialVersionUID = 1759313569067966422L;
	
	@NotNull
	@PositiveOrZero
	@Max(2)
	private Integer type;
	
	@NotBlank
	@Size(min = 11, max= 14)
	private String primaryDocument;
	
	@NotBlank
	@Size(max = 500)
	private String name;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate birthDate;
	
	@Size(max = 500)
	private String email;
	
	private Gender gender;

	private AddressDTO address;
	
	@NotEmpty
	private List<PhoneDTO> phones;
}
