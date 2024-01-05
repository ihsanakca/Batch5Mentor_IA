package com.kraft.tests.day20_miscellaneous;

import com.kraft.pages.LoginPageLocators;
import com.kraft.tests.TestBase;
import com.kraft.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class _4_LoginTestWithInterfaceLocators extends TestBase implements LoginPageLocators {

    @Test
    public void test1(){
        /**
         * navigate to kraft login page
         * Prepare an interface and put emailBox, passwordBox and Login button locators there
         * call these locators and send keys to them and have login to the site
         */
        driver.get(ConfigurationReader.get("url"));
        driver.findElement(email_Box).sendKeys(ConfigurationReader.get("email"));
        driver.findElement(password_Box).sendKeys(ConfigurationReader.get("password"));
        driver.findElement(login_Btn).click();
    }

    @Test
    public void test2(){
        /**
         * navigate to kraft login page
         * Prepare a login method in the interface
         * call this method and have login to the site
         */
        driver.get(ConfigurationReader.get("url"));
        login();
        // login(ConfigurationReader.get("email"),ConfigurationReader.get("password"));
    }
}
