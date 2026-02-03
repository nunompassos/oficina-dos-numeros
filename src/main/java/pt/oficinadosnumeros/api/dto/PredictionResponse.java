package pt.oficinadosnumeros.api.dto;

import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record PredictionResponse(
    String model,
    List<Integer> numbers,
    List<Integer> stars
) {
}
