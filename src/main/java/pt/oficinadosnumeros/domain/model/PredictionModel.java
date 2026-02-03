package pt.oficinadosnumeros.domain.model;

public interface PredictionModel {

    /**
     * Nome legível do modelo (ex: "Frequência Histórica")
     */
    String name();

    /**
     * Identificador técnico do modelo (ex: "frequency")
     */
    String id();

    /**
     * Executa a previsão com base num contexto.
     */
    PredictionResult predict(PredictionContext context);
}
