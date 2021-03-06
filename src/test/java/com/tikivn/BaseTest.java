package com.tikivn;

import com.tikivn.driver.DriverFactory;
import com.tikivn.driver.DriverManager;
import com.tikivn.driver.DriverType;
import com.tikivn.utility.Constants;
import com.tikivn.utility.Log;

import com.tikivn.utility.helper.JsonHelper;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseTest {

    private String strTestResult;
    DriverManager driverManager;

    @BeforeMethod
    @Parameters("browser")
    public void setupTest(String browser) {
        DriverType current = (browser != null && !"".equals(browser)) ? DriverType.fromName(browser) : DriverType.CHROME;
        driverManager = DriverFactory.getDriverManager(current);
        driverManager.navigateToUrl(Constants.BASE_URL);
    }

    @AfterMethod(alwaysRun = true)
    public void cleanupTest(ITestResult result) {
        printTestResult(result);
        driverManager.quitDriver();
    }

    /***
     * Print Test Result in Log
     * @param result : ITestResult
     */
    public void printTestResult(ITestResult result) {
        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                strTestResult = "PASS";
                break;

            case ITestResult.FAILURE:
                strTestResult = "FAILED";
                break;

            case ITestResult.SKIP:
                strTestResult = "SKIP";
                break;

            default:
                Log.error("[BaseTest] Invalid status");
        }
        Log.endTestCase(strTestResult);
    }

    @DataProvider(name = "getDataForTest")
    public synchronized Object[][] getDataForTest(Method method) {
        String testMethodName = method.getName();
        return (Object[][]) JsonHelper.getDataFile("data.json", testMethodName);
    }

}
