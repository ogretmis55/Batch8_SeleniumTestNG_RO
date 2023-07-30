package com.eurotech.tests.day_20_pom_2;

import com.eurotech.pages.AddExperiencePage;
import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.UserProfilePage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Add_Experience_Task extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    UserProfilePage userProfilePage;
    AddExperiencePage addExperiencePage;


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
 10-Verify that Add Experience record can be seen at user profile page...  (assert with job title)
 11-Delete last added Experience record
 */
    @Test
    public void addExperienceTest(){
        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();
        userProfilePage=new UserProfilePage();
        addExperiencePage=new AddExperiencePage();


        loginPage.login();
        BrowserUtils.waitForVisibility(dashboardPage.userName, 5);

        WebElement userNameText = dashboardPage.userName;
        String actualUserName= userNameText.getText();
        String expectedUserName= ConfigurationReader.get("userName");

        Assert.assertEquals(actualUserName,expectedUserName);

        dashboardPage.navigateToTabsAndModules(ConfigurationReader.get("userName"),"My Profile");
        BrowserUtils.waitForVisibility(userProfilePage.userProfilePageTitle, 5);

        userProfilePage.navigateUserProfileTabs("Add Experience");

        Assert.assertTrue(BrowserUtils.waitForVisibility(addExperiencePage.addExperienceBtn,5).isDisplayed());

        addExperiencePage.fillAddExperienceForm();

        BrowserUtils.waitForVisibility(userProfilePage.userProfilePageTitle, 2);

        String actualExperienceName = userProfilePage.addedExperienceName(addExperiencePage.jobTitleName);
        String expectedExperienceName= addExperiencePage.jobTitleName;

        Assert.assertEquals(actualExperienceName,expectedExperienceName);

        userProfilePage.deleteExperience(addExperiencePage.jobTitleName);

    }

}