package program1;

public class MaxFactorialException extends Exception {
    public MaxFactorialException() {
        super("Функция не считает больше, чем (20!)");
    }
}
