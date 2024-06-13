package com.phuongnt.Exam.testcases;

import com.phuongnt.Exam.pages.LoginPage;
import com.phuongnt.Exam.pages.ProductDetailPage;
import com.phuongnt.Exam.pages.ProductListPage;
import com.phuongnt.common.BaseTest;
import com.phuongnt.helpers.CaptureHelper;
import org.testng.annotations.Test;

public class AddSearchProduct extends BaseTest {
    private String PRODUCT_NAME = "SPA";
    private LoginPage loginPage = new LoginPage();
    ProductListPage productPage = new ProductListPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();

    @Test
    public void testAddNewProduct() {
        CaptureHelper.captureScreenshot("addNewProduct");
        CaptureHelper.startRecord("testAddNewProduct");

        //Fluent design pattern
        loginPage.loginCRM("admin@example.com", "123456")
                .openAddNewProductPage()
                .verifyRedirectToProductPage()
                .addNewProduct(PRODUCT_NAME);
        productPage.verifyAddProduct(PRODUCT_NAME);
    }

    @Test
    public void searchProduct() {
        productPage.searchProductName(PRODUCT_NAME);
        productDetailPage.verifyProductDetail(PRODUCT_NAME);
    }
}
