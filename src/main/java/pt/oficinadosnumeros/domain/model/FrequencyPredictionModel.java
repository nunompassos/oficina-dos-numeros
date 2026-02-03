package pt.oficinadosnumeros.domain.model;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import jakarta.inject.Singleton;

@Singleton
public class FrequencyPredictionModel implements PredictionModel {

    private static final int NUMBERS_COUNT = 5;
    private static final int STARS_COUNT = 2;

    @Override
    public String name() {
        return "Frequência Histórica";
    }

    @Override
    public String id() {
        return "frequency";
    }

    @Override
    public PredictionResult predict(PredictionContext context) {

        if (context.historicalDraws() == null || context.historicalDraws().isEmpty()) {
            throw new IllegalArgumentException("Historical draws are required for frequency prediction");
        }

        List<Integer> numbers = mostFrequent(
            context.historicalDraws().stream()
                .flatMap(draw -> draw.numbers().stream())
                .toList(),
            NUMBERS_COUNT
        );

        List<Integer> stars = mostFrequent(
            context.historicalDraws().stream()
                .flatMap(draw -> draw.stars().stream())
                .toList(),
            STARS_COUNT
        );

        return new PredictionResult(numbers, stars, name());
    }

    private List<Integer> mostFrequent(List<Integer> values, int limit) {
        return values.stream()
            .collect(Collectors.groupingBy(v -> v, Collectors.counting()))
            .entrySet()
            .stream()
            .sorted(
                Map.Entry.<Integer, Long>comparingByValue(Comparator.reverseOrder())
                    .thenComparing(Map.Entry.comparingByKey())
            )
            .limit(limit)
            .map(Map.Entry::getKey)
            .toList();
    }
}
