import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import program4.Compare;
import program4.CompareResult;

public class CompareTest extends Assert {

    @DataProvider
    public Object[][] getTestData() {
        return new Object[][]{
                {7, 7, CompareResult.EQUAL},
                {8, 2, CompareResult.MORE},
                {1, 9, CompareResult.LESS}};
    }

    @Test(description = "Сравнение двух чисел", dataProvider = "getTestData")
    public void compareResultTest(int left, int right, CompareResult expected) {
        CompareResult result = Compare.compareResult(left, right);
        assertEquals(result, expected);
    }
}