package com.kraft.tests.day05_xPath;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _3_RelativeXPath {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Task
         * open chrome browser
         * go to http://www.eurotech.study/
         * click I understand button and accept cookies (use xPath-contains text)
         * locate login button (use xPath - known attribute (class) contains )
         * click login button
         * locate email address input box (use xPath -starts-with (id))
         * send "abc@abc.com" into email address input box
         * locate second login button (use xPath - * -> use star in xPath formula )
         * click Login button
         * close browser.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.eurotech.study/");
        Thread.sleep(2000);

        //accept cookies
        driver.findElement(By.xpath("//button[contains(text(),'under')]")).click();

        WebElement loginBtn = driver.findElement(By.xpath("//a[contains(@class,'btn btn-l')]"));
        loginBtn.click();
        Thread.sleep(2000);

        WebElement emailBar = driver.findElement(By.xpath("//input[starts-with(@id,'loginpage-i')]"));
        emailBar.sendKeys("abc@abc.com");

        WebElement secondLgnBtn=driver.findElement(By.xpath("//*[@*='Login']"));
        secondLgnBtn.click();

        Thread.sleep(2000);

        driver.quit();


    }
}
