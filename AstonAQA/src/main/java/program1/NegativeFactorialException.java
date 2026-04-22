package program1;

public class NegativeFactorialException extends Exception {
    public NegativeFactorialException() {
        super("Нельзя посчитать факториал отрицательного числа.");
    }
}
