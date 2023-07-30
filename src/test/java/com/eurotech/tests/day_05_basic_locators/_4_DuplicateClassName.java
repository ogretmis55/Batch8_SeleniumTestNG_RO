package com.eurotech.tests.day_05_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _4_DuplicateClassName {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome browser and navigate to https://demoqa.com/text-box
         * locate Full Name label web element by using class name locator
         * get the text of web element and print it
         * close driver.
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/text-box");
        Thread.sleep(2000);

        WebElement fullNameLabel= driver.findElement(By.className("form-label"));

        String fullNameLabelText= fullNameLabel.getText();
        System.out.println("fullNameLabelText = " + fullNameLabelText);
        Thread.sleep(2000);

        driver.close();





    }
}
