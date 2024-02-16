import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class CalcTest extends BaseTest{

    @Test
    @DisplayName("Test +")
    @Severity(SeverityLevel.BLOCKER)
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
    @DisplayName("Test -")
    @Severity(SeverityLevel.BLOCKER)
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
    @DisplayName("Test *")
    @Severity(SeverityLevel.BLOCKER)
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
    @DisplayName("Test /")
    @Severity(SeverityLevel.BLOCKER)
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