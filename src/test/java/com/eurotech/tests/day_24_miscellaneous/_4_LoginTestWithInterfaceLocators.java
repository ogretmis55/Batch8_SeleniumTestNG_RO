package com.eurotech.tests.day_24_miscellaneous;

import com.eurotech.pages.LoginPageLocators;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.annotations.Test;

import static com.eurotech.pages.LoginPageLocators.*;

public class _4_LoginTestWithInterfaceLocators extends TestBase implements LoginPageLocators {

    @Test
    public void test1(){
        /**
         * navigate to kraft login page
         * Prepare an interface and put emailBox, passwordBox and Login button locators there
         * call these locators and send keys to them and have login to the site
         */

        driver.findElement(emailBox_loc).sendKeys(ConfigurationReader.get("userEmail"));
        driver.findElement(passwordBox_loc).sendKeys(ConfigurationReader.get("password"));
        driver.findElement(loginBtn_loc).sendKeys();

        }
        @Test
        public void test2(){
        login();

    }

}
