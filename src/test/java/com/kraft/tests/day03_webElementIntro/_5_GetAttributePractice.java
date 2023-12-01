package com.kraft.tests.day03_webElementIntro;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _5_GetAttributePractice {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Task
         * open chrome browser
         * go to http://www.eurotech.study/
         * click I understand button and accept cookies
         * take the value of the attributes (class and href) of the login button and print the values.
         * click login button
         * send "sdfsdsd" into email address input box
         * click Login button
         * get the message which appears on the email input box
         * VERIFY that the message contains "Please include an '@' in the email address."
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.eurotech.study/");

        Thread.sleep(2000);

        //lazy way
        driver.findElement(By.id("rcc-confirm-button")).click();

        Thread.sleep(2000);

        WebElement firstLoginBtn = driver.findElement(By.xpath("//a[text()='Login']"));
        String aClass = firstLoginBtn.getAttribute("class");
        String aHref = firstLoginBtn.getAttribute("href");

        Thread.sleep(2000);

        System.out.println("aClass = " + aClass);
        System.out.println("aHref = " + aHref);

        firstLoginBtn.click();
        Thread.sleep(2000);

        WebElement emailBar = driver.findElement(By.id("loginpage-input-email"));
        emailBar.sendKeys("sdfsdsd");

        driver.findElement(By.id("loginpage-form-btn")).click();

        String errorMessage = emailBar.getAttribute("validationMessage");

        System.out.println("errorMessage = " + errorMessage);

        String expectedErrorMessage="Please include an '@' in the email address.";

        if (errorMessage.contains(expectedErrorMessage))
            System.out.println("pass");
        else
            System.out.println("fail");
        Thread.sleep(2000);


        driver.quit();

    }
}
