package com.kraft.tests.typeOfWebElements;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _4_DisableElements {

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
         * go to https://the-internet.herokuapp.com/dynamic_controls
         * locate disable text bar
         * verify that the element is disabled
         * locate and click the Enable button
         * send "The element is now enabled!!" keys to the bar
         * verify that the element is enabled.
         */

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement textBar = driver.findElement(By.cssSelector("input[type='text']"));

        Assert.assertFalse(textBar.isEnabled());

        WebElement button = driver.findElement(By.cssSelector("#input-example>button"));
        button.click();
        Thread.sleep(5000);

        textBar.sendKeys("The element is now enabled!!");
        Assert.assertTrue(textBar.isEnabled());

    }

    @Test
    public void task(){

        /**
         * navigate to http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html
         * locate pumpkin element
         * verify that the element is enabled
         * verify that the element is selected
         * verify that the element is displayed
         * locate cabbage element
         * verify that the element is NOT enabled
         * verify that the element is NOT selected
         * verify that the element is displayed
         */
    }
}
