package com.tikivn.page;

import com.tikivn.control.Breadcrumb;
import com.tikivn.control.Button;
import com.tikivn.control.Link;
import io.qameta.allure.Step;

public class DienGiaDungPage extends BasePage {
    Button dienGiaDung = new Button("//div[@class='style__NavContainer-mvfe96-1 hKbZQT']//li//span[.='Điện Gia Dụng']");
    Button menu = new Button("css=.Menu-button");
    Button loViSongButton = new Button("//li[@class='SubMenu__NavSubCol-ykxlng-2 jiKhdj']//span//a[.='Lò vi sóng']");
    Breadcrumb menuBar = new Breadcrumb("");
    Link searchSummaryTitleLbl = new Link("css=.search-summary .title h1");
    Link tikiTrading = new Link("//h4[.='Nhà cung cấp']/..//span[.='%s']/../..//span[@class='box']//img[@class='icon-check-on']");

    @Step("Select 'Nhà cung cấp'")
    public void selectNhaCungCap(String name) {
        tikiTrading.setDynamicValue(name);
        tikiTrading.waitForVisibility();
        tikiTrading.click();
    }

    @Step("Select left menu")
    public void selectPath() {
        menu.click();
        dienGiaDung.mouseHoverJScript();
        loViSongButton.click();
    }

    @Step("VP: Breadcrumb is 'Trang chủ > Điện Gia Dụng > Đồ dùng nhà bếp > Lò vi sóng'")
    public String getBreadcrumb() {
        menuBar.waitForDisplay();
        return menuBar.getAllPath();
    }

    @Step("VP: 'Lò vi sóng' title is displayed")
    public String getSearchSummaryTitleLbl() {
        searchSummaryTitleLbl.waitForDisplay();
        return searchSummaryTitleLbl.getText();
    }

}
