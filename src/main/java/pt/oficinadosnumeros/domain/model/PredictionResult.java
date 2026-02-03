package pt.oficinadosnumeros.domain.model;

import java.util.List;

public record PredictionResult(
    List<Integer> numbers,
    List<Integer> stars,
    String modelName
) {
}
