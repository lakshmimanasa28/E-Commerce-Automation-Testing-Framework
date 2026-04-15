package com.srm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    By cartMenu = By.xpath("//a[@href='/view_cart']");
    By proceedToCheckoutBtn = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
    By loginLink = By.xpath("//u[text()='Register / Login']");

    public void openCart() {
        driver.findElement(cartMenu).click();
    }

    public void clickProceedToCheckout() {
        driver.findElement(proceedToCheckoutBtn).click();
    }

    public void clickRegisterLogin() {
        driver.findElement(loginLink).click();
    }
}