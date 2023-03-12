package com.example.MyBookShopApp.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartPage {

    private String url = "http://localhost:8085/";
    private ChromeDriver driver;

    public CartPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public CartPage callPage() {
        driver.get(url);
        return this;
    }

    public CartPage pause() throws InterruptedException {
        Thread.sleep(2000);
        return this;
    }

    public CartPage setUpSearchToken(String token) {
        WebElement element = driver.findElement(By.id("query"));
        element.sendKeys(token);
        return this;
    }

    public CartPage submit() {
        WebElement element = driver.findElement(By.id("search"));
        element.submit();
        return this;
    }
}
