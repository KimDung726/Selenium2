package com.tikivn.control;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Breadcrumb extends BaseControl {

    public Breadcrumb(String locator) {
        super(locator);
    }

    public Breadcrumb(By locator) {
        super(locator);
    }

    public Breadcrumb(String locator, Object... value) {
        super(locator, value);
    }

    public Breadcrumb(BaseControl parent, String locator) {
        super(parent, locator);
    }

    public Breadcrumb(BaseControl parent, By locator) {
        super(parent, locator);
    }

    public Breadcrumb(BaseControl parent, String locator, Object... value) {
        super(parent, locator, value);
    }

    public String getAllPath() {
        String path = "";
        List<WebElement> values = getElement().findElements(By.tagName("a"));
        for (WebElement value : values) {
            path += value.getText();
        }
        return path;
    }
}
