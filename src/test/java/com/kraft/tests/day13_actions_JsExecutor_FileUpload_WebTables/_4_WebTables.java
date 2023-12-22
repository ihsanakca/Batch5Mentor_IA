package com.kraft.tests.day13_actions_JsExecutor_FileUpload_WebTables;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class _4_WebTables {

    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1(){
        /**  CLASS TASK
         * navigate to https://the-internet.herokuapp.com/tables
         * get the data of specific cell by using row and column numbers
         */

        driver.get("https://the-internet.herokuapp.com/tables");

        String relatedCellData=dataOfCell(1,2);
        System.out.println("relatedCellData = " + relatedCellData);
        
        //print all table
        
        int rowNumber=getRowNumber();
        int columnNumber=getColumnNumber();

        for (int i = 1; i <=rowNumber ; i++) {
            for (int j = 1; j <=columnNumber ; j++) {
                System.out.print(dataOfCell(i, j)+" ");
            }
            System.out.println();
        }
    }

    private int getColumnNumber() {
        List<WebElement> columns = driver.findElements(By.xpath("//table[@id='table1']/thead//th"));
        return columns.size();
    }

    private int getRowNumber() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return rows.size();
    }

    private String dataOfCell(int row, int column) {
        WebElement element =
                driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + row + "]/td[" + column + "]"));
        return element.getText();
    }

}
