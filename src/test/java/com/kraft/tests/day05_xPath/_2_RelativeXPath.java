package com.kraft.tests.day05_xPath;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _2_RelativeXPath {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome
         * navigate to https://www.amazon.com.tr/
         * accept cookies if any (use xPath formula with known attribute value)
         * locate search bar with xPath formula with known attribute value
         * send "Selenium" word to the search bar
         * locate search button with xPath formula with known attribute value
         * click search button
         * Get the search result by the formula of the text feature of Xpath (two ways)
         * get the text of web element and print it.
         * close driver.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.amazon.com.tr/");

        Thread.sleep(2000);

        //accept cookies
        driver.findElement(By.xpath("//input[@value='all']")).click();

        WebElement searchBar = driver.findElement(By.xpath("//input[@name='field-keywords']"));
        searchBar.sendKeys("Selenium");

        WebElement searchBtn=driver.findElement(By.xpath("//input[@value=\"Git\"]"));
        searchBtn.click();
        Thread.sleep(2000);

        WebElement result = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        System.out.println("result.getText() = " + result.getText());

        WebElement result2 = driver.findElement(By.xpath("//span[text()='\"Selenium\"']"));
        System.out.println("result2.getText() = " + result2.getText());

        WebElement result3 = driver.findElement(By.xpath("//span[.='\"Selenium\"']"));
        System.out.println("result3.getText() = " + result3.getText());

        Thread.sleep(2000);

        driver.quit();
    }
}
