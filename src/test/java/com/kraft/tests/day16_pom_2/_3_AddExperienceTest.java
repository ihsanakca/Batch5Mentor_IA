package com.kraft.tests.day16_pom_2;

import com.kraft.pages.AddExperiencePage;
import com.kraft.pages.DashboardPage;
import com.kraft.pages.LoginPage;
import com.kraft.pages.UserProfilePage;
import com.kraft.tests.TestBase;
import com.kraft.utilities.BrowserUtils;
import com.kraft.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _3_AddExperienceTest extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    UserProfilePage userProfilePage;

    AddExperiencePage addExperiencePage;

    @Test
    public void addExperience() {
        /**
         1-go to kraft login page
         2-make login
         3-Assert successful login with user name
         4-Navigate to My Profile with related method
         5-Verify that User Profile page is displayed
         6-Navigate to Add Experience tab with related method
         7-Verify that add experince page is displayed
         8-Fill the form with non-parameterized method (using actions class is optional)
         9-Verify that added experience record can be seen at user profile page... (assert with job title)
         10-Delete last added experience record

         important note: every student should use own credentials, otherwise the test case will fail....
         */

        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        userProfilePage = new UserProfilePage();
        addExperiencePage = new AddExperiencePage();

        driver.get(ConfigurationReader.get("url"));

        loginPage.login();

        dashboardPage.verifyUserName(ConfigurationReader.get("userName"));
        dashboardPage.navigateTabAndModule(ConfigurationReader.get("userName"), "My Profile");

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(userProfilePage.userProfilePageTitle)).isDisplayed());

        userProfilePage.navigateUserProfileTabs("Add Experience");

        Assert.assertTrue(BrowserUtils.waitForVisibility(addExperiencePage.addExperienceBtn, 10).isDisplayed());

        addExperiencePage.fillingAddExperienceForm();

        String actualTitle = userProfilePage.addedLastExperienceRecordName(addExperiencePage.jobTitle);
        String expectedTitle = addExperiencePage.jobTitle;

        Assert.assertEquals(actualTitle, expectedTitle);

        userProfilePage.deleteLastAddedExperienceRecord(addExperiencePage.jobTitle);


    }
}
