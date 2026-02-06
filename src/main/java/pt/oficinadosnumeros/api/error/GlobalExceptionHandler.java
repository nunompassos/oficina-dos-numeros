package pt.oficinadosnumeros.api.error;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import pt.oficinadosnumeros.api.dto.ErrorResponse;

import java.time.Instant;

@Produces
@Singleton
public class GlobalExceptionHandler
    implements ExceptionHandler<Exception, HttpResponse<ErrorResponse>> {

    @Override
    public HttpResponse<ErrorResponse> handle(
        HttpRequest request,
        Exception exception
    ) {
        ErrorResponse error = new ErrorResponse(
            500,
            "Internal Server Error",
            "Unexpected error occurred",
            request.getPath(),
            Instant.now(),
            null
        );

        return HttpResponse.serverError(error);
    }
}
