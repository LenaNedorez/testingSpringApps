package com.example.MyBookShopApp.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CartPageSeleniumTest {

    private static ChromeDriver driver;

    @BeforeAll
    static void setup(){
        System.setProperty("webdriver.chrome.driver","/Users/codewizard/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }

    @Test
    public void testCartPageAccess() throws InterruptedException {
        CartPage cartPage = new CartPage(driver);
        cartPage
                .callPage()
                .pause();

        assertTrue(driver.getPageSource().contains("Корзина"));
    }
}