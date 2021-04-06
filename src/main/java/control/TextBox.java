package control;

import org.openqa.selenium.By;

public class TextBox extends BaseControl {

    public TextBox(String locator) {
        super(locator);
    }

    public TextBox(By locator) {
        super(locator);
    }

    public TextBox(String locator, Object... value) {
        super(locator, value);
    }

    public TextBox(BaseControl parent, String locator) {
        super(parent, locator);
    }

    public TextBox(BaseControl parent, By locator) {
        super(parent, locator);
    }

    public TextBox(BaseControl parent, String locator, Object... value) {
        super(parent, locator, value);
    }

    public void enter(CharSequence... value) {
        try {
            getElement().sendKeys(value);
        } catch (Exception e) {
        }
    }

    public void clear() {
        try {
            getElement().clear();
        } catch (Exception e) {
        }
    }

}