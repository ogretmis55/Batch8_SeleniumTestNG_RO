package com.eurotech.tests.day_23_DDF;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.zip.CRC32;

public class _4_DDF_LoginTest extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @DataProvider
    public Object[][] userData(){
        ExcelUtil qaTeam1= new ExcelUtil(ConfigurationReader.get("excelPath"),"QaTeam1");
        String[][] dataArrayWithoutFirstRow = qaTeam1.getDataArrayWithoutFirstRow();

        return dataArrayWithoutFirstRow;
    }
    @Test (dataProvider = "userData")
    public void loginTestWithDDF(String fullName, String yourEmail, String password){

        extentLogger= report.createTest("TC_005 "+fullName+"'s Login Test");
        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();

        extentLogger.info("navigate to Kraft Login Page");
        extentLogger.info("login with valid credentials");
        loginPage.login(yourEmail,password);

        extentLogger.info("Verify success login with username");
        String actualUsername= dashboardPage.userName.getText();
        Assert.assertEquals(actualUsername,fullName);

        extentLogger.pass("Passed..!");
    }

    @DataProvider
    public Object [][] userData2(){
        ExcelUtil qaTeam2=new ExcelUtil(ConfigurationReader.get("excelPath"),"QaTeam2");
        String[][] dataArrayWithoutFirstRow= qaTeam2.getDataArrayWithoutFirstRow();

        return dataArrayWithoutFirstRow;
    }
    @Test (dataProvider = "userData2")
    public void  loginTestWithDDF2(String yourEmail, String password,String fullName){
        extentLogger= report.createTest("TC_006 "+fullName+"'s Login Test");
        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();

        extentLogger.info("navigate to Kraft Login Page");
        extentLogger.info("login with valid credentials");
        loginPage.login(yourEmail,password);

        extentLogger.info("Verify success login with username");
        String actualUsername= dashboardPage.userName.getText();
        Assert.assertEquals(actualUsername,fullName);

        extentLogger.pass("Passed..!");
    }



}
