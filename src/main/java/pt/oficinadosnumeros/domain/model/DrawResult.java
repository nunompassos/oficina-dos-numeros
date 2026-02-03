package pt.oficinadosnumeros.domain.model;

import java.util.List;

public record DrawResult(
    List<Integer> numbers,
    List<Integer> stars
) {
}
