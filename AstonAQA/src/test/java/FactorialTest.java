import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import program1.FactorialCalculator;
import program1.MaxFactorialException;
import program1.NegativeFactorialException;

import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {
    @DisplayName("Вычисление факториала")
    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 1",
            "5, 120",
            "20, 2432902008176640000"
    })
    void factorialCalculatorPositiveTest(int argument, long expected) throws MaxFactorialException, NegativeFactorialException {
        var result = FactorialCalculator.factorial(argument);
        assertEquals(expected, result);
    }

    @DisplayName("Вычисление факториала с отрицательным значением")
    @Test
    void factorialNegativeThrowsExceptionTest(){
        assertThrows(NegativeFactorialException.class, () -> FactorialCalculator.factorial(-2));
    }

    @DisplayName("Вычисление факториала со слишком большим значением")
    @Test
    void factorialTooLongExceptionTest(){
        assertThrows(MaxFactorialException.class, () -> FactorialCalculator.factorial(21));
    }
}
