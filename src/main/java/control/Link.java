package control;

import org.openqa.selenium.By;

public class Link extends BaseControl {
    public Link(String locator) {
        super(locator);
    }

    public Link(By locator) {
        super(locator);
    }

    public Link(String locator, Object... value) {
        super(locator, value);
    }

    public Link(BaseControl parent, String locator) {
        super(parent, locator);
    }

    public Link(BaseControl parent, By locator) {
        super(parent, locator);
    }

    public Link(BaseControl parent, String locator, Object... value) {
        super(parent, locator, value);
    }

}

