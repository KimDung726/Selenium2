package com.tikivn.control;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Table extends BaseControl {

    public Table(String locator) {
        super(locator);
    }

    public Table(By locator) {
        super(locator);
    }

    public Table(String locator, Object... value) {
        super(locator, value);
    }

    public Table(BaseControl parent, String locator) {
        super(parent, locator);
    }

    public Table(BaseControl parent, By locator) {
        super(parent, locator);
    }

    public Table(BaseControl parent, String locator, Object... value) {
        super(parent, locator, value);
    }

    public List<WebElement> getAllRowsExceptHeader() {
        return getElement().findElements(By.cssSelector("tr:not(tr:first-child)"));
    }

    public ArrayList<String> getValueOfColumnsById(int position) {

        ArrayList<String> values = new ArrayList<>();

        List<WebElement> tableRows = getAllRowsExceptHeader();
        for (WebElement row : tableRows) {
            WebElement value = row.findElement(By.cssSelector(String.format("td:nth-child(%s)", position)));
            values.add(value.getText());
        }
        return values;
    }

    public String getFirstRowAfterHeaders() {
        List<WebElement> tableRows = getAllRowsExceptHeader();
        return tableRows.get(0).getText();
    }

    public ArrayList<String> getValueColumnInRowById(int position, ArrayList<Integer> options) {

        ArrayList<String> values = new ArrayList<>();
        WebElement row = getElement().findElement(By.cssSelector(String.format("tr:not(tr:first-child):nth-child(%s)", position)));

        List<WebElement> allTds = row.findElements(By.tagName("td"));
        for (int option : options) {
            values.add(allTds.get(option - 1).getText());
        }
        return values;
    }
}
