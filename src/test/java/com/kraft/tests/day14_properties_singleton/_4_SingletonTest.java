package com.kraft.tests.day14_properties_singleton;

import com.kraft.utilities.Driver;
import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class _4_SingletonTest {

    @Test
    public void test1(){
//        WebDriver driver = WebDriverFactory.getDriver("chrome");
//        driver.navigate().to("https://www.amazon.com.tr");

        WebDriver driver1 = Driver.get();
        driver1.manage().window().setPosition(new Point(-1000,0));
        driver1.manage().window().maximize();
        driver1.get("https://www.amazon.com.tr");


    }

    @Test
    public void test2() {
//       WebDriver driver = WebDriverFactory.getDriver("chrome");
//        driver.navigate().to("https://www.google.com.tr");

        WebDriver driver1 = Driver.get();
        driver1.get("https://www.google.com.tr");
    }
    @Test
    public void test3(){
        WebDriver driver1 = Driver.get();
        driver1.findElement(By.name("q")).sendKeys("Selenium"+ Keys.ENTER);
    }
}
