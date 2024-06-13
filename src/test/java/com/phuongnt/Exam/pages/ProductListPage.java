package com.phuongnt.Exam.pages;

import com.phuongnt.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductListPage extends CommonPage{

    public ProductListPage() {
    }

    private By inputSearch = By.xpath("//input[@name='search']");
    private By itemFirstProductOnTheTable = By.xpath("//tbody/tr[1]/td[2]//div[2]/span");
    private By itemFirstProductDetail = By.xpath("//i[@class='las la-eye']");
//    private By addSuccessMessage = By.xpath("//div[@class='aiz-notify alert alert-success']");
    private By closeSuccessMessageButton = By.xpath("//button[@data-notify='dismiss']");


    public ProductListPage verifyAddProduct(String name) {
        new DashboardPage().getAllProductPage();
        WebUI.waitForPageLoaded();
        WebUI.waitForJQueryLoad();
        WebUI.sleep(2);
        Assert.assertEquals(WebUI.getElementText(itemFirstProductOnTheTable), name, "The Product value not match.");
        return this;
    }

    public ProductListPage searchProductName(String productName) {
        WebUI.waitForPageLoaded();
        WebUI.sleep(5);
        WebUI.setText(inputSearch, productName);
        WebUI.pressENTER();
        WebUI.waitForPageLoaded();
        WebUI.waitForJQueryLoad();
        WebUI.sleep(2);
        Assert.assertTrue(WebUI.isDisplayed(itemFirstProductOnTheTable), "Nothing found");
        Assert.assertEquals(WebUI.getElementText(itemFirstProductOnTheTable), productName, "The Product value match.");
        WebUI.clickElement(closeSuccessMessageButton);
        WebUI.clickElement(itemFirstProductDetail);
        return this;
    }
}
