package driver;

import org.openqa.selenium.WebDriver;

import driver.browser.ChromeDriverManager;
import driver.browser.FireFoxDriverManager;

public class DriverFactory {

    protected static driver.DriverManager driverManager;
    private static int timeOut = 30;

    public static driver.DriverManager getDriverManager(DriverType type) {

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
