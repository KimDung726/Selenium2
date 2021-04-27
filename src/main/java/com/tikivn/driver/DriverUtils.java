package com.tikivn.driver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tikivn.utility.Constants;

public class DriverUtils extends DriverFactory {

    public static void waitForAlert(int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void maximumBrowser() {
        getDriver().manage().window().maximize();
    }

    public static Object execJavaScript(String script, Object... objs) {
        return ((JavascriptExecutor) getDriver()).executeScript(script, objs);
    }

    public static int getTimeOut() {
        return DriverFactory.getTimeOut();
    }

    public static Alert switchToAlert() {
        return getDriver().switchTo().alert();

    }

    public static String getTextAlert() {
        waitForAlert(Constants.SHORT_TIME);
        return switchToAlert().getText();
    }

    public static String getTitle() {
        return getDriver().getTitle();
    }

    public static void acceptAlert() {
        waitForAlert(Constants.SHORT_TIME);
        switchToAlert().accept();
    }

}
