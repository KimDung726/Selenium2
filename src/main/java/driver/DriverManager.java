package driver;

import org.openqa.selenium.WebDriver;
import utility.Log;

public abstract class DriverManager {

    protected WebDriver driver;

    protected abstract void createWebDriver();

    /***
     * Get Driver
     * @return : driver
     */
    public WebDriver getWebDriver() {
        if (null == driver) {
            createWebDriver();
        }
        return driver;
    }

    /***
     * Quit Web driver
     */
    public void quitDriver() {
        try {
            if (null != driver) {
                driver.quit();
                driver = null;
            }
        } catch (Exception e) {
            Log.error("Unable to gracefully quit WebDriver: " + e);
        }
    }

    /***
     * Navigate to base URL
     */
    public void navigateToUrl(String url) {
        DriverUtils.maximumBrowser();
        getWebDriver().navigate().to(url);
    }

}
