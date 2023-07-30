package com.eurotech.tests.day_22_xml_runner;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.EditProfilePage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.UserProfilePage;
import com.eurotech.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _1_VerifyUserInfo extends TestBase {
    /** Class Task
     * Login as a Mike
     * Verify that login is successful
     * Click on My profile
     * Click on Edit Profile
     * Verify that job is SDET
     * userEmail=mike@gmail.com
     * userPassword=mike1234
     */

    LoginPage loginPage;
    DashboardPage dashboardPage;

    UserProfilePage userProfilePage;
    EditProfilePage editProfilePage;

    @Test
    public void verifyUserInfoTest(){
        loginPage=new LoginPage();
        userProfilePage=new UserProfilePage();
        editProfilePage=new EditProfilePage();

        extentLogger=report.createTest("TC001 ExtentTest");
        extentLogger.info("go to url");
       // driver.get("url");
        extentLogger.info("Login as a Mike");

        loginPage.login("mike@gmail.com","mike1234");

        extentLogger.info("Verify that login is successful");

        String actualResult=loginPage.userNameAtRightTop.getText();
        String expectedResult="mike";
        Assert.assertEquals(actualResult,expectedResult);

        extentLogger.info("Click on My Profile");
        loginPage.navigateToTabsAndModules("mike","My Profile");

        extentLogger.info("Click on Edit Profile");
        userProfilePage.navigateUserProfileTabs("Edit Profile");

        extentLogger.info("Verify that job is SDET");
        String expectedJobTitle="SDET";
        String actualJobTitle=editProfilePage.getSelected();

        Assert.assertEquals(actualJobTitle,expectedJobTitle);
        extentLogger.pass("Passed");


    }
}
