package control;

import org.openqa.selenium.By;

public class Button extends BaseControl {
    public Button(String locator) {
        super(locator);
    }

    public Button(By locator) {
        super(locator);
    }

    public Button(String locator, Object... value) {
        super(locator, value);
    }

    public Button(BaseControl parent, String locator) {
        super(parent, locator);
    }

    public Button(BaseControl parent, By locator) {
        super(parent, locator);
    }

    public Button(BaseControl parent, String locator, Object... value) {
        super(parent, locator, value);
    }

}
