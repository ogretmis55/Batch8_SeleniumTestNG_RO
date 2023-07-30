package com.eurotech.tests.day_05_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _7_ByPartialLinkText {
    public static void main(String[] args) throws InterruptedException {

        /**
         * open chrome browser and navigate to http://www.eurotech.study/
         * accept cookies if any
         * locate Sign Up button web element by using partial link text locator
         * get the text of web element and print it
         * click to the web element
         * close driver.
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.navigate().to("http://www.eurotech.study/");
        Thread.sleep(2000);

        WebElement confirmButton= driver.findElement(By.id("rcc-confirm-button"));
        confirmButton.click();

        WebElement signUpBtn = driver.findElement(By.partialLinkText("Up"));
        String signUpText= signUpBtn.getText();
        System.out.println("signUpText = " + signUpText);
        Thread.sleep(2000);
        System.out.println("signUpBtn.getAttribute(\"href\") = " + signUpBtn.getAttribute("href"));
        signUpBtn.click();
        Thread.sleep(2000);



        driver.close();


    }
}
