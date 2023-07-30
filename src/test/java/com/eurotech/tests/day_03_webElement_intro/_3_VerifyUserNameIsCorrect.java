package com.eurotech.tests.day_03_webElement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _3_VerifyUserNameIsCorrect {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Task
         * open chrome browser
         * go to "https://demoqa.com/login"
         * enter "test" into the username box
         * VERIFY that "test" is displayed in the username box
         * enter "Test.!123" into the password box
         * click on login button
         * VERIFY that username is "test"
         */


        WebDriver driver= WebDriverFactory.getDriver("firefox");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/login");
        String username="test";

        Thread.sleep(2000);

        WebElement userNameInputBox=driver.findElement(By.id("userName"));
        userNameInputBox.sendKeys(username);
        Thread.sleep(2000);

        String actualUserName= userNameInputBox.getAttribute("value");
        if(actualUserName.equals(username)){
            System.out.println("Pass");
        }else{
            System.out.println("Failed");
        }
        WebElement passwordInputBox= driver.findElement(By.id("password"));
        passwordInputBox.sendKeys("Test.!123");


        WebElement loginBtn= driver.findElement(By.id("login"));
        loginBtn.click();
        Thread.sleep(3000);

        WebElement actualLoggedInputUserName= driver.findElement(By.id("userName-value"));
        String actualText=actualLoggedInputUserName.getText();

        if(actualText.equals(username)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }


        driver.close();

    }
}
