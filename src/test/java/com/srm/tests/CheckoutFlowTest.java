package com.srm.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.*;

public class CheckoutFlowTest extends BaseTest {

    @Test
    public void fullCheckoutFlow() {

        ProductsPage products = new ProductsPage(driver);
        CartPage cart = new CartPage(driver);
        LoginPage login = new LoginPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    
        products.clickProducts();

      
        products.addFirstProductToCart();

        
        products.clickViewCart();

       
        cart.clickProceedToCheckout();

       
        cart.clickRegisterLogin();
        login.login("aishwaryakatakamsetty@gmail.com", "789456");

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(text(),'Logged in as')]")));

        cart.openCart();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'Proceed To Checkout')]")));

        cart.clickProceedToCheckout();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("message")));

        checkout.enterComment("Please deliver fast");

        
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'Place Order')]")));

        checkout.clickPlaceOrder();

     
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("name_on_card")));

        checkout.enterPaymentDetails("Aish", "1234123412341234",
                "123", "12", "2028");

        checkout.clickPayConfirm();

     // 🔥 WAIT UNTIL ORDER CONFIRMATION
     new WebDriverWait(driver, Duration.ofSeconds(15))
         .until(ExpectedConditions.visibilityOfElementLocated(
             By.xpath("//b[contains(text(),'Order Placed')]")));

     Assert.assertTrue(checkout.isOrderPlaced(), "Order not placed!");

        System.out.println("Order placed successfully");
    }
}