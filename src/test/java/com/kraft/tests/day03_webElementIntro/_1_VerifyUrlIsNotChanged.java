package com.kraft.tests.day03_webElementIntro;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _1_VerifyUrlIsNotChanged {
    public static void main(String[] args) {
        /**
         * Task
         * open chrome browser
         * go to https://demoqa.com/login
         * click on login button
         * VERIFY that url is not changed
         */


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/login");

        String expectedUrl = "https://demoqa.com/login";

        WebElement loginBtn = driver.findElement(By.id("login"));
        loginBtn.click();

        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl))
            System.out.println("pass");
        else
            System.out.println("fail");
        driver.quit();
    }
}
