package com.tikivn.ProductTest;

import com.tikivn.BaseTest;
import com.tikivn.listener.TestListener;
import com.tikivn.page.HomePage;
import com.tikivn.page.ProductPage;
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
public class TIKI_PRODUCT_TC001 extends BaseTest {

    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();

    @Test(priority = 1,
            description = "Verify the product information loaded correctly",
            dataProvider = "getDataForTest")
    @Story("Test verify product information loaded correctly")
    public void PRODUCT_TC001(Hashtable<String, String> data) {

        startTestCase("TIKI_PRODUCT_TC001");

        info("Step #1: Navigate to 'TIKI' website");

        info("VP: 'Tìm sản phẩm...' textbox is displayed");
        Assert.assertTrue(homePage.isSearchFieldTxtDisplayed());

        info("VP: 'Tìm kiếm' button is displayed");
        Assert.assertTrue(homePage.isSearchBtnDisplayed());

        info("Step #2: On home page, enter value in 'Tìm sản phẩm...' textbox");
        homePage.enterSearchFieldTxt(data.get("keyword"));

        info("Step #3: Click 'Tìm kiếm' button");
        homePage.clickOnSearchBtn();

        info("VP: Breadcrumb is 'Trang chủ > điện thoại'");
        Assert.assertEquals(productPage.getBreadcrumb(), "Trang chủđiện thoại");

        String actualSearchTitle = productPage.getSearchSummaryTitleLbl();
        String expectedSearchTitle = data.get("Search summary Title");

        info("VP: 'Ket qua tim kiem cho `Dien thoai` title is displayed'");
        Assert.assertEquals(actualSearchTitle, expectedSearchTitle);

        info("Get information of Item BEFORE select");
        String actualInfoItemBeforeSelect = productPage.getInfoItemBeforeSelect(data.get("Position of Item"));

        info("Step #4: Select any item from result grid");
        productPage.selectItemById(data.get("Position of Item"));

        info("Get information of Item AFTER select");
        String expectedInfoItemAfterSelect = productPage.getInfoItemAfterSelect();

        info("VP: The selected item is displayed correctly in details (Name, Price)");
        Assert.assertEquals(actualInfoItemBeforeSelect, expectedInfoItemAfterSelect);
    }

}
