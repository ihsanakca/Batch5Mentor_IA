package com.kraft.tests.day16_pom_2;

import com.kraft.utilities.BrowserUtils;
import com.kraft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _2_SametTest {

    WebDriver driver;

    @Test
    public void test1(){
        driver = Driver.get();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();
        driver.get("https://practice.automationtesting.in/");

        WebElement firstImage=driver.findElement(By.xpath("//img[@alt='Shop Selenium Books']"));

        WebElement rightArrow=driver.findElement(By.id("n2-ss-6-arrow-next"));
        boolean bl=true;
        int count=1;

       while (bl){
           rightArrow.click();
           BrowserUtils.waitFor(3);
           System.out.println(firstImage.isDisplayed());
           if (!firstImage.isDisplayed()){
              count++;
           }else {
               bl=false;
           }

       }
        System.out.println("count = " + count);
        Assert.assertEquals(count,3);

        driver.quit();
    }
}
