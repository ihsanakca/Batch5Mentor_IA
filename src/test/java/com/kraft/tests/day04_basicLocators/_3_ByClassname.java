package com.kraft.tests.day04_basicLocators;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _3_ByClassname {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome browser and navigate to http://www.eurotech.study/
         * accept cookies if any
         * locate main paragraph web element by using class name locator
         * get the text of web element and print it
         * close driver.
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://www.eurotech.study/");

        Thread.sleep(2000);


        //accept cookies  //lazy way
        driver.findElement(By.id("rcc-confirm-button")).click();

        WebElement mainParagraph = driver.findElement(By.className("lead"));

        System.out.println("mainParagraph.getText() = " + mainParagraph.getText());

        driver.quit();


    }
}
/**
 * 1. dinamik olmazlar..
 * 2. çoğunlukla birden fazla web elementin class name attribute değeri aynı olabilir. birden fazla web elementi
 * işaret etmeleri durumunda selenium ilk elemente gider ve onunla işlem yapar..
 * 3. unique (eşsiz) olup olmadığı dev tools arama (ctrl+f ile açılan yerde) bölümünde başına "." işareti
 *  konularak kontrol edilebilir. By.className("clasname") içine yazılırken "." işareti olmadan kullanılır..
 *  4. class name değeri genellikle space yani boşluk içerir.. bu durumda By.className("clas name") ile kullanılamazlar.
 *  bu durumda cssSelector ile uygun işlem yapıldıktan sonra kullanılabilirler...(Css konusu)
 */
