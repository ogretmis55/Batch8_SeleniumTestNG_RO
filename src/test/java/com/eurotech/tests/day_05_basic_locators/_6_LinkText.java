package com.eurotech.tests.day_05_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _6_LinkText {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.navigate().to("http://www.eurotech.study/");
        Thread.sleep(2000);

        WebElement confirmButton= driver.findElement(By.id("rcc-confirm-button"));
        confirmButton.click();

        WebElement developerLink= driver.findElement(By.linkText("Developers"));
        String developerLinkText = developerLink.getText();

        System.out.println("developerLinkText = " + developerLinkText);
        Thread.sleep(2000);
        developerLink.click();

        Thread.sleep(2000);

        driver.close();
    }
}
