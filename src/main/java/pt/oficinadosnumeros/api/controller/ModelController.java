package pt.oficinadosnumeros.api.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import pt.oficinadosnumeros.api.dto.ModelResponse;
import pt.oficinadosnumeros.service.PredictionService;

import java.util.List;

@Controller("/models")
public class ModelController {

    private final PredictionService predictionService;

    public ModelController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public List<ModelResponse> listModels() {
        return predictionService.availableModels()
            .stream()
            .map(model -> new ModelResponse(
                model.id(),
                model.name()
            ))
            .toList();
    }
}
