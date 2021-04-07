package page;

import control.Link;

public class HomePage {
    private final Link tabLink = new Link("css=a[href*='%s']");

    public void selectOnTab(String pathTab) {
        tabLink.setDynamicValue(pathTab);
        tabLink.waitForVisibility();
        tabLink.click();
    }

}
