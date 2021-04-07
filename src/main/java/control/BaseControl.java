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
import utility.Log;

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
            Log.error(
                    String.format("StaleElementReferenceException '%s': %s", getLocator().toString(), e.getMessage().split("\n")[0]));
            return getElement();
        }
    }

    public By getLocator() {
        return this.byLocator;
    }

    public String getText() {
        try {
            Log.debug(String.format("Get text of element %s", getLocator().toString()));
            return getElement().getText();
        } catch (Exception e) {
            Log.error(String.format("Has error with control '%s': %s", getLocator().toString(), e.getMessage().split("\n")[0]));
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

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitForDisplay() {
        waitForDisplay(DriverUtils.getTimeOut());
    }

    public void waitForDisplay(int timeOutInSeconds) {
        try {
            Log.info(String.format("Wait for control display %s", getLocator().toString()));
            WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
            wait.until(ExpectedConditions.presenceOfElementLocated(getLocator()));
        } catch (Exception e) {
            Log.error(String.format("WaitForDisplay: Has error with control '%s': %s", getLocator().toString(),
                    e.getMessage().split("\n")[0]));
        }
    }

    public void waitForAlert(int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void waitToBeClickable() {
        waitToBeClickable(DriverUtils.getTimeOut());
    }

    public void waitToBeClickable(int timeOutInSeconds) {
        try {
            Log.info(String.format("Wait for control to be click able %s", getLocator().toString()));
            WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
            wait.until(ExpectedConditions.elementToBeClickable(getLocator()));
        } catch (Exception e) {
            Log.error(String.format("waitToBeClickable: Has error with control '%s': %s", getLocator().toString(),
                    e.getMessage().split("\n")[0]));
        }

    }

    public void waitForVisibility(int timeOutInSeconds) {
        try {
            Log.info(String.format("Wait for control's visibility %s", getLocator().toString()));
            WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
            wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator()));
        } catch (Exception e) {
            Log.error(String.format("waitForVisibility: Has error with control '%s': %s", getLocator().toString(),
                    e.getMessage().split("\n")[0]));
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
            Log.debug(String.format("Is control selected or not: %s", getLocator().toString()));
            return getElement().isSelected();
        } catch (Exception e) {
            Log.error(String.format("IsSelected: Has error with control '%s': %s", getLocator().toString(),
                    e.getMessage().split("\n")[0]));
            return false;
        }
    }

    public void waitForInVisibility() {
        waitForInVisibility(DriverUtils.getTimeOut());
    }

    public void waitForInVisibility(int timeOutInSeconds) {
        try {
            Log.info(String.format("Wait for control's invisibility %s", getLocator().toString()));
            WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(getLocator()));
        } catch (Exception e) {
            Log.error(String.format("waitForInVisibility: Has error with control '%s': %s", getLocator().toString(),
                    e.getMessage().split("\n")[0]));
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

}