import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalcTest extends BaseTest{

    @Test
    void AdditionTest() {
        String result = calcObject
                .clickOn3()
                .clickOnPlus()
                .clickOn2()
                .clickOnEquals()
                .getResult();
        assertEquals("5", result);
    }

    @Test
    void subtractionTest() {
        String result = calcObject
                .clickOn3()
                .clickOnMinus()
                .clickOn2()
                .clickOnEquals()
                .getResult();
        assertEquals("1", result);
    }

    @Test
    void multiplicationTest() {
        String result = calcObject
                .clickOn3()
                .clickOnMultiplication()
                .clickOn2()
                .clickOnEquals()
                .getResult();
        assertEquals("6", result);
    }

    @Test
    void divisionTest() {
        String result = calcObject
                .clickOn3()
                .clickOnDivision()
                .clickOn2()
                .clickOnEquals()
                .getResult();
        assertEquals("1.5", result);
    }
}