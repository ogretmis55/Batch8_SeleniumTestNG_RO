package com.eurotech.tests.day_06_07_xPath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _4_RelativeXpath {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome browser and go to http://www.eurotech.study/
         * click I understand button and accept cookies (use xPath with attribute feature)
         * locate Developers link (use xPath with text feature)
         * click the Developers link
         * locate Filter By element (use xPath with text feature)
         * get the text of element and print it
         * close browser.
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.navigate().to("http://www.eurotech.study/");

        WebElement confirmButton= driver.findElement(By.xpath("//button[@id='rcc-confirm-button']"));
        confirmButton.click();
        Thread.sleep(2000);

        WebElement developersLink= driver.findElement(By.xpath("//a[@href='/profiles']"));
        developersLink.click();
        Thread.sleep(2000);

        WebElement filterBy= driver.findElement(By.xpath("//h2[contains(text(),'Filter')]"));
        System.out.println("filterBy = " + filterBy.getText());

        driver.close();


    }
}
