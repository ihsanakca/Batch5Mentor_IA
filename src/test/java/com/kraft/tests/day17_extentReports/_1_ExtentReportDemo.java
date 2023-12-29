package com.kraft.tests.day17_extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.kraft.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _1_ExtentReportDemo {
    //Bu obje ile raporu oluştururuz ve rapora ait metadata'yı tanımlarız.
    ExtentReports report;
    //Raporumuzun html formatında olmasını sağlar.
    ExtentHtmlReporter htmlReporter;

    //Her test ile ilgili loglamama işlemlerimizi yaparız.
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUP(){
        //initialize  report
        report=new ExtentReports();

        //raporun kayıt yerini belirleyelim.
        String projectPath=System.getProperty("user.dir");
        String reportPath=projectPath+"/test-output/report.html";

        //html raporumuzu path ile oluşturalım.
        htmlReporter=new ExtentHtmlReporter(reportPath);

        //html raporumuzu report nesnesiyle ilişkilendirelim
        report.attachReporter(htmlReporter);

        //raporun başlığı düzenleyelim
        htmlReporter.config().setReportName("Mentor Test Report");

        //raporun metadatasını yani genel hususları düzenleyelim.
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("Test engineer", System.getProperty("user.name"));
        report.setSystemInfo("PO", "Samet Emsen");
    }

    @Test
    public void test1(){
        //mevcut testimizin ismini girelim
        extentLogger=report.createTest("Login Test");

        //test adımları
        extentLogger.info("Chrome browserı aç");
        //kodlar buraya
        extentLogger.info("Url'e git : "+ConfigurationReader.get("url"));
        //kodlar buraya
        extentLogger.info("Emaili gir: "+ConfigurationReader.get("email"));
        //kodlar buraya
        extentLogger.info("Passwordu gir");
        //kodlar buraya
        extentLogger.info("Login butonuna bas");
        //kodlar buraya
        extentLogger.info("User name ile login olduğunu doğrula");
        //kodlar buraya

        //eğer kod buraya kadar gelmişse, test geçmiş demektir.
        extentLogger.pass("Passed");
    }

    @AfterMethod
    public void tearDown(){
        //raporun gerçek anlmada oluşturulduğu yer
        report.flush();
    }


}
