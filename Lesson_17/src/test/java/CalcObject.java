import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;

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

    @Step("Click on 2")
    public CalcObject clickOn2() {
        driver.findElementById(digit2).click();
        return this;
    }

    @Step("Click on 3")
    public CalcObject clickOn3() {
        driver.findElementById(digit3).click();
        return this;
    }

    @Step("Click on +")
    public CalcObject clickOnPlus() {
        driver.findElementById(plus).click();
        return this;
    }

    @Step("Click on -")
    public CalcObject clickOnMinus() {
        driver.findElementById(minus).click();
        return this;
    }

    @Step("Click on /")
    public CalcObject clickOnDivision() {
        driver.findElementById(division).click();
        return this;
    }

    @Step("Click on *")
    public CalcObject clickOnMultiplication() {
        driver.findElementById(multiplication).click();
        return this;
    }

    @Step("Click on =")
    public CalcObject clickOnEquals() {
        driver.findElementById(equals).click();
        return this;
    }

    public String getResult() {
        return driver.findElementById(result).getText();
    }
}
