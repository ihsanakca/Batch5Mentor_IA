package com.kraft.tests.day17_extentReports;

import com.kraft.pages.DashboardPage;
import com.kraft.pages.LoginPage;
import com.kraft.tests.TestBase;
import com.kraft.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _2_LoginTestWithExtentReport extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void loginTest(){
        /**
         * navigate to kraft login page
         * login with valid credentials
         * verify that the user's name is seen on dashboard page
         */

        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();

        extentLogger= report.createTest("US_1 TC001 Positive Login Test");

        extentLogger.info("navigate to kraft login page");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("login with valid credentials");
        loginPage.login(ConfigurationReader.get("email"),ConfigurationReader.get("password"));

        extentLogger.info("verify that the user's name is seen on dashboard page");
        dashboardPage.verifyUserName(ConfigurationReader.get("userName"));

        extentLogger.pass("Passed..!");

    }
    @Test
    public void loginTest_2(){
        /**
         * navigate to kraft login page
         * login with valid credentials
         * verify with url (https://www.krafttechexlab.com/index) that the user is on the dashboard page
         */

        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();

        extentLogger= report.createTest("US_1 TC002 Positive Login Test");

        extentLogger.info("navigate to kraft login page");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("login with valid credentials");
        loginPage.login(ConfigurationReader.get("email"),ConfigurationReader.get("password"));

        extentLogger.info("verify with url that the user is on the dashboard page ");
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.krafttechexlab.com/index61";

        Assert.assertEquals(actualUrl,expectedUrl);

        extentLogger.pass("Passed..!");

    }
}
