package com.tikivn.control;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Item extends BaseControl {

    String positionOfItem = "";

    public Item(String locator) {
        super(locator);
    }

    public Item(By locator) {
        super(locator);
    }

    public Item(String locator, Object... value) {
        super(locator, value);
    }

    public Item(BaseControl parent, String locator) {
        super(parent, locator);
    }

    public Item(BaseControl parent, By locator) {
        super(parent, locator);
    }

    public Item(BaseControl parent, String locator, Object... value) {
        super(parent, locator, value);
    }

    public WebElement getItemById(String position) {
        this.positionOfItem = position;
        return getElement().findElement(By.cssSelector(String.format("a[data-view-index='%s']", position)));
    }

    public String getNameItem() {
        return getItemById(positionOfItem).findElement(By.cssSelector(".name")).getText();
    }

    public String getPriceItem() {
        return getItemById(positionOfItem).findElement(By.cssSelector(".price-discount__price")).getText();
    }

    public void clearValuePositionOfItem() {
        this.positionOfItem = "";
    }

}
