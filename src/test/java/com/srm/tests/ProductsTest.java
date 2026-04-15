package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.ProductsPage;

public class ProductsTest extends BaseTest {

    @Test
    public void searchProductTest() {

        ProductsPage products = new ProductsPage(driver);

    
        products.clickProducts();

     
     products.closeAdPopupIfPresent();

     products.searchProduct("dress");

        Assert.assertTrue(products.isSearchResultDisplayed(),
                "Search results not displayed");

        System.out.println("Search test passed");
    }
}