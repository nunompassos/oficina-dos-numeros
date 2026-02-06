package pt.oficinadosnumeros.domain.exception;

public class PredictionModelNotFoundException extends RuntimeException {

    public PredictionModelNotFoundException(String modelId) {
        super("Prediction model not found: " + modelId);
    }
}
