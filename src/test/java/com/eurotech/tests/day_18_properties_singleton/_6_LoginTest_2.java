package com.eurotech.tests.day_18_properties_singleton;

import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _6_LoginTest_2 extends TestBase {

    /**
     * go to kraft login page
     * login with your credentials
     * validate that you are on the dashboard with url
     * https://www.krafttechexlab.com/index
     */
    @Test
    public void loginTest_1(){
        driver.findElement(By.id("email")).sendKeys(ConfigurationReader.get("userEmail"));
        driver.findElement(By.id("yourPassword")).sendKeys(ConfigurationReader.get("password"));
        driver.findElement(By.xpath("//*[text()='Login']")).click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.krafttechexlab.com/index";

        Assert.assertEquals(actualUrl,expectedUrl);

    }
    /**
     * go to kraft login page
     * login with your credentials
     * validate that you are on the dashboard with pageTitle
     * "Dashboard - Kraft Techex Lab - aFm"
     */
    @Test
    public void loginTest_2(){
        WebElement emailBox = driver.findElement(By.id("email"));
        emailBox.sendKeys(ConfigurationReader.get("userEmail"));
        WebElement passwordBox = driver.findElement(By.id("yourPassword"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//*[text()='Login']"));
        loginBtn.click();

        String actualTitle= driver.getTitle();
        String expectedTitle="Dashboard - Kraft Techex Lab - aFm";

        Assert.assertEquals(actualTitle,expectedTitle);

    }
    /**
     * go to kraft login page
     * login with your credentials
     * validate that you are on the dashboard with userName
     * "Ramazan"
     */
    @Test
    public void loginTest_3(){
        WebElement emailBox = driver.findElement(By.id("email"));
        emailBox.sendKeys(ConfigurationReader.get("userEmail"));
        WebElement passwordBox = driver.findElement(By.id("yourPassword"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//*[text()='Login']"));
        loginBtn.click();

        WebElement userName = driver.findElement(By.xpath("//h2[text()='Ramazan']"));
        String actualUserName= userName.getText();
        System.out.println("actualUserName = " + actualUserName);
        String expectedUserName = "Ramazan";

        Assert.assertEquals(actualUserName,expectedUserName);

    }

}
