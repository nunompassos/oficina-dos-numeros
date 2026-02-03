package pt.oficinadosnumeros.api.dto;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Serdeable
public record PredictionRequest(

    @NotBlank
    String modelId,

    @NotEmpty
    List<DrawRequest> historicalDraws
) {
}
