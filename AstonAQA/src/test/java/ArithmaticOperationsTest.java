import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import program3.ArithmeticOperations;
import program3.CalculateOperations;
import program3.UnknownOperationException;

public class ArithmaticOperationsTest extends Assert {

    @DataProvider
    public Object[][] getTestData() {
        return new Object[][]{
                {2, 2, CalculateOperations.PLUS, 4},
                {5, 3, CalculateOperations.MINUS, 2},
                {3, 3, CalculateOperations.MULTIPLY, 9},
                {12, 3, CalculateOperations.DIVIDE, 4}};
    }

    @Test(description = "Вычисление с допустимыми операциями", dataProvider = "getTestData")
    public void arithmeticOperationsTest(int left, int right, CalculateOperations operation, double expected) throws UnknownOperationException {
        double result = ArithmeticOperations.calculate(left, right, operation);
        assertEquals(result, expected);
    }


    @Test(description = "Вычисление с null операцией", expectedExceptions = UnknownOperationException.class)
   public void nullOperationThrowsExceptionTest() throws UnknownOperationException{
        ArithmeticOperations.calculate(4, 5, null);
    }


    @Test(description = "Вычисление с неподдерживаемой операцией", expectedExceptions = UnknownOperationException.class)
   public void unsupportedOperationThrowsExceptionTest() throws UnknownOperationException{
        ArithmeticOperations.calculate(4, 5, CalculateOperations.OTHER);
    }
}
