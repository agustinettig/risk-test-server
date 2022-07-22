package br.com.sburble.risktestserver.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
public class ShippingDTO implements Serializable {

	private static final long serialVersionUID = 7587971472719773643L;

	@NotNull
	@PositiveOrZero
	@Max(2)
	private Integer type;

	@NotBlank
	@Size(min = 11, max = 14)
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

	@Pattern(regexp = "^([01]?\\d|20)$")
	private String deliveryType;

	@Digits(integer = 20, fraction = 4)
	private BigDecimal price;

	@Valid
	private AddressDTO address;

	@NotEmpty
	@Valid
	private List<PhoneDTO> phones;
}
