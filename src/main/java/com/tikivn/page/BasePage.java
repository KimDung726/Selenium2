package com.tikivn.page;

import com.tikivn.control.Link;

public class BasePage {

    private final Link tabLink = new Link("css=a[href*='%s']");

    public void selectOnTab(String pathTab) {
        tabLink.setDynamicValue(pathTab);
        tabLink.waitForVisibility();
        tabLink.click();
    }

}
