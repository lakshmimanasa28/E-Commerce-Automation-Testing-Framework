package com.srm.base;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.srm.driver.DriverFactory;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.initDriver();
        driver.get("https://automationexercise.com/");
        switchToMainTab();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
    public void switchToMainTab() {
        String mainTab = driver.getWindowHandles().iterator().next();
        driver.switchTo().window(mainTab);
    }
}