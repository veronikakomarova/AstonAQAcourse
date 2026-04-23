import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import program1.FactorialCalculator;
import program1.MaxFactorialException;
import program1.NegativeFactorialException;

public class FactorialTest extends Assert {
    @DataProvider
    public Object[][] getTestData() {
        return new Object[][]{
                {0, 1},
                {1, 1},
                {5, 120},
                {20, 2432902008176640000L}};
    }

    @Test(description = "Вычисление факториала", dataProvider = "getTestData")
    public void factorialCalculatorPositiveTest(int argument, long expected) throws Exception{
        var result = FactorialCalculator.factorial(argument);
        assertEquals(result, expected);
    }


    @Test(description = "Вычисление факториала с отрицательным значением", expectedExceptions = NegativeFactorialException.class)
    public void factorialNegativeThrowsExceptionTest() throws Exception {
        FactorialCalculator.factorial(-2);
    }


    @Test(description = "Вычисление факториала со слишком большим значением", expectedExceptions = MaxFactorialException.class)
    public void factorialTooLongExceptionTest() throws Exception {
        FactorialCalculator.factorial(21);
    }
}
