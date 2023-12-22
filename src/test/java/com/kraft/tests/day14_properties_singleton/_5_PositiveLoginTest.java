package com.kraft.tests.day14_properties_singleton;

import com.kraft.tests.TestBase;
import com.kraft.utilities.ConfigurationReader;
import com.kraft.utilities.Driver;
import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _5_PositiveLoginTest extends TestBase {
//    WebDriver driver;
//    Actions actions;
//
//    @BeforeMethod
//    public void setUp() {
//        driver = Driver.get();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().setPosition(new Point(-1000,0));
//        driver.manage().window().maximize();
//        actions = new Actions(driver);
//    }
//
//    @AfterMethod
//    public void tearDown()  {
//        Driver.closeDriver();
//    }

    @Test
    public void loginTest(){
        driver.get(ConfigurationReader.get("url"));
        WebElement emailBox = driver.findElement(By.id("email"));
        emailBox.sendKeys(ConfigurationReader.get("email"));

        WebElement passwordBox = driver.findElement(By.id("yourPassword"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));

        WebElement loginBtn = driver.findElement(By.tagName("button"));
        loginBtn.click();

    }
}
