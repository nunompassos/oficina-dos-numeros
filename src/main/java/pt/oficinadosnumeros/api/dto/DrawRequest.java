package pt.oficinadosnumeros.api.dto;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Serdeable
public record DrawRequest(

    @NotEmpty
    List<Integer> numbers,

    @NotEmpty
    List<Integer> stars
) {
}
