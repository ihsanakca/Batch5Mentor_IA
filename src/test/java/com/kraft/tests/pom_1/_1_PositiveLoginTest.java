package com.kraft.tests.pom_1;

import com.kraft.pages.LoginPage;
import com.kraft.tests.TestBase;
import com.kraft.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class _1_PositiveLoginTest extends TestBase {

    @Test
    public void test1(){
        LoginPage loginPage=new LoginPage();

        driver.get(ConfigurationReader.get("url"));

        loginPage.emailBox.sendKeys(ConfigurationReader.get("email"));
        loginPage.passwordBox.sendKeys(ConfigurationReader.get("password"));
       // loginPage.loginBtn.click();
        loginPage.click(loginPage.loginBtn);
    }

    @Test
    public void test2(){
        LoginPage loginPage=new LoginPage();

        driver.get(ConfigurationReader.get("url"));

        loginPage.loginInputs.get(0).sendKeys(ConfigurationReader.get("email"));
        loginPage.loginInputs.get(1).sendKeys(ConfigurationReader.get("password"));
        loginPage.loginInputs.get(2).click();
    }
}
