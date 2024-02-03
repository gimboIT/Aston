import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnlinePaymentTest {

    static WebDriver driver;
    String phoneNumber = "297777777";
    String amount = "100.00";
    String email = "test@mail.ru";
    String code = "375";

    @BeforeAll
    static void configAndRemoveCookie() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        driver.findElement(By.cssSelector("#cookie-agree")).click();
    }

    @BeforeEach
    void openSite() {
        driver.get("https://www.mts.by/");
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }

    @Test
    @DisplayName("Проверяем название блока")
    void nameTest() {
        WebElement blockTitle = driver.findElement(By.cssSelector("section.pay h2"));

        assertEquals(blockTitle.getText(), "Онлайн пополнение\nбез комиссии");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Visa",
            "Verified By Visa",
            "MasterCard",
            "MasterCard Secure Code",
            "Белкарт",
            "МИР"
    })
    @DisplayName("Проверяем наличие логотипов платёжных систем")
    void logoTest(String partner) {
        WebElement logoElement = driver.findElement(By.xpath("//img[@alt='" + partner + "']"));
        logoElement.isDisplayed();
    }

    @Test
    @DisplayName("Проверяем работу ссылки «Подробнее о сервисе»")
    void aboutServiceTest() {
        WebElement link = driver.findElement(By.cssSelector("a[href='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']"));
        link.click();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Проверка что кнопка «Продолжить» работает (проверяем только вариант «Услуги связи»")
    void buttonContinueTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.findElement(By.cssSelector("#connection-phone")).sendKeys(phoneNumber);
        driver.findElement(By.cssSelector("#connection-sum")).sendKeys(amount);
        driver.findElement(By.cssSelector("#connection-email")).sendKeys(email);

        driver.findElement(By.cssSelector(".pay__forms")).findElement(By.cssSelector("button")).click();

        WebElement iframe = driver.findElement(By.cssSelector(".bepaid-iframe"));
        driver.switchTo().frame(iframe);

        driver.findElement(By.cssSelector(".app-wrapper__content")).isEnabled();
    }

    @Test
    void emptyFieldsCommunicationServicesTest() {
        WebElement phoneElement = driver.findElement(By.id("connection-phone"));
        String placeholderText = phoneElement.getAttribute("placeholder");

        WebElement amountElement = driver.findElement(By.id("connection-sum"));
        String amount = amountElement.getAttribute("placeholder");

        WebElement emailElement = driver.findElement(By.id("connection-email"));
        String email = emailElement.getAttribute("placeholder");

        assertEquals("Номер телефона", placeholderText);
        assertEquals("Сумма", amount);
        assertEquals("E-mail для отправки чека", email);
    }

    @Test
    void emptyFieldsHomeInternetTest() {
        WebElement phoneElement = driver.findElement(By.id("internet-phone"));
        String placeholderText = phoneElement.getAttribute("placeholder");

        WebElement amountElement = driver.findElement(By.id("internet-sum"));
        String amount = amountElement.getAttribute("placeholder");

        WebElement emailElement = driver.findElement(By.id("internet-email"));
        String email = emailElement.getAttribute("placeholder");

        assertEquals("Номер абонента", placeholderText);
        assertEquals("Сумма", amount);
        assertEquals("E-mail для отправки чека", email);
    }

    @Test
    void emptyFieldsInstallmentTest() {
        WebElement phoneElement = driver.findElement(By.id("score-instalment"));
        String placeholderText = phoneElement.getAttribute("placeholder");

        WebElement amountElement = driver.findElement(By.id("instalment-sum"));
        String amount = amountElement.getAttribute("placeholder");

        WebElement emailElement = driver.findElement(By.id("instalment-email"));
        String email = emailElement.getAttribute("placeholder");

        assertEquals("Номер счета на 44", placeholderText);
        assertEquals("Сумма", amount);
        assertEquals("E-mail для отправки чека", email);
    }

    @Test
    void communicationServicesTest() {
        WebElement phoneElement = driver.findElement(By.id("score-arrears"));
        String placeholderText = phoneElement.getAttribute("placeholder");

        WebElement amountElement = driver.findElement(By.id("arrears-sum"));
        String amount = amountElement.getAttribute("placeholder");

        WebElement emailElement = driver.findElement(By.id("arrears-email"));
        String email = emailElement.getAttribute("placeholder");

        assertEquals("Номер счета на 2073", placeholderText);
        assertEquals("Сумма", amount);
        assertEquals("E-mail для отправки чека", email);
    }

    @Test
    void emptyFieldsArrearsTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        driver.findElement(By.cssSelector("#connection-phone")).sendKeys(phoneNumber);
        driver.findElement(By.cssSelector("#connection-sum")).sendKeys(amount);
        driver.findElement(By.cssSelector("#connection-email")).sendKeys(email);
        driver.findElement(By.cssSelector(".pay__forms")).findElement(By.cssSelector("button")).click();

        WebElement iframe = driver.findElement(By.cssSelector(".bepaid-iframe"));
        driver.switchTo().frame(iframe);
        Thread.sleep(3000);

        String amountInHeaderWithCurrency = driver.findElement(By.cssSelector(".header__payment-amount")).getText();
        String amountInHeader = amountInHeaderWithCurrency.replaceAll("[^0-9.]", "");

        String amountOnButtonWithCurrency = driver.findElement(By.cssSelector(".colored")).getText();
        String amountOnButton = amount.replaceAll("[^0-9.]", "");
        String info = driver.findElement(By.cssSelector(".header__payment-info")).getText();
        String phone = info.replaceAll("[^0-9.]", "");

        String masterCardSrcLink = driver.findElement(By.cssSelector("img[src*='mastercard-system.svg']")).getAttribute("src");
        String visaSrcLink = driver.findElement(By.cssSelector("img[src*='visa-system.svg']")).getAttribute("src");
        String belkartSrcLink = driver.findElement(By.cssSelector("img[src*='belkart-system.svg']")).getAttribute("src");
        String mirSrcLink = driver.findElement(By.cssSelector("img[src*='mir-system-ru.svg']")).getAttribute("src");
        String maestroSrcLink = driver.findElement(By.cssSelector("img[src*='maestro-system.svg']")).getAttribute("src");

        driver.findElement(By.xpath("//label[contains(text(), 'Номер карты')]")).isDisplayed();
        driver.findElement(By.xpath("//label[contains(text(), 'Срок действия')]")).isDisplayed();
        driver.findElement(By.xpath("//label[contains(text(), 'CVC')]")).isDisplayed();
        driver.findElement(By.xpath("//label[contains(text(), 'Имя держателя (как на карте)')]")).isDisplayed();

        assertEquals(this.amount, amountInHeader);
        assertEquals(this.amount, amountOnButton);
        assertEquals(code + phoneNumber, phone);
        assertEquals("https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/mastercard-system.svg", masterCardSrcLink);
        assertEquals("https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/visa-system.svg", visaSrcLink);
        assertEquals("https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/belkart-system.svg", belkartSrcLink);
        assertEquals("https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/mir-system-ru.svg", mirSrcLink);
        assertEquals("https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/maestro-system.svg", maestroSrcLink);
    }
}
