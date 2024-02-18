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
import static org.junit.jupiter.api.Assertions.assertTrue;

class OnlinePaymentTest {

    static WebDriver driver;
    String phoneNumber = "297777777";
    String amount = "100";
    String email = "test@mail.ru";

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
    @ValueSource(strings = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт", "МИР"})
    @DisplayName("Проверяем наличие логотипов платёжных систем")
    void logoTest(String partner) {
        WebElement logoElement = driver.findElement(By.xpath("//img[@alt='" + partner + "']"));
        assertTrue(logoElement.isDisplayed());
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

        assertTrue(driver.findElement(By.cssSelector(".app-wrapper__content")).isEnabled());
    }
}
