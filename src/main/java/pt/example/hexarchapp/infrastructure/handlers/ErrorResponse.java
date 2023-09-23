package pt.example.hexarchapp.infrastructure.handlers;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorResponse {

	@Builder.Default
	private LocalDateTime time = LocalDateTime.now();

	private String message;

}
