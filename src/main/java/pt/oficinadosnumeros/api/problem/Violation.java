package pt.oficinadosnumeros.api.problem;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Violation(
    String field,
    String message
) {}
