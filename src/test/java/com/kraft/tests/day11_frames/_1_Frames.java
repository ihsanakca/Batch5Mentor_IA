package com.kraft.tests.day11_frames;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _1_Frames {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        /**
         * navigate to https://testpages.herokuapp.com/styled/iframes-test.html
         * switch to first frame by id
         * take the "iFrame" heading and print it
         * return to main html
         * switch to second frame by web element
         * take the "Nested Page Example" heading and print it
         */


        driver.get("https://testpages.herokuapp.com/styled/iframes-test.html");

        driver.switchTo().frame("thedynamichtml");

        WebElement titleFrame = driver.findElement(By.tagName("h1"));
        String actualTitle = titleFrame.getText();
        String expectedTitle = "iFrame";

        Assert.assertEquals(actualTitle, expectedTitle);

        driver.switchTo().parentFrame();

        WebElement secondFrame = driver.findElement(By.cssSelector("#header-iframe>iframe"));
        driver.switchTo().frame(secondFrame);

        titleFrame = driver.findElement(By.tagName("h1"));
        actualTitle = titleFrame.getText();
        expectedTitle = "Nested Page Example";

        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @Test
    public void test2(){
        /**
         * navigate to https://demoqa.com/nestedframes
         * switch to parent frame by id
         * take the "Parent frame" heading and print it
         * switch to child frame by index
         * take the "Child frame" heading and print it
         * switch to main frame related method
         * take the "Nested Frames" heading and print it
         */

        driver.get("https://demoqa.com/nestedframes");

        driver.switchTo().frame("frame1");

        WebElement parentFrame = driver.findElement(By.tagName("body"));
        System.out.println("parenFrame.getText() = " + parentFrame.getText());

        driver.switchTo().frame(0);
        WebElement childFrame = driver.findElement(By.tagName("p"));
        System.out.println("childFrame.getText() = " + childFrame.getText());

        driver.switchTo().defaultContent();

        WebElement mainTitle = driver.findElement(By.className("main-header"));
        System.out.println("mainTitle.getText() = " + mainTitle.getText());

    }
}
