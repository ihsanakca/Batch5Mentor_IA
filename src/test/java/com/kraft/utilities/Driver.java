package com.kraft.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {

    private Driver(){}

    private static WebDriver driver;

    public static WebDriver get(){
        if (driver==null){
            String browser = ConfigurationReader.get("browser");

            switch (browser.toLowerCase()){
                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "chrome-headless" :
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "firefox-headless" :
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;
                case "edge" :
                    if(!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Edge");
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    break;
            }
        }
        return driver;
    }

    public static void closeDriver(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
