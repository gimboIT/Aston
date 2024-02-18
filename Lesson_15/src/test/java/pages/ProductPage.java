package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductPage {
    protected WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    By finalPrice = By.cssSelector(".price-block__final-price");

    public double getFinalPrice() {
        String price = driver.findElement(finalPrice).getAttribute("textContent");
        return Double.parseDouble(price.replaceAll("[^0-9.]+", ""));
    }
}
