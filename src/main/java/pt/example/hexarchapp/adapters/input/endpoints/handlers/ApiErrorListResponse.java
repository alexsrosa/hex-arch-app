package pt.example.hexarchapp.adapters.input.endpoints.handlers;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ApiErrorListResponse {

    @Builder.Default
    private LocalDateTime time = LocalDateTime.now();

    private List<String> message;

}
