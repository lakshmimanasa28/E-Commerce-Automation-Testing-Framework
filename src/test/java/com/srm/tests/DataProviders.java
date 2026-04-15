package com.srm.tests;

import org.testng.annotations.DataProvider;
import com.srm.utils.ExcelUtils;

public class DataProviders {

    @DataProvider(name = "signupData")
    public Object[][] getSignupData() {
        return ExcelUtils.getSignupData();
    }
}