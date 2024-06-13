package com.phuongnt.Exam.pages;

import com.phuongnt.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AddNewProduct extends CommonPage {

    public AddNewProduct() {
    }

    private By headerPage = By.xpath("//h5[text()='Add New Product']");
    private By inputProductName = By.xpath("//input[@placeholder='Product Name']");
    private By dropdownCategory =By.xpath("//button[@data-id='category_id']");
    private By unit =By.xpath("//input[@name='unit']");
    private By itemCategory = By.xpath("//span[text()='Sport shoes']");
    private By miniQty = By.xpath("//input[@name='min_qty']");
    private By tag = By.xpath("//span[@class='tagify__input']");
    private By unitPrice = By.xpath("//input[@name='unit_price']");
    private By discount = By.xpath("//input[@name='discount']");
    private By quantity = By.xpath("//input[@name='current_stock']");
    private By publishButton = By.xpath("//button[@value='publish']");

    public AddNewProduct verifyRedirectToProductPage() {
        WebUI.waitForPageLoaded();
        boolean checkHeader = WebUI.isDisplayed(headerPage);
        System.out.println("Check Header Customer: " + checkHeader);
        Assert.assertTrue(checkHeader, "Add New Product");
        return this;
    }

    public AddNewProduct addNewProduct(String company) {
        new DashboardPage().openAddNewProductPage();
        WebUI.waitForPageLoaded();
        WebUI.setText(inputProductName, "SPA");
        WebUI.selectItemInDrodown(dropdownCategory, itemCategory);
        WebUI.setText(unit, "KG");
        WebUI.setText(miniQty, "1");
        WebUI.setText(tag, "ABC");
        WebUI.setText(unitPrice, "1");
        WebUI.setText(discount, "0.5");
        WebUI.setText(quantity, "2");
        WebUI.clickElement(publishButton);
        return this;
    }


}
