package com.kraft.tests.day18_xmlRunner;

import com.kraft.pages.AddEducationPage;
import com.kraft.pages.DashboardPage;
import com.kraft.pages.LoginPage;
import com.kraft.pages.UserProfilePage;
import com.kraft.tests.TestBase;
import com.kraft.utilities.BrowserUtils;
import com.kraft.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _1_AddEducationTestWithExtentReport extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    UserProfilePage userProfilePage;
    AddEducationPage addEducationPage;
    @Test
    public void addEducationTest(){
        /**
         1-open chrome browser
         2-navigate to https://www.krafttechexlab.com/login by using configuration.properties
         3-login with parameterized/non-parameterized method
         4-Assert successful login with user name
         5-Navigate to My Profile with related method
         6-Verify that User Profile page is displayed
         7-Navigate to Add Education tab with related method
         8-Verify that add education page is displayed
         9-Fill the form with parameterized method (use actions class)
         10-Verify that added education record can be seen at user profile page... (assert with school name)
         11-Delete last added education record

         important note: every student should use own credentials, otherwise the test case will fail....
         */

        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();
        userProfilePage=new UserProfilePage();
        addEducationPage=new AddEducationPage();

        extentLogger=report.createTest("US_5 TC_008 Add Education Test");

        extentLogger.info("open chrome browser");
        extentLogger.info("navigate to https://www.krafttechexlab.com/login");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("login with parameterized/non-parameterized method");
        loginPage.login();

        extentLogger.info("Assert successful login with user name");
        dashboardPage.verifyUserName(ConfigurationReader.get("userName"));

        extentLogger.info("Navigate to My Profile with related method");
        dashboardPage.navigateTabAndModule(ConfigurationReader.get("userName"),"My Profile");

        extentLogger.info("Verify that User Profile page is displayed");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(userProfilePage.userProfilePageTitle)).isDisplayed());

        extentLogger.info("Navigate to Add Education tab with related method");
        userProfilePage.navigateUserProfileTabs("Add Education");

        extentLogger.info("Verify that add education page is displayed");
        Assert.assertTrue(BrowserUtils.waitForVisibility(addEducationPage.addEducationBtn,10).isDisplayed());

        extentLogger.info("Fill the form with parameterized method (use actions class)");
        addEducationPage.fillingAddEducationForm("Aksaray Uni","Bachelor","Public Finance","11122012",
                "10102016","Easy Program");

        extentLogger.info("Verify that added education record can be seen at user profile page");
        String actualRecord = userProfilePage.addedLastEducationRecordName("Aksaray Uni");
        String expectedRecord="Aksaray Uni";
        Assert.assertEquals(actualRecord,expectedRecord);

        extentLogger.info("Delete last added education record");
        userProfilePage.deleteLastAddedEducationRecord("Aksaray Uni");

        extentLogger.pass("Passed...!");


    }

}
