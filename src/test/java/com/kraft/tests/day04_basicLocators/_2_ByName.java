package com.kraft.tests.day04_basicLocators;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _2_ByName {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome browser and navigate to https://testpages.herokuapp.com/styled/basic-html-form-test.html
         * locate username input box by using name locator
         * send a random name to the box
         * clear the box
         * send another name to the box
         * get the second name which sent to the box and assign it to a string variable
         * print the second name
         * make verification
         * close driver.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");


        Thread.sleep(2000);
        WebElement username = driver.findElement(By.name("username"));
        Thread.sleep(2000);
        username.sendKeys("Mark Ruffalo");
        Thread.sleep(2000);
        username.clear();
        Thread.sleep(2000);
        username.sendKeys("Tracy McGready");
        Thread.sleep(2000);

        String actualText = username.getAttribute("value");

        System.out.println("actualText = " + actualText);

        driver.quit();
    }
}
/**
 * 1. name'ler id.ler gibi dinamik olmazlar..
 * 2. ancak birden fazla web elementin name attribute değeri aynı olabilir. Bu durumda locate işleminde kullanılmaları halinde
 * selenium her zaman ilkine gider ve o web element ile işlem yapar..
 */