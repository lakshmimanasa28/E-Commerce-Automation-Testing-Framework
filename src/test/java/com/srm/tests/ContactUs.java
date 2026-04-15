package com.srm.tests;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.ContactUsPage;

public class ContactUs extends BaseTest {

    @Test
    public void contactFormTest() throws Exception {

        ContactUsPage contact = new ContactUsPage(driver);

        contact.clickContactUs();
        contact.enterName("Deepika");
        contact.enterEmail("deepika@gmail.com");
        contact.enterSubject("Test Subject");
        contact.enterMessage("Hello this is test");

        contact.uploadFile();

        Thread.sleep(3000);

        contact.clickSubmit();
        

        Alert alert = driver.switchTo().alert();
        alert.accept();

        Thread.sleep(3000);
        contact.clickHome();
        Thread.sleep(2000);
        System.out.println(driver.getPageSource().contains("Success!"));
    }
}