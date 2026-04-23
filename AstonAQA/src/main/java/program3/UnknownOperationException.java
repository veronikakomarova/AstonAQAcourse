package program3;

public class UnknownOperationException extends Exception {
    UnknownOperationException() {
        super("Недопустимая операция.");
    }
}
