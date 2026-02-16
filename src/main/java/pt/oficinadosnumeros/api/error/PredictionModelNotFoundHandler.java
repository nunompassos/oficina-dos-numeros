package pt.oficinadosnumeros.api.error;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import pt.oficinadosnumeros.api.problem.ProblemDetail;
import pt.oficinadosnumeros.domain.exception.PredictionModelNotFoundException;

@Produces(MediaType.APPLICATION_JSON_PROBLEM)
@Singleton
public class PredictionModelNotFoundHandler
    implements ExceptionHandler<PredictionModelNotFoundException, HttpResponse<ProblemDetail>> {

    @Override
    public HttpResponse<ProblemDetail> handle(
        HttpRequest request,
        PredictionModelNotFoundException exception
    ) {

        ProblemDetail problem = new ProblemDetail(
            "https://oficinadosnumeros.pt/problems/model-not-found",
            "Not Found",
            404,
            exception.getMessage(),
            request.getPath(),
            null
        );

        return HttpResponse
            .notFound(problem)
            .contentType(MediaType.APPLICATION_JSON_PROBLEM);
    }
}

