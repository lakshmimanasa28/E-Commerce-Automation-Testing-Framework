package com.srm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By loginSignupBtn = By.linkText("Signup / Login");
    By emailField = By.cssSelector("[data-qa='login-email']");
    By passwordField = By.cssSelector("[data-qa='login-password']");
    By loginBtn = By.xpath("//button[@data-qa='login-button']");
    By loggedInText = By.xpath("//a[contains(text(),'Logged in as')]");
    By logoutBtn = By.linkText("Logout");

    public void clickLoginSignup() {
        driver.findElement(loginSignupBtn).click();
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginBtn).click();
    }

    public void login(String email, String password) {
        clickLoginSignup();
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public boolean isLoggedIn() {
        return driver.findElement(loggedInText).isDisplayed();
    }

    public void clickLogout() {
        driver.findElement(logoutBtn).click();
    }
    By loginErrorMsg = By.xpath("//p[contains(text(),'incorrect')]");
    By loginButton = By.xpath("//button[@data-qa='login-button']");

    // Verify invalid login error
    public boolean isLoginErrorVisible() {
        return driver.findElement(loginErrorMsg).isDisplayed();
    }

    // Click login without entering data
    public void clickLoginWithoutData() {
        driver.findElement(loginButton).click();
    }

    // Check if email field is required (empty validation)
    public boolean isEmailFieldRequired() {
        return driver.findElement(emailField).getAttribute("required") != null;
    }
}