package pt.oficinadosnumeros.api.filter;

import java.util.UUID;

import org.reactivestreams.Publisher;
import org.slf4j.MDC;

import io.micronaut.core.async.publisher.Publishers;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.filter.HttpServerFilter;
import io.micronaut.http.filter.ServerFilterChain;
import jakarta.inject.Singleton;

@Filter("*/**")
@Singleton
public class CorrelationIdFilter implements HttpServerFilter {

    public static final String CORRELATION_ID_HEADER = "X-Correlation-Id";

    @Override
    public Publisher<MutableHttpResponse<?>> doFilter(
        HttpRequest<?> request,
        ServerFilterChain chain
    ) {
        String correlationId = request.getHeaders()
            .get(CORRELATION_ID_HEADER, String.class).orElse(UUID.randomUUID().toString());

        MDC.put("correlationId", correlationId);
        request.setAttribute("correlationId", correlationId);

        try {
            return Publishers.map(
                chain.proceed(request),
                response -> {
                    response.getHeaders().add(CORRELATION_ID_HEADER, correlationId);
                    return response;
                }
            );
        } finally {
            MDC.remove("correlationId");
        }
    }
}
