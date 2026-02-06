package pt.oficinadosnumeros.service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import jakarta.inject.Singleton;
import pt.oficinadosnumeros.domain.exception.PredictionModelNotFoundException;
import pt.oficinadosnumeros.domain.model.PredictionContext;
import pt.oficinadosnumeros.domain.model.PredictionModel;
import pt.oficinadosnumeros.domain.model.PredictionResult;

@Singleton
public class PredictionService {

    private final Map<String, PredictionModel> models;

    public PredictionService(List<PredictionModel> availableModels) {
        this.models = availableModels.stream()
            .collect(Collectors.toMap(
                PredictionModel::id,
                Function.identity()
            ));
    }

    /**
     * Lista todos os modelos disponíveis.
     */
    public List<PredictionModel> availableModels() {
        return List.copyOf(models.values());
    }

    /**
     * Executa uma previsão usando o modelo indicado.
     */
    public PredictionResult predict(String modelId, PredictionContext context) {
        PredictionModel model = models.get(modelId);

        if (model == null) {
            throw new PredictionModelNotFoundException(modelId);
        }

        return model.predict(context);
    }
}
