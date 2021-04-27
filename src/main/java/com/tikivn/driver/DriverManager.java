package com.tikivn.driver;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import com.tikivn.utility.Log;

public abstract class DriverManager {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    protected abstract WebDriver createWebDriver();

    /***
     * Get Driver
     * @return : driver
     */
    public WebDriver getWebDriver() {
        if (null == driver.get()) {
            driver.set(this.createWebDriver());
        }
        return driver.get();
    }

    /***
     * Quit Web driver
     */
    public void quitDriver() {
        try {
            if (null != driver) {
                driver.get().quit();
                driver.remove();
            }
        } catch (Exception e) {
            Log.error("Unable to gracefully quit WebDriver: " + e);
        }
    }

    /***
     * Navigate to base URL
     */
    @Step("Navigate to the Home page at: {0}")
    public void navigateToUrl(String url) {
        DriverUtils.maximumBrowser();
        driver.get().navigate().to(url);
    }

}
