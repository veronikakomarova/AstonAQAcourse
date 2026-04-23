import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import program3.ArithmeticOperations;
import program3.CalculateOperations;
import program3.UnknownOperationException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArithmaticOperationsTest {

    @DisplayName("Вычисление с допустимыми операциями")
    @ParameterizedTest
    @CsvSource({
            "2, 2, PLUS, 4",
            "5, 3, MINUS, 2",
            "3, 3, MULTIPLY, 9",
            "12, 3, DIVIDE, 4"})
    void arithmeticOperationsTest(int left, int right, String operationName, double expected) throws UnknownOperationException {
        CalculateOperations operation = CalculateOperations.valueOf(operationName);
        double result = ArithmeticOperations.calculate(left, right, operation);
        assertEquals(expected, result);
    }

    @DisplayName("Вычисление с null операцией")
    @Test
    void nullOperationThrowsExceptionTest() {
        assertThrows(UnknownOperationException.class, () -> ArithmeticOperations.calculate(4, 5, null));
    }

    @DisplayName("Вычисление с неподдерживаемой операцией")
    @Test
    void unsupportedOperationThrowsExceptionTest() {
        assertThrows(UnknownOperationException.class, () -> ArithmeticOperations.calculate(4, 5, CalculateOperations.OTHER));
    }
}
