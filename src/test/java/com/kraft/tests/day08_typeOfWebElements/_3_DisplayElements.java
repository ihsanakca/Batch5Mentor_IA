package com.kraft.tests.day08_typeOfWebElements;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class _3_DisplayElements {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        /**
         * navigate to https://the-internet.herokuapp.com/dynamic_loading
         * click the first link (Example 1: Element on page that is hidden)
         * locate start button and "Hello World!" text element
         * verify that Hello World! is NOT displayed
         * click start button
         * wait 5 seconds
         * verify that Hello World! is now displayed
         * take the text of element and print it
         */

        driver.get("https://the-internet.herokuapp.com/dynamic_loading");

        WebElement firstLink = driver.findElement(By.linkText("Example 1: Element on page that is hidden"));
        firstLink.click();

        WebElement helloWorld = driver.findElement(By.xpath("//*[text()='Hello World!']"));
        assertFalse(helloWorld.isDisplayed());
        System.out.println("helloWorld.getText() = " + helloWorld.getText());

        WebElement start = driver.findElement(By.tagName("button"));

        start.click();
        Thread.sleep(5000);

        assertTrue(helloWorld.isDisplayed());
        System.out.println("helloWorld.getText() = " + helloWorld.getText());


    }

    @Test
    public void task(){

        /**  Task
         * navigate to https://the-internet.herokuapp.com/dynamic_loading
         * click the second link (Example 2: Element rendered after the fact)
         * click start button
         * verify that hello element is displayed (bu elementin locate işlemi starta clickten sonra yapılmalı)
         * get the element text and print it
         */

    }

}
