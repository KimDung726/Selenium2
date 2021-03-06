package com.tikivn.driver.browser;

import com.tikivn.driver.DriverManager;
import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static io.github.bonigarcia.wdm.config.DriverManagerType.FIREFOX;

public class FireFoxDriverManager extends DriverManager {

    @Override
    public WebDriver createWebDriver() {
        WebDriverManager.getInstance(FIREFOX).setup();
        return new FirefoxDriver(getFirefoxOptions());
    }

    private FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-features=EnableEphemeralFlashPermission");
        options.addArguments("--disable-infobars");

        return options;
    }

}
