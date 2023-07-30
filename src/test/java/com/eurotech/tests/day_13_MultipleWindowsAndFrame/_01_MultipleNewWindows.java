package com.eurotech.tests.day_13_MultipleWindowsAndFrame;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class _01_MultipleNewWindows {
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
    public void testMultipleNewWindow() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        Thread.sleep(2000);
        String parentWindow= driver.getWindowHandle();
        WebElement newWindow = driver.findElement(By.id("windowButton"));
        newWindow.click();

        Set<String> handles= driver.getWindowHandles();
        Thread.sleep(2000);

        for (String handle : handles) {
            if(!handle.equals(parentWindow)){
                driver.switchTo().window(handle);

            }
            System.out.println("handle = " + handle);

        }


    }

    @Test
    public void testMultipleTabsOrWindowsWhichChoose() throws InterruptedException {
        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
        Thread.sleep(5000);
        driver.findElement(By.id("cookieChoiceDismiss")).click();

        driver.getWindowHandle();
        Thread.sleep(4000);
        driver.findElement(By.id("newTabBtn")).click();


        driver.findElement(By.id("newWindowsBtn"));

        Set<String> handles =driver.getWindowHandles();


        for (String handle : handles) {
            driver.switchTo().window(handle);
            System.out.println("Current Windows Title = " + driver.getTitle());
            Thread.sleep(3000);
        }
        String expectedTitle="XPath Practise - H Y R Tutorials";
        String actualTitle= driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

    }
}