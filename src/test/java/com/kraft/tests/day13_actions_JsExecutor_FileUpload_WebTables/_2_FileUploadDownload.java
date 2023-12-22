package com.kraft.tests.day13_actions_JsExecutor_FileUpload_WebTables;

import com.kraft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class _2_FileUploadDownload {
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
    public void systemPropertiesTest(){
        Properties properties = System.getProperties();
        //bütün sistem özelliklerini yazdıralım
       // properties.list(System.out);

        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
        System.out.println("System.getProperty(\"user.home\") = " + System.getProperty("user.home"));

    }

    @Test
    public void fileUpload(){
        /** CLASS TASK
         * proje kapsamında dosya yükleme işlemi
         * test klasörü altında resources directory'si oluşturulur (projeye dışarıdan eklenecek dosyalar burada olur.)
         * upload edilecek dosya bu klasöre kopyalanır (ccc.txt)
         * System.getProperty() metodu kullanılarak.. projenin yolu (path) alınır..
         * upload edilecek dosyaya sağ click yapılarak, projeden sonraki yolu (path) alınır..
         * iki path araya "/"  slash konularak birleştirilir. Artık projeyi her indirenin kullanabileceği path oluşur..
         * bu path kullanılarak dosya upload edilir.
         */

        driver.get("https://demoqa.com/upload-download");

        WebElement uploadFile = driver.findElement(By.id("uploadFile"));

        String projectPath=System.getProperty("user.dir");
        String filePath="src/test/resources/ccc.txt";
        String fullPath=projectPath+"/"+filePath;

        uploadFile.sendKeys(fullPath);

        WebElement uploadedFilePath = driver.findElement(By.id("uploadedFilePath"));
        String text = uploadedFilePath.getText();

        Assert.assertTrue(text.contains("ccc.txt"));
    }

    @Test
    public void fileDownLoad() throws InterruptedException, IOException {
        /** CLASS TASK
         * navigate to https://the-internet.herokuapp.com/download
         * click on test.txt to download
         * verify that the test.txt file is downloaded to the Downloads directory
         * remove the downloaded file
         *
         * Note: Bir dosyanın bilgisayarınızda verilen path'in gösterdiği yerde olup olmadığını
         * Java'dan gelen Files classının exists metodu ile kontrol edebiliriz. Bu metod bir boolean değer döner.
         */

        driver.get("https://the-internet.herokuapp.com/download");

        WebElement downloadLink = driver.findElement(By.linkText("test.txt"));
        downloadLink.click();

        Thread.sleep(5000);
        //verification
        String filePath = System.getProperty("user.home") + "/Downloads/test.txt";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));

        Thread.sleep(2000);

        //delete file
        Files.delete(Paths.get(filePath));

    }
}
