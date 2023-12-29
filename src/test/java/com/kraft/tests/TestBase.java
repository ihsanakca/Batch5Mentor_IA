package com.kraft.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.kraft.utilities.BrowserUtils;
import com.kraft.utilities.ConfigurationReader;
import com.kraft.utilities.Driver;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    static protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;

    @BeforeTest
    public void setUpTest(){
        report=new ExtentReports();

        String projectPath=System.getProperty("user.dir");
        String reportPath=projectPath+"/test-output/report.html";

        htmlReporter=new ExtentHtmlReporter(reportPath);

        report.attachReporter(htmlReporter);

        htmlReporter.config().setReportName("Mentor Test Report");

        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("Test engineer", System.getProperty("user.name"));
        report.setSystemInfo("PO", "Samet Emsen");
    }

    @AfterTest
    public void tearDownTest(){
        report.flush();

    }

    @BeforeMethod
    public void setUp() {
        driver = Driver.get();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();
        actions = new Actions(driver);
        wait=new WebDriverWait(driver,10);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        //eğer test başarısız ise
        if (result.getStatus()==ITestResult.FAILURE){
            //başarısız testin adını alalım
            extentLogger.fail(result.getName());
            //ekran görüntüsünü alalım ve kayıt edileceği yeri belirleyelim.
            String screenShotPath= BrowserUtils.getScreenshot(result.getName());
            //screenshotı pathi kulllanarak raporuma ekleyeyim.
            extentLogger.addScreenCaptureFromPath(screenShotPath);
            //log ve exception kayıtlarını da teste ekleyelim
            extentLogger.fail(result.getThrowable());
        }

        Driver.closeDriver();
    }
}
