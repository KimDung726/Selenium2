package com.tikivn.driver;

import org.openqa.selenium.WebDriver;

import com.tikivn.driver.browser.ChromeDriverManager;
import com.tikivn.driver.browser.FireFoxDriverManager;

public class DriverFactory {

    protected static DriverManager driverManager;
    private static int timeOut = 30;

    public static DriverManager getDriverManager(DriverType type) {

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FireFoxDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;
    }

    public static WebDriver getDriver() {
        return driverManager.getWebDriver();
    }

    /**
     * @return the timeOut
     */
    public static int getTimeOut() {
        return timeOut;
    }

}
