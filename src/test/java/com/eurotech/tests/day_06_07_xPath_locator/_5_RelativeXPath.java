package com.eurotech.tests.day_06_07_xPath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _5_RelativeXPath {
    public static void main(String[] args) throws InterruptedException {

        /**
         * class task
         * open chrome browser and go to http://www.eurotech.study/
         * click I understand button and accept cookies (by xPath with contains (attribute))
         * locate sign up by xPath with contains (text)
         * click Sign Up
         * locate Name input box by xPath (starts with) and send to box "Ahmet"
         * locate email input box by xPath (more than one attribute) and send the box "aaa@aaa.com"
         * locate password input box by xPath (more than one attribute with "and") and type in "123456"
         * locate confirm password input box by xPath (more than one attribute with "or") and type in "123456"
         * locate Sign In link by xPath (with index) --- use only tag
         * click Sign In link
         * close browser.
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.navigate().to("http://www.eurotech.study/");
        Thread.sleep(2000);

        WebElement confirmButton= driver.findElement(By.xpath("button[@contains(@aria-label='Accept cookies')]"));
        confirmButton.click();
        Thread.sleep(2000);

        WebElement signUpBtn = driver.findElement(By.xpath("//a[contains(text(),'n Up')]"));
        signUpBtn.click();
        Thread.sleep(2000);

        WebElement name= driver.findElement(By.xpath("//input[starts-with(@name,'na')]"));
        name.sendKeys("Ahmet");
        Thread.sleep(2000);
        WebElement emailBox= driver.findElement(By.xpath("input[@type='email'][@placeholder='Email Address']"));
        emailBox.sendKeys("aaa@aaa.com");

        WebElement password= driver.findElement(By.xpath("input[@type='password'][@placeholder='Password']"));
        password.sendKeys("123456");
        Thread.sleep(2000);
        WebElement confirmPassword= driver.findElement(By.xpath("//input[@id='signuppage-form-pw2-input']"));
        confirmPassword.sendKeys("123456");
        Thread.sleep(2000);


    WebElement signIn= driver.findElement(By.xpath("(//a)[5]"));
    signIn.click();

    }
}
