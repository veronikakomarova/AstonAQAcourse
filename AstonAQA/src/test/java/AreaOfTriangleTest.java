import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import program2.AreaOfTriangle;

public class AreaOfTriangleTest extends Assert {
    @DataProvider
   public Object[][] getTestData(){
        return new Object[][]{
                {3, 4, 5, 6.000, 3},
                {4, 7, 10, 10.9, 1},
                {10, 15, 20, 72.618, 3},
                {13, 14, 15, 84, 0}};
        }

    @Test(description = "Вычисление площади треугольника", dataProvider = "getTestData")
    void areaOfTriangleRoundedTest(int a, int b, int c, double expected, int occurancy) {
        double result = AreaOfTriangle.areaOfTriangle(a, b, c);
        double rounded = round(result, occurancy);
        assertEquals(rounded, expected, 0.001);
    }

    private static double round(double value, int places) {
        double factor = Math.pow(10, places);
        return Math.round(value * factor) / factor;
    }
}
