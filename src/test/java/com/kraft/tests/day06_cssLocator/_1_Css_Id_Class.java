package com.kraft.tests.day06_cssLocator;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class _1_Css_Id_Class {
    public static void main(String[] args) throws InterruptedException {
        /**
         * navigate to http://www.eurotech.study/
         * click cookies button with css id
         * click Sign Up button css class
         * sign up click
         * send "Ahmet" to name box by css id with tag
         * click register button by css class with tag
         * close driver
         *--------------------
         * #id
         * tagName#id
         * -------------------
         * .className
         * tagName.className
         * Note: eğer class name'de boşluk varsa silinip yerine . (nokta) konulur.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.eurotech.study/");
        Thread.sleep(2000);

        //cookies
        driver.findElement(By.cssSelector("#rcc-confirm-button")).click();
        Thread.sleep(2000);

        //sign up btn click
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        Thread.sleep(2000);

        //name  //lazy way
        driver.findElement(By.cssSelector("input#signuppage-form-name-input")).sendKeys("Ahmet");

        //register btn
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

        Thread.sleep(2000);

        driver.quit();
    }
}
