package pt.oficinadosnumeros.api.error;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import jakarta.validation.ConstraintViolationException;
import pt.oficinadosnumeros.api.dto.ErrorResponse;
import pt.oficinadosnumeros.api.dto.FieldError;

import java.time.Instant;
import java.util.List;

@Produces
@Singleton
public class ValidationExceptionHandler
    implements ExceptionHandler<ConstraintViolationException, HttpResponse<ErrorResponse>> {

    @Override
    public HttpResponse<ErrorResponse> handle(
        HttpRequest request,
        ConstraintViolationException exception
    ) {
        List<FieldError> fields = exception.getConstraintViolations().stream()
            .map(v -> new FieldError(
                v.getPropertyPath().toString(),
                v.getMessage()
            ))
            .toList();

        ErrorResponse error = new ErrorResponse(
            400,
            "Bad Request",
            "Validation failed",
            request.getPath(),
            Instant.now(),
            fields
        );

        return HttpResponse.badRequest(error);
    }
}
