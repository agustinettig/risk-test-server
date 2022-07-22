package br.com.sburble.risktestserver.domain.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WebhookNotificationDTO implements Serializable {

	private static final long serialVersionUID = 7409336116916595799L;

	private String code;
	private LocalDateTime date;
	private String type;
}
