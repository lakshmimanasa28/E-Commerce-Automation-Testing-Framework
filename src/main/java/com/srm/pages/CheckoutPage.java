package com.srm.pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By commentBox = By.name("message");
    By placeOrderBtn = By.xpath("//a[contains(text(),'Place Order')]");

   
    By nameOnCard = By.name("name_on_card");
    By cardNumber = By.name("card_number");
    By cvc = By.name("cvc");
    By expiryMonth = By.name("expiry_month");
    By expiryYear = By.name("expiry_year");
    By payConfirmBtn = By.id("submit");

    
    By orderSuccessMsg = By.xpath("//p[contains(text(),'Congratulations')]");

    public void enterComment(String comment) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(commentBox)).sendKeys(comment);
    }

    public void clickPlaceOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
    }

    public void enterPaymentDetails(String name, String number, String cvcCode,
                                    String month, String year) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(nameOnCard)).sendKeys(name);
        driver.findElement(cardNumber).sendKeys(number);
        driver.findElement(cvc).sendKeys(cvcCode);
        driver.findElement(expiryMonth).sendKeys(month);
        driver.findElement(expiryYear).sendKeys(year);
    }

    public void clickPayConfirm() {
        wait.until(ExpectedConditions.elementToBeClickable(payConfirmBtn)).click();
    }

  
    public boolean isOrderPlaced() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderSuccessMsg)).isDisplayed();
    }
}