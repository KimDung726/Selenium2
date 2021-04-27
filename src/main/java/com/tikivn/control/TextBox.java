package com.tikivn.control;

import org.openqa.selenium.By;
import com.tikivn.utility.Log;

import java.util.Arrays;

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
            Log.debug(String.format("Enter '%s' for %s", Arrays.toString(value), getLocator().toString()));
            getElement().sendKeys(value);
        } catch (Exception e) {
            Log.error(String.format("Has error with control '%s': %s", getLocator().toString(), e.getMessage().split("\n")[0]));
        }
    }

    public void clear() {
        try {
            Log.debug(String.format("Clean text for %s", getLocator().toString()));
            getElement().clear();
        } catch (Exception e) {
            Log.error(String.format("Has error with control '%s': %s", getLocator().toString(), e.getMessage().split("\n")[0]));
        }
    }

}