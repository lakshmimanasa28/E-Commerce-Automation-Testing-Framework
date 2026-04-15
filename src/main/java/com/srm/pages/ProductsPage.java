package com.srm.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class ProductsPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // 🔹 LOCATORS
    By productsBtn = By.xpath("//a[@href='/products']");
    By allProducts = By.className("product-image-wrapper");

    By searchBox = By.id("search_product");
    By searchBtn = By.id("submit_search");

    By searchedTitle = By.xpath("//h2[contains(text(),'Searched Products')]");
    By searchedProducts = By.xpath("//div[@class='productinfo text-center']");

    // 🔥 POPUP CLOSE
    By closePopup = By.xpath("//button[text()='Close'] | //div[contains(text(),'Close')]");

    By viewProductBtn = By.xpath("(//a[contains(text(),'View Product')])[1]");
    By productDetails = By.xpath("//div[@class='product-information']");

    By addToCartBtn = By.xpath("(//a[contains(text(),'Add to cart')])[1]");
    By viewCartBtn = By.xpath("//u[text()='View Cart']");
    By continueShoppingBtn = By.xpath("//button[text()='Continue Shopping']");

    public void closeAdPopupIfPresent() {

        try {
            List<WebElement> popups = driver.findElements(closePopup);

            if (popups.size() > 0 && popups.get(0).isDisplayed()) {
                popups.get(0).click();
                System.out.println("Popup closed");
            }

        } catch (Exception e) {
            System.out.println("No popup present");
        }
    }

    
    public void clickProducts() {

        wait.until(ExpectedConditions.elementToBeClickable(productsBtn)).click();

      
        wait.until(ExpectedConditions.urlContains("products"));

     
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));

        closeAdPopupIfPresent();
    }

   
    public int getProductsCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(allProducts));
        return driver.findElements(allProducts).size();
    }

    public void searchProduct(String productName) {

      
        closeAdPopupIfPresent();

        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));

        search.clear();
        search.sendKeys(productName);

        driver.findElement(searchBtn).click();

        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(searchedTitle),
                ExpectedConditions.urlContains("search")
        ));
    }

  
    public boolean isSearchResultDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(searchedTitle)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

   
    public void clickFirstProduct() {

        WebElement viewBtn = wait.until(ExpectedConditions.elementToBeClickable(viewProductBtn));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", viewBtn);
        js.executeScript("arguments[0].click();", viewBtn);
    }

  
    public void addFirstProductToCart() {

        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", addBtn);
        js.executeScript("arguments[0].click();", addBtn);
    }

   
    public void clickContinueShopping() {
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingBtn)).click();
    }

  
    public void clickViewCart() {

        WebElement viewCart = wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", viewCart);
    }
}