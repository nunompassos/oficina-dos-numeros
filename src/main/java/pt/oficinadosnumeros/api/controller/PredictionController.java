package pt.oficinadosnumeros.api.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import jakarta.validation.Valid;
import pt.oficinadosnumeros.api.dto.*;
import pt.oficinadosnumeros.domain.model.DrawResult;
import pt.oficinadosnumeros.domain.model.PredictionContext;
import pt.oficinadosnumeros.domain.model.PredictionResult;
import pt.oficinadosnumeros.service.PredictionService;

import java.util.List;

@Controller("/predictions")
public class PredictionController {

    private final PredictionService predictionService;

    public PredictionController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }

    @Post(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public PredictionResponse createPrediction(@Body @Valid PredictionRequest request) {

        List<DrawResult> draws = request.historicalDraws().stream()
            .map(draw -> new DrawResult(
                draw.numbers(),
                draw.stars()
            ))
            .toList();

        PredictionContext context = new PredictionContext(draws);

        PredictionResult result = predictionService.predict(
            request.modelId(),
            context
        );

        return new PredictionResponse(
            result.modelName(),
            result.numbers(),
            result.stars()
        );
    }
}
