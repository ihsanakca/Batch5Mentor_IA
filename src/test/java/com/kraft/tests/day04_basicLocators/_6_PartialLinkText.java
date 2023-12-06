package com.kraft.tests.day04_basicLocators;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _6_PartialLinkText {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome browser and navigate to http://www.eurotech.study/
         * accept cookies if any
         * locate Sign Up button web element by using partial link text locator
         * get the text of web element and print it
         * click to the web element
         * close driver.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://www.eurotech.study/");

        Thread.sleep(2000);

        //accept cookies  //lazy way
        driver.findElement(By.id("rcc-confirm-button")).click();

        WebElement signUp = driver.findElement(By.partialLinkText("n U"));

        System.out.println("signUp.getText() = " + signUp.getText());

        signUp.click();

        Thread.sleep(2000);

        driver.quit();

    }
}
/**
 * 1- a tag'ı ve href attribute'u olan web elementlerde kullanılır...
 * 2- <a class="btn btn-light" href="https://www.uzunihsan.com/login">ABCDEF</a> --> web elementinde ABCDEF link text kısmıdır..
 * bu text'in unique (eşsiz) olan bir bölümü alınarak kullanılır.. mesela DEF kısmı olabilir... yazının sırası bozulmamalıdır.
 * 3- text kısmının bir bölümü alınmalıdır..
 */