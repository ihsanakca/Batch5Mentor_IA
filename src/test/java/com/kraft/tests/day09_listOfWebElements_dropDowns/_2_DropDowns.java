package com.kraft.tests.day09_listOfWebElements_dropDowns;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class _2_DropDowns {
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
        /**    CLASS TASK
         * navigate to https://www.amazon.com.tr/"
         * accept cookies if any
         * locate the dropdown menu nearby the search box
         * get all departments(web elements) as a list
         * verify that the number of webElement is 21
         * click (select) "PC ve Video Oyunları" with index:16
         * verify that the selected option's text is 'PC ve Video Oyunları'
         */
        driver.get("https://www.amazon.com.tr/");

        //accept cookies
        WebElement cookies = driver.findElement(By.id("sp-cc-accept"));
        cookies.click();

        WebElement searchDropdownBox = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(searchDropdownBox);

        List<WebElement> options = select.getOptions();

        Assert.assertEquals(options.size(),21);

        options.get(16).click();

        WebElement firstSelectedOption = select.getFirstSelectedOption();
        String actualText = firstSelectedOption.getText();
        String expectedText="PC ve Video Oyunları";

        Assert.assertEquals(actualText,expectedText);

        /** select the "Bebek" department by using visible text
         * then verify the department name
         */

        select.selectByVisibleText("Bebek");
        firstSelectedOption= select.getFirstSelectedOption();
        actualText=firstSelectedOption.getText();
        expectedText="Bebek";

        Assert.assertEquals(actualText,expectedText);

        /** select the "Kitaplar" department by using index 9
         * then verify the department name
         */

        select.selectByIndex(9);
        firstSelectedOption= select.getFirstSelectedOption();
        actualText=firstSelectedOption.getText();
        expectedText="Kitaplar";

        Assert.assertEquals(actualText,expectedText);
        //second way
        options.get(9).click();

        firstSelectedOption= select.getFirstSelectedOption();
        actualText=firstSelectedOption.getText();
        expectedText="Kitaplar";

        Assert.assertEquals(actualText,expectedText);

        /** select the "Otomotiv" department by using value attribute
         * then verify the department name
         */

        select.selectByValue("search-alias=automotive");
        firstSelectedOption= select.getFirstSelectedOption();
        actualText=firstSelectedOption.getText();
        expectedText="Otomotiv";

        Assert.assertEquals(actualText,expectedText);

        options.forEach(e-> System.out.println(e.getText()));
    }

    @Test
    public void test2() throws InterruptedException {
        /**    CLASS TASK
         * navigate to https://www.amazon.com.tr/"
         * accept cookies if any
         * locate the dropdown menu nearby the search box
         * get all departments(web elements) as a list
         * verify that the number of webElement is 21
         * click (select) "PC ve Video Oyunları" with index:16
         * verify that the selected option's text is 'PC ve Video Oyunları'
         */
        driver.get("https://www.amazon.com.tr/");

        //accept cookies
        WebElement cookies = driver.findElement(By.id("sp-cc-accept"));
        cookies.click();

        selectCategoryAndGo("Kitaplar");


    }

    void selectCategoryAndGo(String categoryName){
        WebElement searchDropdownBox = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(searchDropdownBox);
        select.selectByVisibleText(categoryName);

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(Keys.ENTER);

    }

    @Test
    public void test3() throws InterruptedException {

        /**   CLASS TASK
         * navigate to https://demo.aspnetawesome.com/
         * locate and click DropdownList (Mango ile başlayan liste)
         * get all option names and print them
         * click potato by index (6) and make verification
         * click again drop down list
         * click rice with its own locator (Rice'ı locate edip tıklayalım.)
         * then make verification
         */

        driver.get("https://demo.aspnetawesome.com/");

        WebElement dropDown = driver.findElement(By.id("AllMeals-awed"));
        System.out.println("dropDown = " + dropDown);

        System.out.println(dropDown.getText());
        dropDown.click();

        Thread.sleep(1000);

        List<WebElement> options = driver.findElements(By.cssSelector(".o-igit"));

        options.forEach(e->{
            System.out.println(e.getText());
        });

        options.get(6).click();
        Thread.sleep(1000);

        String actualText=dropDown.getText();
        String expectedText="Potato";

        Assert.assertEquals(actualText,expectedText);

        dropDown.click();

        //click on Rice

        WebElement rice=driver.findElement(By.xpath("//div[text()='Rice']"));
        rice.click();


        actualText=dropDown.getText();
        expectedText="Rice";

        Assert.assertEquals(actualText,expectedText);

        //stale element hatası alınmaması için değişen liste tekrar locate edilmelidir.
        options = driver.findElements(By.cssSelector(".o-igit"));
        options.get(20).click();



    }
}
