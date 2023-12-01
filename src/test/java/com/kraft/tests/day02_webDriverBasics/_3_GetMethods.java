package com.kraft.tests.day02_webDriverBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _3_GetMethods {
    public static void main(String[] args) {
        /**
         * set up a chrome driver
         * navigate to https://www.hepsiburada.com/
         * get title and get url get page source code
         * verify that title, url and Page source codes  contain "hepsiburada"
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.get("https://www.hepsiburada.com/");

        String actualTitle=driver.getTitle();  //sayfanın başlığını alır

        String actualUrl=driver.getCurrentUrl();  //seleniumun üzerinde bulunduğu sayfanın urlini alır

        String actualSourceCode=driver.getPageSource();

        if (actualTitle.toLowerCase().contains("hepsiburada")&&actualUrl.toLowerCase().contains("hepsiburada")
        &&actualSourceCode.toLowerCase().contains("hepsiburada")){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }

        driver.quit();

    }
}
