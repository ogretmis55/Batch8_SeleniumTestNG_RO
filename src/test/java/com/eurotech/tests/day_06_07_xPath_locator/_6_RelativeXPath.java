package com.eurotech.tests.day_06_07_xPath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * task
 * navigate to https://demoqa.com/automation-practice-form
 * locate first name input box with xPath (parent-child relations)
 * send "Ayşegül" to the input box
 * locate sports checkbox with xPath (parent-child relations)
 * click to the checkbox
 * locate Student Registration Form element by xPath (parent-child relations)
 * get the text of web element and print it
 * close the driver
 */

public class _6_RelativeXPath {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/automation-practice-form");
        Thread.sleep(2000);

        WebElement firstName= driver.findElement(By.xpath("(//h5[contains(.,'Form')]/following-sibling::form//input)[1]"));
        firstName.sendKeys("Ayşegül");
        Thread.sleep(4000);

        WebElement sportsCheckBox = driver.findElement(By.xpath("//label[text()='Name']/ancestor::form//input[@id='hobbies-checkbox-1']/.."));
        sportsCheckBox.click();

        WebElement formName= driver.findElement(By.xpath("//input[@id='lastName']/ancestor::form/preceding-sibling::h5"));
        String formNameText= formName.getText();
        System.out.println("formNameText = " + formNameText);
        Thread.sleep(2000);

        driver.close();
    }
}
