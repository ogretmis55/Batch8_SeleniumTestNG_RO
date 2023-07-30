package com.eurotech.tests.day_13_MultipleWindowsAndFrame;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _02_frameAndIframe {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void testIframe() throws InterruptedException {
        driver.get("https://demoqa.com/frames");
        Thread.sleep(3000);
        driver.switchTo().frame("frame1");
        String sampleHeading = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals(sampleHeading, "This is a sample page");

    }

    @Test
    public void testIframe3() throws InterruptedException {
        driver.get("https://demoqa.com/frames");
        Thread.sleep(3000);

        driver.switchTo().frame(0);
        String sampleHeading = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals(sampleHeading, "This is a sample page");


    }

}