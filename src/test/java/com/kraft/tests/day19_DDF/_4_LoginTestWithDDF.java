package com.kraft.tests.day19_DDF;

import com.kraft.pages.DashboardPage;
import com.kraft.pages.LoginPage;
import com.kraft.tests.TestBase;
import com.kraft.utilities.ConfigurationReader;
import com.kraft.utilities.ExcelUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _4_LoginTestWithDDF extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    @DataProvider
    public Object[][] userData(){
        ExcelUtil qaTeam1 = new ExcelUtil(ConfigurationReader.get("excelPath"), "QaTeam1");
        return qaTeam1.getDataArrayWithoutFirstRow();
    }

    @Test (dataProvider = "userData" )
    public void loginTestDDF(String yourName,String email, String password){
        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();

        extentLogger= report.createTest("TC_005 "+yourName+"'s Login Test");

        extentLogger.info("Kraft Login sayfasını açılır");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Geçerli kimlik bilgilerini girilir");

        loginPage.login(email,password);

        extentLogger.info("Dashboard sayfasının açıldığı doğrulanır");
        dashboardPage.verifyUserName(yourName);

        extentLogger.pass("Passed..!");


    }
}
