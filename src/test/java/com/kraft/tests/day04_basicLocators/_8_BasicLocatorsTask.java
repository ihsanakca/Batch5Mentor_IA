package com.kraft.tests.day04_basicLocators;

import com.github.javafaker.Faker;
import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _8_BasicLocatorsTask {
    public static void main(String[] args) throws InterruptedException {
        /** Class Task
         * go to the url - "https://www.browserstack.com/users/sign_up"
         * maximize the window
         * accept cookies if any ,
         * fill in the blanks with the faker class
         * click "Term of service" checkbox
         * and close the window
         *
         * hint: u can use any locator you want
         *
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.browserstack.com/users/sign_up");

        Thread.sleep(2000);

        //accept cookies
        driver.findElement(By.id("accept-cookie-notification")).click();

        Faker faker=new Faker();

        String fullName=faker.name().fullName();
        String email=faker.internet().emailAddress();
        String pass=faker.internet().password(8,16,true,true,true);

        WebElement userFullName = driver.findElement(By.id("user_full_name"));
        userFullName.sendKeys(fullName);

        Thread.sleep(2000);
        WebElement emailElement = driver.findElement(By.name("user[email]"));
        emailElement.sendKeys(email);

        //lazy way
        driver.findElement(By.id("user_password")).sendKeys(pass);

        Thread.sleep(2000);
        driver.findElement(By.name("terms_and_conditions")).click();

        Thread.sleep(2000);

        driver.quit();



    }
}
