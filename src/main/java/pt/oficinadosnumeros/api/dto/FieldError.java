package pt.oficinadosnumeros.api.dto;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record FieldError(
    String field,
    String message
) {
}
