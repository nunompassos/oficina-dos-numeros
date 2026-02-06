package pt.oficinadosnumeros.api.error;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import pt.oficinadosnumeros.api.dto.ErrorResponse;
import pt.oficinadosnumeros.domain.exception.PredictionModelNotFoundException;

import java.time.Instant;

@Produces
@Singleton
public class PredictionModelNotFoundHandler
    implements ExceptionHandler<PredictionModelNotFoundException, HttpResponse<ErrorResponse>> {

    @Override
    public HttpResponse<ErrorResponse> handle(
        HttpRequest request,
        PredictionModelNotFoundException exception
    ) {
        ErrorResponse error = new ErrorResponse(
            404,
            "Not Found",
            exception.getMessage(),
            request.getPath(),
            Instant.now(),
            null
        );

        return HttpResponse.notFound(error);
    }
}
