package com.eurotech.tests.day_14_Wait;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _02_waitGeneral {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();

    }

    @Test
    public void testWait() {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement checkBox= driver.findElement(By.id("checkbox"));

        Assert.assertTrue(checkBox.isEnabled());

       /* WebElement textBox= driver.findElement(By.id("message"));
        Assert.assertFalse(textBox.isEnabled());*/



    }
}
