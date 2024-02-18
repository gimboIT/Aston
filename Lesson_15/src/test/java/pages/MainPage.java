package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class MainPage {

    protected WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    By
            firstProduct = By.cssSelector("article[data-card-index='0']"),
            secondProduct = By.cssSelector("article[data-card-index='1']"),
            addInBasketButton = By.cssSelector(".product-card__add-basket"),
            basketButton = By.cssSelector("[data-wba-header-name=\"Cart\"]"),
            productName = By.cssSelector(".product-card__name"),
            productSize = By.cssSelector(".product-card__sizes"),
            productSizeList = By.cssSelector(".sizes-list__item");

    public void openMainPage() {
        driver.get("https://www.wildberries.ru/");
    }

    public void addFirstProduct() {
        addProductInBasket(firstProduct);
    }

    public void addSecondProduct() {
        addProductInBasket(secondProduct);
    }

    public void addProductInBasket(By by) {
        WebElement product = driver.findElement(by);

        if (Objects.equals(product.findElement(productSize).getSize(), new Dimension(0, 0))) {
            product.findElement(addInBasketButton).click();
        } else {
            product.findElement(addInBasketButton).click();
            driver.findElement(productSizeList).click();
        }
    }

    public void goBasketPage() {
        driver.findElement(basketButton).click();
    }

    public String getFirstProductName() {
        String productName1 = driver.findElement(firstProduct).findElement(productName).getText();
        return productName1.substring(2);
    }

    public String getSecondProductName() {
        String productName2 = driver.findElement(secondProduct).findElement(productName).getText();
        return productName2.substring(2);
    }

    public void openFirstProd() {
        driver.findElement(firstProduct).click();
    }

    public void openSecondProd() {
        driver.findElement(secondProduct).click();
    }
}
