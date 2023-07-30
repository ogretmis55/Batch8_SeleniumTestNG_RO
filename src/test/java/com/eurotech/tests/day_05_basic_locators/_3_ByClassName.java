package com.eurotech.tests.day_05_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _3_ByClassName {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome browser and navigate to http://www.eurotech.study/
         * accept cookies if any
         * locate main paragraph web element by using class name locator
         * get the text of web element and print it
         * close driver.
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.navigate().to("http://www.eurotech.study/");
        Thread.sleep(2000);

        WebElement confirmButton= driver.findElement(By.id("rcc-confirm-button"));
        confirmButton.click();

        //class name ile locate etme
        WebElement mainParagraphElement=  driver.findElement(By.className("lead"));
        String mainParagraphElementText= mainParagraphElement.getText();
        System.out.println("mainParagraphElementText = " + mainParagraphElementText);
        Thread.sleep(2000);

        driver.close();

    }
}
