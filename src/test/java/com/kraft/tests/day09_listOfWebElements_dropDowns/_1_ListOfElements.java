package com.kraft.tests.day09_listOfWebElements_dropDowns;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class _1_ListOfElements {
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

        /**    CLASS TASK
         * navigate to https://www.saucedemo.com/
         * locate login form elements with one locator (username box, password box and login button)
         * send "standard_user" to username box
         * send "secret_sauce" to password box
         * click Login button
         * then take all product names to a web element list and print the text of elements
         * verify that first web element text is "Sauce Labs Backpack"
         */

        driver.get("https://www.saucedemo.com/");

        List<WebElement> inputs = driver.findElements(By.tagName("input"));

        inputs.get(0).sendKeys("standard_user");
        inputs.get(1).sendKeys("secret_sauce");
        inputs.get(2).click();

        List<WebElement> items = driver.findElements(By.cssSelector(".inventory_item_name"));

        List<String > itemNames=new ArrayList<>();

        for (WebElement item : items) {
            String str=item.getText();
            System.out.println("item.getText() = " + str);
            itemNames.add(str);
        }

        Assert.assertEquals(itemNames.get(0),"Sauce Labs Backpack");

    }
}
