package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class WildberriesTest extends BaseTest {

    @Test
    void basketTest() {

        mainPage.openMainPage();
        mainPage.addFirstProduct();
        String firstProductName = mainPage.getFirstProductName();
        mainPage.openFirstProd();
        Double firstProductPrice = productPage.getFinalPrice();
        BaseTest.driver.navigate().back();
        mainPage.addSecondProduct();
        String secondProductName = mainPage.getSecondProductName();
        mainPage.openSecondProd();
        Double secondProductPrice = productPage.getFinalPrice();

        mainPage.goBasketPage();

        HashMap<String, Double> map = basketPage.getProducts();

        double sumInBasket = basketPage.getSum();

        assertTrue(map.containsKey(firstProductName));
        assertTrue(map.containsKey(secondProductName));
        assertTrue(map.containsValue(firstProductPrice));
        assertTrue(map.containsValue(secondProductPrice));
        assertEquals(2, basketPage.getProducts().size());
        assertEquals(sumInBasket, firstProductPrice + secondProductPrice);
    }
}
