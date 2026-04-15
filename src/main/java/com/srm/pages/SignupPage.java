package com.srm.pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class SignupPage {

    WebDriver driver;
    WebDriverWait wait;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // 🔹 Locators
    By signupLoginBtn = By.linkText("Signup / Login");
    By nameField = By.name("name");
    By emailField = By.xpath("//input[@data-qa='signup-email']");
    By signupBtn = By.xpath("//button[@data-qa='signup-button']");

    By titleMrs = By.id("id_gender2");
    By password = By.id("password");
    By days = By.id("days");
    By months = By.id("months");
    By years = By.id("years");

    By firstName = By.id("first_name");
    By lastName = By.id("last_name");
    By companyField = By.id("company");
    By address = By.id("address1");
    By state = By.id("state");
    By city = By.id("city");
    By zipcode = By.id("zipcode");
    By mobile = By.id("mobile_number");

    By createAccountBtn = By.xpath("//button[@data-qa='create-account']");
    By continueBtn = By.xpath("//a[@data-qa='continue-button']");

    // ✅ Success message
    By accountCreatedMsg = By.xpath("//b[contains(text(),'Account Created')]");

    // 🔹 Click Signup/Login
    public void clickSignupLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(signupLoginBtn)).click();
    }

    // 🔹 Enter Name & Email
    public void enterSignupNameEmail(String name, String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(signupBtn).click();
    }

    // 🔹 Fill Account Info
    public void fillAccountInfo(String passwordValue, String day, String month, String year) {

        wait.until(ExpectedConditions.elementToBeClickable(titleMrs)).click();

        driver.findElement(password).sendKeys(passwordValue);

        new Select(driver.findElement(days)).selectByVisibleText(day);
        new Select(driver.findElement(months)).selectByVisibleText(month);
        new Select(driver.findElement(years)).selectByVisibleText(year);
    }

    // 🔹 Fill Address Info
    public void fillAddressInfo(String first, String last, String company,
                                String addr, String cityVal,
                                String stateVal, String zip, String mobileVal) {

        driver.findElement(firstName).sendKeys(first);
        driver.findElement(lastName).sendKeys(last);
        driver.findElement(companyField).sendKeys(company);
        driver.findElement(address).sendKeys(addr);
        driver.findElement(city).sendKeys(cityVal);
        driver.findElement(state).sendKeys(stateVal);
        driver.findElement(zipcode).sendKeys(zip);
        driver.findElement(mobile).sendKeys(mobileVal);
    }

    // 🔹 Create Account
    public void clickCreateAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(createAccountBtn)).click();
    }

    // 🔹 Continue after creation
    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
    }

    // 🔥 Verify account created
    public boolean isAccountCreated() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreatedMsg)).isDisplayed();
    }
}