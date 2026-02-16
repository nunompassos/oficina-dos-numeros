package pt.oficinadosnumeros.api.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import pt.oficinadosnumeros.api.dto.PredictionResponse;

@MicronautTest
class PredictionControllerIntegrationTest {

    @Inject
    @Client("/")
    HttpClient client;

    // -----------------------------
    // ✅ HAPPY PATH
    // -----------------------------
    @Test
    void shouldReturnPredictionSuccessfully() {

        String body = """
            {
              "modelId": "frequency",
              "historicalDraws": [
                { "numbers": [1,2,3,4,5], "stars": [1,2] },
                { "numbers": [1,2,3,6,7], "stars": [2,3] }
              ]
            }
            """;

        HttpRequest<String> request =
            HttpRequest.POST("/predictions", body)
                .contentType(MediaType.APPLICATION_JSON);

        HttpResponse<PredictionResponse> response =
            client.toBlocking().exchange(request, PredictionResponse.class);

        assertEquals(HttpStatus.OK, response.getStatus());
        assertNotNull(response.body());
        assertEquals(5, response.body().numbers().size());
        assertEquals(2, response.body().stars().size());
    }

    // -----------------------------
    // ❌ MODEL NOT FOUND
    // -----------------------------
    @Test
    void shouldReturn404WhenModelDoesNotExist() {

        String body = """
            {
              "modelId": "invalid-model",
              "historicalDraws": [
                { "numbers": [1,2,3,4,5], "stars": [1,2] }
              ]
            }
            """;

        HttpRequest<String> request =
            HttpRequest.POST("/predictions", body)
                .contentType(MediaType.APPLICATION_JSON);

        HttpClientResponseException exception =
            assertThrows(HttpClientResponseException.class, () ->
                client.toBlocking().exchange(request, String.class)
            );

        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
        assertTrue(exception.getResponse().getBody(String.class).orElse("")
                       .contains("Prediction model not found"));
    }

    // -----------------------------
    // ❌ VALIDATION ERROR
    // -----------------------------
    @Test
    void shouldReturn400WhenValidationFails() {

        String body = """
            {
              "modelId": "",
              "historicalDraws": []
            }
            """;

        HttpRequest<String> request =
            HttpRequest.POST("/predictions", body)
                .contentType(MediaType.APPLICATION_JSON);

        HttpClientResponseException exception =
            assertThrows(HttpClientResponseException.class, () ->
                client.toBlocking().exchange(request, String.class)
            );

        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
        assertTrue(exception.getResponse().getBody(String.class).orElse("")
                       .contains("Validation failed"));
    }
}
