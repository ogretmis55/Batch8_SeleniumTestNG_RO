package com.eurotech.tests.day_05_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _2_ByName {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome browser and navigate to https://testpages.herokuapp.com/styled/basic-html-form-test.html
         * locate username input box by using name locator
         * send a random name to the box
         * clear the box
         * send another name to the box
         * get the second name which sent to the box and assign it to a string variable
         * print the second name
         * close driver.
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        Thread.sleep(2000);
        WebElement userNameBox= driver.findElement(By.name("username"));
        userNameBox.sendKeys("Mark Ruffalo");
        Thread.sleep(2000);

        userNameBox.clear();

        userNameBox.sendKeys("Tracy McGraddy");

        String secondName= userNameBox.getAttribute("value");
        Thread.sleep(2000);

        driver.close();


    }
}
