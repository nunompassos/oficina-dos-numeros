package pt.oficinadosnumeros.api.problem;

import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record ProblemDetail(
    String type,
    String title,
    int status,
    String detail,
    String instance,
    String correlationId,
    List<Violation> errors
) {}
