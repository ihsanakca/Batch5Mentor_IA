package com.kraft.tests.day10_alerts_multipleWindows;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class _3_MultipleWindows {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        /**   CLASS TASK
         *navigate to "https://testpages.herokuapp.com/styled/windows-test.html"
         * click Basic Ajax in new page
         * switch to new opened page
         * verify that the page title is "Test Page For Basic Ajax Example"
         * verify that the new page's url is different
         */

        driver.get("https://testpages.herokuapp.com/styled/windows-test.html");

        driver.findElement(By.linkText("Basic Ajax in new page")).click();

        Thread.sleep(2000);

        String currentTab = driver.getWindowHandle();
        Set<String> allTabs = driver.getWindowHandles();

        System.out.println("currentTab = " + currentTab);
        System.out.println("allTabs = " + allTabs);

        for (String tab : allTabs) {
            if(!currentTab.equals(tab)){
                driver.switchTo().window(tab);
                break;
            }
        }

        String actualTitle=driver.getTitle();
        String expectedTitle="Test Page For Basic Ajax Example";

        Assert.assertEquals(actualTitle,expectedTitle);

        Assert.assertFalse(driver.getCurrentUrl().equals("https://testpages.herokuapp.com/styled/windows-test.html"));


    }

    @Test
    public void test2() throws InterruptedException {
        /**  CLASS TASK
         *navigate to "https://testpages.herokuapp.com/styled/windows-test.html"
         * click all three links
         * switch to the page whose title is "Test Page For Element Attributes"
         * verify that the page title
         * verify that the new page's url is different
         */
        driver.get("https://testpages.herokuapp.com/styled/windows-test.html");

        driver.findElement(By.linkText("Basic Ajax in new page")).click();
        driver.findElement(By.linkText("Alerts In A New Window From JavaScript")).click();
        driver.findElement(By.linkText("Attributes in new page")).click();

        Thread.sleep(2000);

        Set<String> allTabs = driver.getWindowHandles();

        String targetTitle="Test Page For Element Attributes";

        for (String tab : allTabs) {
            driver.switchTo().window(tab);
            if (driver.getTitle().equals(targetTitle)){
                break;
            }
        }

        String actualTitle=driver.getTitle();

        Assert.assertEquals(actualTitle,targetTitle);
        Assert.assertFalse(driver.getCurrentUrl().equals("https://testpages.herokuapp.com/styled/windows-test.html"));
    }
}
