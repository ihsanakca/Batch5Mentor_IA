package com.kraft.tests.day05_xPath;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _4_RelativeXPath {
    public static void main(String[] args) throws InterruptedException {
        /**
         * task
         * navigate to https://demoqa.com/automation-practice-form
         * locate first name input box with xPath (parent-child relations)
         * send "Ayşegül" to the input box
         * locate sports checkbox with xPath (parent-child relations)
         * click to the checkbox
         * locate Student Registration Form element by xPath (parent-child relations)
         * get the text of web element and print it
         * close the driver
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        Thread.sleep(2000);
        driver.get("https://demoqa.com/automation-practice-form");

        WebElement firstName = driver.findElement(By.xpath("//div[text()='Practice Form']/parent::div/following-sibling::div/descendant::input[@placeholder='First Name']"));
        firstName.sendKeys("Ayşegül");

        driver.findElement(By.xpath("//*[@id='hobbies-checkbox-1']/..")).click();
        Thread.sleep(2000);

        WebElement formTitle = driver.findElement(By.xpath("//*[@id='hobbies-checkbox-1']/../ancestor::form/preceding-sibling::*"));
        System.out.println("formTitle.getText() = " + formTitle.getText());

        driver.close();

    }
}
