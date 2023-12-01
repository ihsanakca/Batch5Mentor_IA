package com.kraft.tests.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_Intro {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://www.facebook.com");

        //how to take page title
        String expectedTitle="Facebook – log in or sign up";
        String actualTitle=driver.getTitle();

        //verification
        if (actualTitle.equals(expectedTitle))
            System.out.println("pass");
        else
            System.out.println("fail");

    }
}
