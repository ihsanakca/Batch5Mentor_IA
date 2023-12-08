package com.kraft.tests.day06_cssLocator;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _3_CssContainsStartsWithEndsWithParenToChild {
    public static void main(String[] args) throws InterruptedException {
        /**
         * class task
         * navigate to http://www.eurotech.study/
         * click cookies button css contains (*)
         * click login button with css starts-with (^)
         * send your email to email box with css ends-with ($)
         * send your password to password box with css parent to child (>)
         * click login btn with css parent to grandson (space)
         * -----------------------------
         * [attribute*='value'] (contains)
         * tagName[attribute*='value'] (contains)
         *
         * [attribute^='firstPartOfValue'] (starts with)
         * tagName[attribute^='firstPartOfValue'] (starts with)
         *
         * [attribute$='lastPartOfValue'] (ends-with)
         * tagName[attribute$='lastPartOfValue'] (ends-with)
         *
         * xpath '/'  --> parent to child
         * css   '>'  --> parent to child
         * xpath '//' --> parent to grandson
         * css   ' '  --> parent to grandson  (space-boşluk)
         *   */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.eurotech.study/");
        Thread.sleep(2000);

        //cookies
        driver.findElement(By.cssSelector("[aria-label*='ookies']")).click();

        //login click
        driver.findElement(By.cssSelector("[class^='btn btn-l']")).click();

        //enter email
        WebElement email = driver.findElement(By.cssSelector("[placeholder$='Address']"));
        email.sendKeys("sgezer56@gmail.com");

        //enter password
        WebElement password=driver.findElement(By.cssSelector("#loginpage-form-pw-container>input"));
        password.sendKeys("Sg12345678");

        Thread.sleep(2000);

        //click login btn
        driver.findElement(By.cssSelector("section input[type='submit']")).click();

        Thread.sleep(2000);

        driver.quit();

    }
}
