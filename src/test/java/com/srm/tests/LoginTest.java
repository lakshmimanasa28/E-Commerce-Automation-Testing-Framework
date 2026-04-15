package com.srm.tests;

import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test(dataProvider = "signupData", dataProviderClass = DataProviders.class)
	public void loginTest(String name, String lastname, String title,
	                      String day, String month, String year,
	                      String email, String password,
	                      String company, String address,
	                      String city, String state,
	                      String zip, String mobile) throws Exception {

	    LoginPage login = new LoginPage(driver);

	    login.login(email, password);

	    Thread.sleep(3000);

	    if (login.isLoggedIn()) {
	        System.out.println("Login successful for: " + email);
	    }
	    
	    

	    login.clickLogout();
	}
}