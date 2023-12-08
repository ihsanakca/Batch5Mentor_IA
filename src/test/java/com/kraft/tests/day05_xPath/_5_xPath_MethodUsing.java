package com.kraft.tests.day05_xPath;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class _5_xPath_MethodUsing {
   static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
         driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://demowebshop.tricentis.com/");

        String [] products={"$25 Virtual Gift Card","Build your own cheap computer","Build your own cheap computer"};

        for (int p = 0; p < products.length; p++) {
            Thread.sleep(2000);
            clickToProductAddToCart(products[p]);
        }


        Thread.sleep(2000);

        driver.close();
    }

    public static void clickToProductAddToCart(String productName) throws InterruptedException {
        driver.findElement(By.xpath("//a[text()='"+productName+"']/../..//input")).click();
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(2000);
    }
}
