package com.tikivn.ProductTest;

import com.tikivn.BaseTest;
import com.tikivn.listener.TestListener;
import com.tikivn.page.DienGiaDungPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Hashtable;

import static com.tikivn.utility.Log.info;
import static com.tikivn.utility.Log.startTestCase;

@Listeners({TestListener.class})
@Epic("Regression Tests")
@Feature("Production")
public class TIKI_PRODUCT_TC002 extends BaseTest {

    DienGiaDungPage dienGiaDungPage = new DienGiaDungPage();

    @Test(priority = 2,
            description = "Verify user can filter search condition for product",
            dataProvider = "getDataForTest")
    @Story("Test verify user can filter search condition for product")
    public void PRODUCT_TC002(Hashtable<String, String> data) {

        startTestCase("TIKI_PRODUCT_TC002");

        info("Step #1: Navigate to 'TIKI' website");

        info("Step #2: Select left menu");
        dienGiaDungPage.selectPath();

        info("VP: Breadcrumb is 'Trang chủ > Điện Gia Dụng > Đồ dùng nhà bếp > Lò vi sóng'");
        Assert.assertEquals(dienGiaDungPage.getBreadcrumb(), "Trang chủĐiện Gia DụngĐồ dùng nhà bếpLò vi sóng");

        String actualSearchTitle = dienGiaDungPage.getSearchSummaryTitleLbl();
        String expectedSearchTitle = data.get("Search summary Title");

        info("VP: 'Lò vi sóng' title is displayed");
        Assert.assertEquals(actualSearchTitle, expectedSearchTitle);

        info("Select 'Nhà cung cấp'");
        dienGiaDungPage.selectNhaCungCap(data.get("Nha cung cap"));
    }
}
