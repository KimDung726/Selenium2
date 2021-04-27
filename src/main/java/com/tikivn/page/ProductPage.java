package com.tikivn.page;

import com.tikivn.control.Breadcrumb;
import com.tikivn.control.Item;
import com.tikivn.control.Link;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends BasePage {
    Link searchSummaryTitleLbl = new Link("css=.search-summary .title h1");
    Item products = new Item("css=.ProductList__Wrapper-sc-1dl80l2-0.healEa");
    Link nameItem = new Link("css=.header .title");
    Link priceItem = new Link("css=.product-price__current-price");
    Breadcrumb menuBar = new Breadcrumb("css=.breadcrumb");

    @Step("VP: Breadcrumb is 'Trang chủ > Điện thoại'")
    public String getBreadcrumb() {
        menuBar.waitForDisplay();
        return menuBar.getAllPath();
    }

    @Step("VP: 'kết quả tìm kiếm cho...' title is displayed")
    public String getSearchSummaryTitleLbl() {
        searchSummaryTitleLbl.waitForDisplay();
        return searchSummaryTitleLbl.getText();
    }

    @Step("Select any item from result grid")
    public void selectItemById(String position) {
        products.getItemById(position).click();
    }

    @Step("Get information of Item BEFORE select (Name, price)")
    public String getInfoItemBeforeSelect(String position) {
        String value;
        products.waitForDisplay();
        products.getItemById(position);
        value = products.getNameItem() + " "
                + products.getPriceItem();

        products.clearValuePositionOfItem();

        return value;
    }

    @Step("Get information of Item AFTER select (Name, price)")
    public String getInfoItemAfterSelect() {
        nameItem.waitForDisplay();
        priceItem.waitForDisplay();

        return nameItem.getText() + " " + priceItem.getText();
    }

}
