package pt.oficinadosnumeros.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class FrequencyPredictionModelTest {

    private final FrequencyPredictionModel model =
        new FrequencyPredictionModel();

    @Test
    void shouldReturnFiveNumbersAndTwoStars() {

        PredictionContext context = new PredictionContext(
            List.of(
                new DrawResult(List.of(1,2,3,4,5), List.of(1,2)),
                new DrawResult(List.of(1,2,3,6,7), List.of(2,3))
            )
        );

        PredictionResult result = model.predict(context);

        assertEquals(5, result.numbers().size());
        assertEquals(2, result.stars().size());
    }
}

