package control;

import org.openqa.selenium.By;

public class CheckBox extends BaseControl {
    public CheckBox(By locator) {
        super(locator);
    }

    public CheckBox(String locator) {
        super(locator);
    }

    public CheckBox(String locator, Object... value) {
        super(locator, value);
    }

    public CheckBox(BaseControl parent, String locator) {
        super(parent, locator);
    }

    public CheckBox(BaseControl parent, By locator) {
        super(parent, locator);
    }

    public CheckBox(BaseControl parent, String locator, Object... value) {
        super(parent, locator, value);
    }

    public void setState(Boolean state) {
        if (this.getState() != state)
            click();
    }

    public boolean getState() {
        return this.isSelected();
    }

    public void check() {
        if (!isChecked()) {
            click();
        }
    }

    public boolean isChecked() {
        return isSelected();
    }

}