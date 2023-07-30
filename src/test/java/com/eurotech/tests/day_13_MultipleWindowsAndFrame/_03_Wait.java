package com.eurotech.tests.day_13_MultipleWindowsAndFrame;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _03_Wait {
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
        driver.close();
    }

    @Test
    public void testWait() throws InterruptedException {
        driver.get("http://www.eurotech.study/login");
        Thread.sleep(2000);
        WebDriverWait wait=new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.alertIsPresent());


    }
}