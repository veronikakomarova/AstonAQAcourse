import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import program4.Compare;
import program4.CompareResult;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompareTest {

    @DisplayName("Сравнение двух чисел")
    @ParameterizedTest
    @CsvSource({
            "7, 7, EQUAL",
            "8, 2, MORE",
            "1, 9, LESS"})
    void compareResultTest(int left, int right, String expectedStr){
        CompareResult expected = CompareResult.valueOf(expectedStr);
        CompareResult result = Compare.compareResult(left, right);
        assertEquals(expected, result);
    }
}
