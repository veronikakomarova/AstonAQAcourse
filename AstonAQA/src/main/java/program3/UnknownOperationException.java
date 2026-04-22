package program3;

class UnknownOperationException extends Exception {
    UnknownOperationException() {
        super("Недопустимая операция.");
    }
}
