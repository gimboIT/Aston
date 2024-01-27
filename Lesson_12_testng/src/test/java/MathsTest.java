import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MathsTest {

    @DataProvider(name = "factorialData")
    public Object[][] factorialData() {
        return new Object[][]{
                {1, 1},
                {2, 2},
                {3, 6},
                {4, 24},
                {5, 120}
        };
    }

    @Test(dataProvider = "factorialData")
    public void testGetFactorial(int number, int result) {
        assertEquals(Maths.getFactorial(number), result);
    }
}