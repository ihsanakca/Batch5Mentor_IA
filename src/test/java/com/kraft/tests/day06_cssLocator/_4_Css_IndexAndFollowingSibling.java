package com.kraft.tests.day06_cssLocator;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _4_Css_IndexAndFollowingSibling {
    public static void main(String[] args) throws InterruptedException {
        /**
         * navigate to https://demoqa.com/automation-practice-form
         * send "hasan@hasan.com" to email box with css index
         * send "Bağcılar/İstanbul" to current address box with css sibling
         * close driver
         * --------------
         * cssSyntax--->tagName :nth-of-type(indexNumber)
         * cssSyntax--->tagName :nth-child(indexNumber)
         * NOTE: sadece aynı parent altındaki web elementlerde kullanılır..
         *
         * css following sibling (~)
         * cssSyntax:tagName[]~tagName[]
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/automation-practice-form");
        Thread.sleep(2000);

        WebElement email = driver.findElement(By.cssSelector("form>div:nth-of-type(2)>div~div>input"));
        email.sendKeys("hasan@hasan.com");

        WebElement address = driver.findElement(By.cssSelector("h5~form textarea"));
        address.sendKeys("Bağcılar/İstanbul");

        Thread.sleep(2000);

        driver.quit();


    }
}
