import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import program2.AreaOfTriangle;

import static org.junit.jupiter.api.Assertions.*;

public class AreaOfTriangleTest {
    @DisplayName("Вычисление площади треугольника")
    @ParameterizedTest
    @CsvSource({
            "3, 4, 5, 6.000, 3",
            "4, 7, 10, 10.9, 1",
            "10, 15, 20, 72.618, 3",
            "13, 14, 15, 84, 0"
    })
    void areaOfTriangleRoundedTest(int a, int b, int c, double expected, int occurancy) {
        double result = AreaOfTriangle.areaOfTriangle(a, b, c);
        double rounded = round(result, occurancy);
        assertEquals(expected, rounded);
    }

    private static double round(double value, int places) {
        double factor = Math.pow(10, places);
        return Math.round(value * factor) / factor;
    }
}
