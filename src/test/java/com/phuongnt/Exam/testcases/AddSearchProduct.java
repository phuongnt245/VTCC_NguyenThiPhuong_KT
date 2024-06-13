package com.phuongnt.Exam.testcases;

import com.phuongnt.Exam.pages.LoginPage;
import com.phuongnt.Exam.pages.ProductDetailPage;
import com.phuongnt.Exam.pages.ProductListPage;
import com.phuongnt.common.BaseTest;
import org.testng.annotations.Test;

public class AddSearchProduct extends BaseTest {

    //private LoginPage loginPage;
    //private ProductListPage productPage;
//    private ProductDetailPage productDetailPage;
    private String PRODUCT_NAME = "yenttb";
    private LoginPage loginPage = new LoginPage();
    ProductListPage productPage = new ProductListPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();

    @Test
    public void testAddNewProduct() {

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
