package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.LoginPage;

public class ValidationTest extends BaseTest {

    // ✅ Test 1: Invalid Login
    @Test
    public void invalidLoginTest() {

        LoginPage login = new LoginPage(driver);

        login.login("wrong@gmail.com", "wrong123");

        Assert.assertTrue(login.isLoginErrorVisible(), 
                "Error message not displayed for invalid login");
    }

    // ✅ Test 2: Empty Login Form
    @Test
    public void emptyLoginTest() {

        LoginPage login = new LoginPage(driver);

        login.clickLoginSignup();   // open login page
        login.clickLoginWithoutData();

        Assert.assertTrue(login.isEmailFieldRequired(), 
                "Email field is not marked as required");
    }
}