package pt.oficinadosnumeros.api;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.Map;

@Controller("/health")
public class HealthController {

    @Get(produces = MediaType.APPLICATION_JSON)
    public Map<String, String> health() {
        return Map.of(
            "status", "UP",
            "application", "Oficina dos Números"
        );
    }
}
