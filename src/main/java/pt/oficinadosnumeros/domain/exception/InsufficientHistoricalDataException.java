package pt.oficinadosnumeros.domain.exception;

public class InsufficientHistoricalDataException extends RuntimeException {

    public InsufficientHistoricalDataException() {
        super("Insufficient historical data to generate prediction");
    }
}
