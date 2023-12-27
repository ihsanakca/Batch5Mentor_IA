package com.kraft.pages;

import com.kraft.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DashboardPage extends BasePage{

    @FindBy(tagName = "h2")
    public WebElement userName;

    public void verifyUserName(String expectedUserName){
        Assert.assertEquals(userName.getText(),expectedUserName);
    }
}
