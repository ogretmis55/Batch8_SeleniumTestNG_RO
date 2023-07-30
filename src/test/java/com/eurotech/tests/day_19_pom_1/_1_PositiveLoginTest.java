package com.eurotech.tests.day_19_pom_1;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _1_PositiveLoginTest extends TestBase {

    LoginPage loginPage = new LoginPage();
    @Test
    public void positiveLoginTest_OldVersion() {
        /**
         * navigate to https://www.krafttechexlab.com/login
         * login with valid credentials
         * verify success login with page title (contains Dashboard)
         *
         * old version
         */

        driver.get(ConfigurationReader.get("url"));

        WebElement emailBox = driver.findElement(By.id("email"));
        WebElement passwordBox = driver.findElement(By.id("yourPassword"));
        WebElement loginBtn = driver.findElement(By.xpath("//*[text()='Login']"));

        emailBox.sendKeys(ConfigurationReader.get("userEmail"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));
        loginBtn.click();

        //verification
        String actualTitle = driver.getTitle();
        String exceptedTitle = "Dashboard";

        Assert.assertTrue(actualTitle.contains(exceptedTitle));
    }

    @Test
    public void positiveLoginTest_1() {
        /**
         * navigate to https://www.krafttechexlab.com/login
         * login with valid credentials
         * verify success login with page title (contains Dashboard)
         * POM version
         */


      /*
        WebElement emailBox = loginPage.emailBox;
        WebElement passwordBox = loginPage.passwordBox;
        WebElement loginBtn = loginPage.loginBtn;

        emailBox.sendKeys(ConfigurationReader.get("userEmail"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));
        loginBtn.click();
*/
        LoginPage loginPage = new LoginPage();
        loginPage.emailBox.sendKeys(ConfigurationReader.get("userEmail"));
        loginPage.passwordBox.sendKeys(ConfigurationReader.get("password"));
        loginPage.loginBtn.click();

        //verification
        String actualTitle = driver.getTitle();
        String exceptedTitle = "Dashboard";

        Assert.assertTrue(actualTitle.contains(exceptedTitle));
    }

    @Test
    public void positiveLoginTest_2() {
        /**
         * navigate to https://www.krafttechexlab.com/login
         * login with valid credentials
         * verify success login with page title (contains Dashboard)
         * POM version (FindBys and FindAll)
         */

       LoginPage loginPage = new LoginPage();

        loginPage.emailBoxWithFindBys.sendKeys(ConfigurationReader.get("userEmail"));
        loginPage.passwordBoxWithFindAll.sendKeys(ConfigurationReader.get("password") + Keys.ENTER);
        // loginPage.passwordBoxWithFindAll.sendKeys(ConfigurationReader.get("password")+ Keys.TAB+Keys.TAB+Keys.TAB+Keys.ENTER);

        //verification
        String actualTitle = driver.getTitle();
        String exceptedTitle = "Dashboard";

        Assert.assertTrue(actualTitle.contains(exceptedTitle));
    }

    @Test
    public void positiveLoginTest_3() {
        /**
         * navigate to kraft login page
         * login with valid credentials
         * verify that the user's name is seen on dashboard page
         *
         * note: do login process with login(userEmail,password) method
         */

        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("userEmail"), ConfigurationReader.get("password"));

        DashboardPage dashboardPage = new DashboardPage();
        String actualUserName = dashboardPage.userName.getText();
        String expectedUserName = ConfigurationReader.get("userName");

        Assert.assertEquals(actualUserName, expectedUserName, "should be same");


    }

    @Test
    public void positiveLoginTest_4() {
        /**
         * navigate to kraft login page
         * login with valid credentials
         * verify that the user's name is seen on dashboard page
         *
         * note: do login process with login() method  //without parameter
         */
        LoginPage loginPage = new LoginPage();
        loginPage.login();


        DashboardPage dashboardPage = new DashboardPage();
        String actualUserName = dashboardPage.userName.getText();
        String expectedUserName = ConfigurationReader.get("userName");

        Assert.assertEquals(actualUserName, expectedUserName, "should be same");


    }
}