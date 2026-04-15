package com.srm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {
    WebDriver driver;
    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }
    By contactUsBtn = By.linkText("Contact us");
    By nameField = By.cssSelector("[data-qa='name']");
    By emailField = By.cssSelector("[data-qa='email']");
    By subjectField = By.cssSelector("[data-qa='subject']");
    By messageField = By.id("message");
    By uploadFile = By.name("upload_file");
    By submitBtn = By.cssSelector("[data-qa='submit-button']");
    By homeBtn = By.cssSelector(".btn.btn-success");
    By homeLogo = By.xpath("//img[@alt='Website for automation practice']");
    public void clickContactUs() {
        driver.findElement(contactUsBtn).click();
    }

    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterSubject(String subject) {
        driver.findElement(subjectField).sendKeys(subject);
    }

    public void enterMessage(String message) {
        driver.findElement(messageField).sendKeys(message);
    }

    public void uploadFile(String path) {
        driver.findElement(uploadFile).sendKeys(path);
    }
    public void uploadFile() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(uploadFile));
        Thread.sleep(2000);

        ProcessBuilder pb = new ProcessBuilder("F:\\HCLTech_Training\\upload.exe");
        pb.start();
    }
    public void clickSubmit() {
        driver.findElement(submitBtn).click();
    }
    public void clickHome() {

        driver.findElement(homeBtn).click();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Automation Exercise"));
    }
}