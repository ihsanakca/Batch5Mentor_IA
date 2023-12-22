package com.kraft.tests.day13_actions_JsExecutor_FileUpload_WebTables;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class _1_Actions {
    WebDriver driver;
    Actions actions;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void hoverOver() throws InterruptedException {

        /**  CLASS TASK
         * navigate to https://testpages.herokuapp.com/styled/csspseudo/css-hover.html
         * hover over "Hover Para" element
         * get the text which is seen after hover action
         * and verify that the text is "You can see this paragraph now that you hovered on the above 'button'."
         * also verify that the text is displayed (use explicit wait)
         * hover over the "Hover Div" and verify that the text is not displayed anymore. (use explicit wait)
         */

        driver.get("https://testpages.herokuapp.com/styled/csspseudo/css-hover.html");

        WebElement hoverPara = driver.findElement(By.id("hoverpara"));


        actions.moveToElement(hoverPara).perform();
        Thread.sleep(2000);

        WebElement hoverParaEffect = driver.findElement(By.id("hoverparaeffect"));

        String expectedText = "You can see this paragraph now that you hovered on the above 'button'.";
        String actualText = hoverParaEffect.getText();

        Assert.assertEquals(actualText, expectedText);

        Assert.assertTrue(new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(hoverParaEffect)).isDisplayed());

        WebElement hoverDiv = driver.findElement(By.id("hoverdivpara"));
        actions.moveToElement(hoverDiv).perform();
        Thread.sleep(2000);

        Assert.assertTrue(new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOf(hoverParaEffect)));

    }

    @Test
    public void dragAndDrop() {
        /**  CLASS TASK
         * go to https://webdriveruniversity.com/Actions/index.html
         * take the "DRAG ME TO MY TARGET!" box and drop it "DROP HERE!" place
         * verify that "Dropped!" text is displayed..(make text correction at the same time)
         */

        driver.get("https://webdriveruniversity.com/Actions/index.html");

        WebElement dragElement = driver.findElement(By.id("draggable"));
        WebElement dropElement = driver.findElement(By.id("droppable"));

        //actions.dragAndDrop(dragElement,dropElement).perform();
        actions.moveToElement(dragElement).clickAndHold().moveToElement(dropElement).pause(2000).release().build().perform();

        WebElement dropText = driver.findElement(By.cssSelector("#droppable>p>b"));

        Assert.assertEquals(dropText.getText(), "Dropped!");
        Assert.assertTrue(dropText.isDisplayed());

    }

    @Test
    public void clickWithAction() {

        /**  CLASS TASK
         * navigate to https://skill-test.net/mouse-double-click
         * make double click to the Click box
         * make a normal click to the Click Box (not the middle of element)
         */

        driver.get("https://skill-test.net/mouse-double-click");

        WebElement clicker = driver.findElement(By.cssSelector("button#clicker"));
        //double click
        actions.doubleClick(clicker).perform();

        actions.moveToElement(clicker).doubleClick().perform();

        //normal click
        actions.click(clicker).perform();

        //normal click tıklama yeri tarif ederek
        actions.moveToElement(clicker, 10, 12).click().perform();

        System.out.println("clicker.getSize() = " + clicker.getSize());

    }

    @Test
    public void rightClick() {

        /**  CLASS TASK
         * navigate to https://skill-test.net/right-click-test
         * make right click to the Start box and wait three seconds
         * make normal click on Reset box (use actions)
         */

        driver.get("https://skill-test.net/right-click-test");

        WebElement clicker = driver.findElement(By.cssSelector("#clicker"));
        //right click

        actions.contextClick(clicker).perform();
        actions.moveToElement(clicker).contextClick().perform();

        WebElement reset = driver.findElement(By.cssSelector("#reset"));

        actions.click(reset).perform();

    }

    @Test
    public void fillingFormWithAction() {
        /**  CLASS TASK
         * go to https://www.krafttechexlab.com/login
         * send your credentials to related boxes and then click login button
         * click on Add Experience link
         * fill form with action class
         * verify the success message after submitted the form
         */


        driver.get("https://www.krafttechexlab.com/login");
        List<WebElement> inputs = driver.findElements(By.cssSelector("input:not(#rememberMe),button"));

        inputs.get(0).sendKeys("mgezer@gmail.com");
        inputs.get(1).sendKeys("Mg12345678");
        inputs.get(2).click();

        driver.findElement(By.xpath("//span[text()='Melih Gezer']")).click();
        driver.findElement(By.xpath("//span[text()='My Profile']")).click();

        WebElement addExperience = driver.findElement(By.xpath("//li//button[text()='Add Experience']"));
        addExperience.click();

        WebElement jobTitle = driver.findElement(By.cssSelector("input#job"));

        actions.click(jobTitle)
                .sendKeys("Coğrafya Öğretmeni" + Keys.TAB)
                .sendKeys("Bahçeşehir Koleji" + Keys.TAB)
                .sendKeys("İzmir" + Keys.TAB)
                .sendKeys("11112012" + Keys.TAB + Keys.TAB)
                .sendKeys("12122015" + Keys.TAB)
                .sendKeys("Nice Job" + Keys.TAB + Keys.ENTER)
                .perform();
    }

    @Test
    public void rightClickOpenNewTab() {
        /** CLASS TASK
         * go to https://testpages.herokuapp.com/styled/csspseudo/css-hover.html
         * make right click and open in new tab  (sağ ctrl+click)
         * switch to new opened tab
         * verify that the page title is "EvilTester.com"
         */

        driver.get("https://testpages.herokuapp.com/styled/csspseudo/css-hover.html");

        WebElement evilLink = driver.findElement(By.linkText("EvilTester.com"));

        actions.keyDown(Keys.LEFT_CONTROL)
                .click(evilLink)
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();

        //switch to new page

        ArrayList<String> tabIds = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabIds.get(1));


        String actualTitle = driver.getTitle();
        String expectedTitle = "EvilTester.com";

        Assert.assertEquals(actualTitle,expectedTitle);

    }


}
