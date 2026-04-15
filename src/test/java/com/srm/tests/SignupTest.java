package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.SignupPage;
import com.srm.tests.DataProviders;

public class SignupTest extends BaseTest {

    @Test(dataProvider = "signupData", dataProviderClass = DataProviders.class)
    public void signupTest(String name, String lastname, String title,
                           String day, String month, String year,
                           String email, String password,
                           String company, String address,
                           String city, String state,
                           String zip, String mobile) {

        SignupPage signup = new SignupPage(driver);

        // 🔥 Generate unique email every time
        String uniqueEmail = "user" + System.currentTimeMillis() + "@gmail.com";

        signup.clickSignupLogin();

        signup.enterSignupNameEmail(name, uniqueEmail);

        signup.fillAccountInfo(password, day, month, year);

        signup.fillAddressInfo(name, lastname, company,
                address, city, state, zip, mobile);

        signup.clickCreateAccount();

        // ✅ Validation (VERY IMPORTANT)
        Assert.assertTrue(signup.isAccountCreated(), "Signup failed!");

        signup.clickContinue();

        System.out.println("Signup completed for: " + uniqueEmail);
    }
}