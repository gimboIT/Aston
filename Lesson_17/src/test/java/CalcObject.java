import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CalcObject {
    String digit2 = "com.google.android.calculator:id/digit_2";
    String digit3 = "com.google.android.calculator:id/digit_3";
    String plus = "com.google.android.calculator:id/op_add";
    String minus = "com.google.android.calculator:id/op_sub";
    String division = "com.google.android.calculator:id/op_div";
    String multiplication = "com.google.android.calculator:id/op_mul";
    String result = "com.google.android.calculator:id/result_final";
    String equals = "com.google.android.calculator:id/eq";

    AndroidDriver<AndroidElement> driver;

    public CalcObject(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }


    public CalcObject clickOn2() {
        driver.findElementById(digit2).click();
        return this;
    }

    public CalcObject clickOn3() {
        driver.findElementById(digit3).click();
        return this;
    }

    public CalcObject clickOnPlus() {
        driver.findElementById(plus).click();
        return this;
    }

    public CalcObject clickOnMinus() {
        driver.findElementById(minus).click();
        return this;
    }

    public CalcObject clickOnDivision() {
        driver.findElementById(division).click();
        return this;
    }

    public CalcObject clickOnMultiplication() {
        driver.findElementById(multiplication).click();
        return this;
    }
    public CalcObject clickOnEquals() {
        driver.findElementById(equals).click();
        return this;
    }
    public String getResult() {
        return driver.findElementById(result).getText();
    }
}
