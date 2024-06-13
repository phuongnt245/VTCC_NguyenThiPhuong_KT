package com.phuongnt.Exam.testcases;

import com.phuongnt.Exam.pages.DashboardPage;
import com.phuongnt.Exam.pages.LoginPage;
import com.phuongnt.common.BaseTest;
import com.phuongnt.keywords.WebUI;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void testOpenPage(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");

        dashboardPage.openPage("Customers");
        WebUI.sleep(2);
        dashboardPage.openPage("Projects");
        WebUI.sleep(2);
        dashboardPage.openPage("Tasks");
        WebUI.sleep(2);
    }

    @Test
    public void testTotalOfTasksNotFinished(){
        loginPage = new LoginPage();
        loginPage.loginCRM("admin@example.com", "123456");
        dashboardPage = new DashboardPage();
        dashboardPage.verifyRedirectToDashboardPage();
        dashboardPage.verifyTotalOfTasksNotFinished("1 / 1");
    }
}
