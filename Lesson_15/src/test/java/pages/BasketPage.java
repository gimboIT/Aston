package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

import static java.lang.Thread.sleep;

public class BasketPage {

    By
            basketSum = By.cssSelector(".b-right"),
            productName = By.cssSelector(".good-info__good-name"),
            productPrice = By.cssSelector(".list-item__price-new"),
            products = By.cssSelector(".accordion__list-item");
    HashMap<String, Double> basketProducts = new HashMap<>();

    protected WebDriver driver;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    public HashMap<String, Double> getProducts() {
        addProducts();
        return basketProducts;
    }

    public void addProducts() {
        waitPriceCounting(1500);
        driver.findElements(products).forEach(
                x -> {
                    String prodName = x.findElement(productName).getText();
                    String priceD = x.findElement(productPrice).getText();
                    Double price = Double.parseDouble(priceD.replaceAll("[^0-9.]+", ""));
                    basketProducts.put(prodName, price);
                }
        );
    }
    public double getSum() {
        String sum = driver.findElement(basketSum).getText();
        return Double.parseDouble(sum.replaceAll("[^0-9.]+", ""));
    }

    public void waitPriceCounting(int time) {
        try {
            sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}