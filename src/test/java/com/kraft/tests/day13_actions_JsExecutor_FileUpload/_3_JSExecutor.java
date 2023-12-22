package com.kraft.tests.day13_actions_JsExecutor_FileUpload;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _3_JSExecutor {

    WebDriver driver;
    Actions actions;
    JavascriptExecutor js;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
        js= (JavascriptExecutor) driver;
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1(){
        /** CLASS TASK
         * navigate to https://www.amazon.com.tr/
         * accept cookies if any
         * click Almanya link with js executor
         * accept cookies if any
         * verify that the url contains amazon.de
         *
         * note : ask google how to click with js executor
         */

        driver.get("https://www.amazon.com.tr/");

        //accept cookies
      //  driver.findElement(By.id("sp-cc-accept")).click();

        WebElement almanya = driver.findElement(By.linkText("Almanya"));
        //almanya.click();

        JavascriptExecutor js= (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", almanya);

        //accept cookies
        driver.findElement(By.id("sp-cc-accept")).click();
        String actualUrl=driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains("amazon.de"));

    }

    @Test
    public void test2() throws InterruptedException {

        /**   CLASS TASK
         * navigate to https://www.krafttechexlab.com/forms/elements
         * type in Text element with js "Batch 5 was here."
         * scroll 1000 px down
         * change the Range position (actions ile)
         * change the Disabled Range position
         * scroll to the Number label
         * change the color from blue to red
         * type in "Batch 5 was also here." to disable text area
         * select the Disabled Radio 3 button
         * scroll to the submit button
         * scroll again to the number label
         * scroll to the submit button and click on it
         * take the new page title and url
         * verify that the page title contains "Kraft"
         * verify that the page url contains "kraft"
         *
         * not: all steps should be done with js executor except step 3 and last one.
         */

        driver.get("https://www.krafttechexlab.com/forms/elements");

        WebElement textElement = driver.findElement(By.cssSelector("[name='text']"));

        String value="Batch 5 was here.";

        js.executeScript("arguments[0].value='"+ value +"';", textElement);

        js.executeScript("window.scrollBy(0,1000)");

        WebElement customRange1 = driver.findElement(By.id("customRange1"));

        Thread.sleep(2000);

        actions.dragAndDropBy(customRange1,500,0).build().perform();

        Thread.sleep(2000);

        WebElement disabledRange = driver.findElement(By.id("disabledRange"));

        js.executeScript("arguments[0].setAttribute('min', '-15')",disabledRange);

        WebElement numberLabel = driver.findElement(By.xpath("//label[text()='Number']"));

        js. executeScript("arguments[0]. scrollIntoView();",numberLabel );
        Thread.sleep(2000);

        WebElement colorPicker = driver.findElement(By.id("exampleColorInput"));
        js.executeScript("arguments[0].setAttribute('value', '#FF0000')",colorPicker);

        WebElement textDisabled = driver.findElement(By.name("textDisabled"));
        value="Batch 5 was also here.";

        js.executeScript("arguments[0].value='"+ value +"';", textDisabled);

        WebElement disableRadioBtn = driver.findElement(By.id("gridRadios"));
        js.executeScript("arguments[0].setAttribute('checked', 'true')",disableRadioBtn);
        js.executeScript("arguments[0].removeAttribute('disabled')",disableRadioBtn);

        WebElement submitBtn = driver.findElement(By.xpath("//button[text()='Submit Form']"));
        js. executeScript("arguments[0]. scrollIntoView();",submitBtn );
        Thread.sleep(2000);
        js. executeScript("arguments[0]. scrollIntoView();",numberLabel );
        Thread.sleep(2000);

        js.executeScript("arguments[0].scrollIntoView(true);" + "arguments[0].click()", submitBtn);

        String actualTitle = js.executeScript("return document.title;").toString();
        System.out.println("actualTitle = " + actualTitle);
        String actualUrl = js.executeScript("return document.URL;").toString();
        System.out.println("actualUrl = " + actualUrl);

        Assert.assertTrue(actualTitle.contains("Kraft"));
        Assert.assertTrue(actualUrl.contains("kraft"));

    }
}
