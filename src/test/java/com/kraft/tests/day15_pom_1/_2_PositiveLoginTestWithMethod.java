package com.kraft.tests.day15_pom_1;

import com.kraft.pages.LoginPage;
import com.kraft.tests.TestBase;
import com.kraft.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class _2_PositiveLoginTestWithMethod extends TestBase {

    LoginPage loginPage;

    @Test
    public void test1() {
        driver.get(ConfigurationReader.get("url"));

        // LoginPage loginPage=new LoginPage();
        loginPage = new LoginPage();
        loginPage.login();
    }

    @Test
    public void test2() {
        driver.get(ConfigurationReader.get("url"));

        //   LoginPage loginPage=new LoginPage();
        loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("email"), ConfigurationReader.get("password"));
    }

    @Test
    public void test3() {
        driver.get(ConfigurationReader.get("url"));

        //  LoginPage loginPage=new LoginPage();
        loginPage = new LoginPage();
        loginPage.login("mgezer@gmail.com", "Mg12345678");
    }
}
