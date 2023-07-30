package com.eurotech.tests.day_06_07_xPath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _3_RelativeXpath {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Task
         * open chrome browser
         * go to http://www.eurotech.study/
         * click I understand button and accept cookies (use xPath)
         * locate login button (use xPath)
         * click login button
         * locate email address input box (use xPath)
         * send "abc" into email address input box
         * locate second login button (use xPath)
         * click Login button
         * get the message which appears on the email input box and print the message
         * close browser.
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.navigate().to("http://www.eurotech.study/");
        Thread.sleep(3000);

        WebElement confirmButton= driver.findElement(By.xpath("//button[@id='rcc-confirm-button']"));
        confirmButton.click();
        Thread.sleep(2000);

        WebElement loginBtn= driver.findElement(By.xpath("//a[@class='btn btn-light']"));
        loginBtn.click();
        Thread.sleep(2000);

        WebElement emailBox= driver.findElement(By.xpath("//input[@id='loginpage-input-email']"));
        emailBox.sendKeys( "abc");

        WebElement secondLogin= driver.findElement(By.xpath("//input[@type='submit']"));
        secondLogin.click();
        Thread.sleep(2000);

        System.out.println("emailBox.getAttribute(\"value\") = " + emailBox.getAttribute("value"));
        System.out.println("emailBox.getAttribute(\"validationMessage\") = " + emailBox.getAttribute("validationMessage"));

        driver.close();

    }
}
