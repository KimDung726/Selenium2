package control;

import driver.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.StaleElementReferenceException;

public class BaseControl {
    private By byLocator;
    private String locator;
    private String dynamicLocator;
    private BaseControl parent;

    public BaseControl(String locator) {
        this.locator = locator;
        this.dynamicLocator = locator;
        this.byLocator = getByLocator();
    }

    public BaseControl(By byLocator) {
        this.byLocator = byLocator;
    }

    public BaseControl(String locator, Object... args) {
        this.dynamicLocator = locator;
        this.locator = String.format(dynamicLocator, args);
        this.byLocator = getByLocator();
    }

    public BaseControl(BaseControl parent, String locator) {
        this.locator = locator;
        this.dynamicLocator = locator;
        this.byLocator = getByLocator();
        this.parent = parent;
    }

    public BaseControl(BaseControl parent, By byLocator) {
        this.byLocator = byLocator;
        this.parent = parent;
    }

    public BaseControl(BaseControl parent, String locator, Object... args) {
        this.dynamicLocator = locator;
        this.locator = String.format(dynamicLocator, args);
        this.byLocator = getByLocator();
        this.parent = parent;
    }

    protected WebDriver getDriver() {
        return DriverUtils.getDriver();
    }

    protected JavascriptExecutor jsExecutor() {
        return (JavascriptExecutor) getDriver();
    }

    public void setDynamicValue(Object... args) {
        this.locator = String.format(this.dynamicLocator, args);
        this.byLocator = getByLocator();
    }

    public void focus() {
        DriverUtils.execJavaScript("arguments[0].focus();", getElement());
    }

    private By getByLocator() {
        String body = this.locator.replaceAll("[\\w\\s]*=(.*)", "$1").trim();
        String type = this.locator.replaceAll("([\\w\\s]*)=.*", "$1").trim();
        switch (type.toLowerCase()) {
            case "css":
                return By.cssSelector(body);
            case "id":
                return By.id(body);
            case "class":
                return By.className(body);
            case "link":
                return By.linkText(body);
            case "xpath":
                return By.xpath(body);
            case "text":
                return By.xpath(String.format("//*[contains(text(), '%s')]", body));
            case "name":
                return By.name(body);
            default:
                return By.xpath(locator);
        }
    }

    public WebElement getElement() {
        WebElement element = null;
        try {
            if (parent != null) {
                WebElement eleParent = parent.getElement();
                element = eleParent.findElement(getLocator());
            } else {
                element = getDriver().findElement(getLocator());
            }
            return element;
        } catch (StaleElementReferenceException e) {
            return getElement();
        }
    }

    public By getLocator() {
        return this.byLocator;
    }

    public String getText() {
        try {
            return getElement().getText();
        } catch (Exception e) {
            throw e;
        }
    }

    public void mouseHoverJScript() {
        String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
        jsExecutor().executeScript(mouseOverScript, getElement());

    }

    public void moveTo() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getElement()).build().perform();
    }

    public void click() {
        getElement().click();
    }

    public void waitForDisplay() {
        waitForDisplay(DriverUtils.getTimeOut());
    }

    public void waitForDisplay(int timeOutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
            wait.until(ExpectedConditions.presenceOfElementLocated(getLocator()));
        } catch (Exception e) {
        }
    }

    public void waitForAlert(int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void waitForVisibility(int timeOutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
            wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator()));
        } catch (Exception e) {
        }
    }

    public void waitForVisibility() {
        waitForVisibility(DriverUtils.getTimeOut());
    }

    public boolean isExist() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), DriverUtils.getTimeOut());
            return (wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getLocator())) != null);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSelected() {
        try {
            return getElement().isSelected();
        } catch (Exception e) {
            return false;
        }
    }

    public void waitForInVisibility() {
        waitForInVisibility(DriverUtils.getTimeOut());
    }

    public void waitForInVisibility(int timeOutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(getLocator()));
        } catch (Exception e) {
        }
    }

    public boolean isVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), DriverUtils.getTimeOut());
            return (wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getLocator())) != null);
        } catch (Exception e) {
            return false;
        }
    }

    public String waitTextRepoChange() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        return "";
    }

}