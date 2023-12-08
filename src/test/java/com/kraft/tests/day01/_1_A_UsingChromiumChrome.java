package com.kraft.tests.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_A_UsingChromiumChrome {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\ihsan\\OneDrive\\Masaüstü\\chromedriver-win64 (3)\\chromedriver-win64\\chromedriver.exe");

      //  WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");

    }
}
