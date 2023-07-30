package com.eurotech.tests.day_05_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _8_BasicLocatorReview {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Task
         * open a chrome browser driver and navigate to https://www.demoblaze.com/
         * locate Sign up link by using id and get text of web element then print the text
         * locate previous and next link at the bottom of the page by using name and get text of web element then print the text
         * locate Samsung Galaxy S6 by using tagname and get text of web element then print the text
         * locate Product Store at the left top of the page by using class name and get text of web element then print the text
         * locate Nokia Lumia 1520 by using link text and get text of web element then print the text
         * locate Nexus 6 by using partial link text and get text of web element then print the text
         * close the driver
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.navigate().to("https://www.demoblaze.com/");
        Thread.sleep(2000);

        WebElement signin2Link = driver.findElement(By.id("signin2"));
        System.out.println("signin2Link.getText() = " + signin2Link.getText());

        WebElement previousAndNext=driver.findElement(By.name("frm"));

        System.out.println("previousAndNext.getText() = " + previousAndNext.getText());

        WebElement samsungGalaxyS6= driver.findElement(By.tagName("h4"));
        System.out.println("samsungGalaxyS6.getText() = " + samsungGalaxyS6.getText());

        WebElement productStore= driver.findElement(By.className("navbar-brand"));
        System.out.println("productStore.getText() = " + productStore.getText());

        WebElement nokiaLumia= driver.findElement(By.linkText("Nokia lumia 1520"));
        System.out.println("nokiaLumia.getText() = " + nokiaLumia.getText());

        WebElement nexus= driver.findElement(By.partialLinkText("Nexus"));
        System.out.println("nexus.getText() = " + nexus.getText());
        Thread.sleep(2000);

        driver.close();


    }
}
