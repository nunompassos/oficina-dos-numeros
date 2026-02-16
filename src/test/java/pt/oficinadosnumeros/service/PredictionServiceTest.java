package pt.oficinadosnumeros.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

import pt.oficinadosnumeros.domain.exception.PredictionModelNotFoundException;
import pt.oficinadosnumeros.domain.model.PredictionContext;
import pt.oficinadosnumeros.domain.model.PredictionModel;
import pt.oficinadosnumeros.domain.model.PredictionResult;

class PredictionServiceTest {

    @Test
    void shouldSelectCorrectModel() {

        PredictionModel mockModel = mock(PredictionModel.class);
        when(mockModel.id()).thenReturn("mock");
        when(mockModel.name()).thenReturn("Mock Model");
        when(mockModel.predict(any()))
            .thenReturn(new PredictionResult(
                List.of(1, 2, 3, 4, 5),
                List.of(1,2),
                "Mock Model"
            ));

        PredictionService service =
            new PredictionService(List.of(mockModel));

        PredictionResult result =
            service.predict("mock",
                            new PredictionContext(List.of()));

        assertEquals("Mock Model", result.modelName());
    }

    @Test
    void shouldThrowWhenModelNotFound() {

        PredictionService service =
            new PredictionService(List.of());

        assertThrows(
            PredictionModelNotFoundException.class,
            () -> service.predict("invalid",
                                  new PredictionContext(List.of()))
        );
    }
}

