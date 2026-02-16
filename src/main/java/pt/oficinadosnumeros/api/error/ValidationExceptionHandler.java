package pt.oficinadosnumeros.api.error;

import io.micronaut.context.annotation.Replaces;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import io.micronaut.validation.exceptions.ConstraintExceptionHandler;
import jakarta.inject.Singleton;
import jakarta.validation.ConstraintViolationException;
import pt.oficinadosnumeros.api.problem.ProblemDetail;
import pt.oficinadosnumeros.api.problem.ProblemType;
import pt.oficinadosnumeros.api.problem.Violation;

@Produces(MediaType.APPLICATION_JSON_PROBLEM)
@Singleton
@Replaces(ConstraintExceptionHandler.class)
public class ValidationExceptionHandler
    implements ExceptionHandler<ConstraintViolationException, HttpResponse<ProblemDetail>> {

    @Override
    public HttpResponse<ProblemDetail> handle(
        HttpRequest request,
        ConstraintViolationException exception
    ) {

        var problemType = ProblemType.VALIDATION_ERROR;

        var violations = exception.getConstraintViolations()
            .stream()
            .map(v -> new Violation(
                v.getPropertyPath().toString(),
                v.getMessage()
            ))
            .toList();

        var correlationId = request.getAttribute("correlationId", String.class).orElse("N/A");

        ProblemDetail problem = new ProblemDetail(
            problemType.getTypeUri(),
            problemType.getTitle(),
            problemType.getStatus(),
            "Validation failed",
            request.getPath(),
            correlationId,
            violations
        );

        return HttpResponse
            .badRequest(problem)
            .contentType(MediaType.APPLICATION_JSON_PROBLEM);
    }
}
