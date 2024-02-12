package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasketPage;
import pages.MainPage;
import pages.ProductPage;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public MainPage mainPage = new MainPage(driver);
    public ProductPage productPage = new ProductPage(driver);
    public BasketPage basketPage = new BasketPage(driver);
    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Dimension dimension = new Dimension(1920, 1080);
        driver.manage().window().setSize(dimension);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
    }
    @AfterAll
    static void close() {
        driver.quit();
    }
}
