package com.eurotech.tests.day_21_extentReport;

import com.eurotech.pages.AddExperiencePage;
import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.UserProfilePage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _4_AddExperienceTestWithExtentReport_Task extends TestBase {
    /**
     1-open chrome browser
     2-navigate to https://www.krafttechexlab.com/login by using configuration.properties
     3-login with parameterized/non-parameterized method
     4-Assert successful login with user name
     5-Navigate to My Profile with related method
     6-Verify that User Profile page is displayed
     7-Navigate to Add Experience tab with related method
     8-Verify that Add Experience page is displayed
     9-Fill the form with method (use actions class)
     10-Verify that Add Experience record can be seen at user profile page... (assert with job title)
     11-Delete last added Experience record*/

    LoginPage loginPage;
    DashboardPage dashboardPage;
    UserProfilePage userProfilePage;
    AddExperiencePage addExperiencePage;

    @Test
    public void AddExperiencePageTest(){
        extentLogger= report.createTest("TC0010 Add Experience Test");
        loginPage=new LoginPage();
        dashboardPage =new DashboardPage();
        userProfilePage=new UserProfilePage();
        addExperiencePage=new AddExperiencePage();

        extentLogger.info("open chrome browser");
        extentLogger.info("navigate to "+ ConfigurationReader.get("url"));
        extentLogger.info("login with non-parameterized method");
        loginPage.login();

        extentLogger.info("Assert successful login with user name");
        String actualUserName=dashboardPage.userName.getText();
        String expectedUserName= ConfigurationReader.get("userName");
        Assert.assertEquals(actualUserName,expectedUserName, "user names should be same");

        extentLogger.info("Navigate to My Profile with related method");
        dashboardPage.navigateToTabsAndModules(ConfigurationReader.get("userName"),"My Profile");
        extentLogger.info("Verify that User Profile page is displayed");
        Assert.assertTrue(BrowserUtils.waitForVisibility(userProfilePage.userProfilePageTitle,5).isDisplayed());

        extentLogger.info("Navigate to Add Experience tab with related method");
        userProfilePage.navigateUserProfileTabs("Add Experience");
        extentLogger.info("Verify that Add Experience page is displayed");
        Assert.assertTrue(BrowserUtils.waitForVisibility(addExperiencePage.addExperienceBtn,5).isDisplayed());

        extentLogger.info("Fill the form with method (use actions class)");
        addExperiencePage.fillAddExperienceForm();
        BrowserUtils.waitForVisibility(userProfilePage.userProfilePageTitle, 2);
        extentLogger.info("Verify that Add Experience record can be seen at user profile page... (assert with jobTitle)");

        String actualJobTitle= userProfilePage.addedExperienceName(addExperiencePage.jobTitleName);
        String expectedJobTitle= addExperiencePage.jobTitleName;
        Assert.assertEquals(actualJobTitle,expectedJobTitle);

        extentLogger.info("Delete last added Experience record");
        userProfilePage.deleteExperience(addExperiencePage.jobTitleName);









    }


}
