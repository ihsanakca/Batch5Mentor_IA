package com.kraft.tests.day04_basicLocators;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _1_ById {
    public static void main(String[] args) throws InterruptedException {

        /**
         * open chrome browser and navigate to http://www.eurotech.study/
         * accept cookies if any
         * locate DevEx web element by using id locator
         * get the text of web element and print it
         * make verification
         * close driver.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://www.eurotech.study/");

        Thread.sleep(2000);


        //accept cookies  //lazy way
        driver.findElement(By.id("rcc-confirm-button")).click();

        //id ile locate etme
        WebElement devExElement = driver.findElement(By.id("landingpage-innercontainer-h1"));

        String devExElementText = devExElement.getText();

        String  expectedText="DevEx";

        if (devExElementText.equals(expectedText))
            System.out.println("pass");
        else
            System.out.println("fail");

        Thread.sleep(1000);

        driver.quit();

    }
    /**
     * 1- id.ler çoğunlukla unique(eşsiz) olur.. ancak yine de kontrol etmek gerekir.
     * 2- id'nin unique olup olmadığı dev tools'ta arama (ctrl+f) bölümünde başına # işareti konularak kontrol edilir.
     * 3- Bir elementin id'si varsa locate işleminde id'si kullanılır. öncelikle id'ye bakılır.
     * 4- id'ler nadiren de olsa dinamik (değişken) olabilir.. bunu sayfayı refresh yaparak kontrol edebiliriz.
     * refresh yapıldığında id değişmiyorsa static (sabit) değeri vardır..
     */

}
