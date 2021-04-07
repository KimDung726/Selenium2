package testcase;

import driver.*;
import utility.*;

import org.testng.ITestResult;
import org.testng.annotations.*;

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

    @AfterMethod
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

}
