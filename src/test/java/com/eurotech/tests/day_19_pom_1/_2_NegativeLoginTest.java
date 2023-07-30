package com.eurotech.tests.day_19_pom_1;

import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _2_NegativeLoginTest extends TestBase {

    @Test
    public void wrongPasswordTest() {
        /**
         * navigate to https://www.krafttechexlab.com/login
         * type in correct username
         * type in wrong password
         * verify that user cannot login
         * and takes the warning message: "Password is incorrect. Please check"
         */

        LoginPage loginPage=new LoginPage();
        loginPage.emailBox.sendKeys(ConfigurationReader.get("userEmail"));
        loginPage.passwordBox.sendKeys("wrongPassword");
        loginPage.loginBtn.click();

        String actualMessage = loginPage.wrongPasswordWarningMessage.getText();
        String expectedMessage="Password is incorrect. Please check";

        Assert.assertEquals(actualMessage,expectedMessage,"both Message should be same ");

    }
    @Test
    public void wrongUserEmailTest() {
        /**
         * navigate to https://www.krafttechexlab.com/login
         * type in wrong username
         * type in correct password
         * verify that user cannot login
         * and takes the warning message: "Email address is incorrect. Please check"
         */

        LoginPage loginPage=new LoginPage();
        loginPage.emailBox.sendKeys("wrongUserEmail");
        loginPage.passwordBox.sendKeys(ConfigurationReader.get("password"));
        loginPage.loginBtn.click();

        String actualMessage = loginPage.wrongUserEmailWarningMessage.getText();
        String expectedMessage="Email address is incorrect. Please check";

        Assert.assertEquals(actualMessage,expectedMessage,"Both message should be same");

    }
}
