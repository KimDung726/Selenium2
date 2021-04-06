package control;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ComboBox extends BaseControl {
    public ComboBox(By locator) {
        super(locator);
    }

    public ComboBox(String locator) {
        super(locator);
    }

    public ComboBox(String locator, Object... value) {
        super(locator, value);
    }

    public ComboBox(BaseControl parent, String locator) {
        super(parent, locator);
    }

    public ComboBox(BaseControl parent, By locator) {
        super(parent, locator);
    }

    public ComboBox(BaseControl parent, String locator, Object... value) {
        super(parent, locator, value);
    }

    public void select(String text) {
        Select select = new Select(getElement());
        select.selectByVisibleText(text);
    }

}

