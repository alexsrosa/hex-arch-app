package pt.example.hexarchapp.adapters.input.endpoints.handlers;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ApiErrorResponse {

	@Builder.Default
	private LocalDateTime time = LocalDateTime.now();

	private String message;

}
