package pt.oficinadosnumeros.api.dto;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ModelResponse(
    String id,
    String name
) {
}
