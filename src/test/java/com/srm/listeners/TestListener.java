package com.srm.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.srm.driver.DriverFactory;
import com.srm.utils.ExtentManager;
import com.srm.utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");

        String path = ScreenshotUtil.takeScreenshot(
                DriverFactory.driver,
                result.getName() + "_SUCCESS"
        );

        try {
            test.addScreenCaptureFromPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail("Test Failed");

        String path = ScreenshotUtil.takeScreenshot(
                DriverFactory.driver,
                result.getName() + "_FAIL"
        );

        try {
            test.addScreenCaptureFromPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }

        test.fail(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();   // 🔥 MUST
    }
}