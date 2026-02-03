package pt.oficinadosnumeros.domain.model;

import java.util.List;

public record PredictionContext(
    List<DrawResult> historicalDraws
) {
}
