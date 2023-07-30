package com.eurotech.tests.day_12_Alert;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class _02_MultipleWindows {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/browser-windows");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void testMultipleWindows() throws InterruptedException {

        String mainHandle= driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);
        Thread.sleep(3000);

        WebElement newTabBtn= driver.findElement(By.id("tabButton"));
        newTabBtn.click();
        Set<String> allWindowsHandle=driver.getWindowHandles();

        for (String handle : allWindowsHandle) {
            if(!handle.equals(mainHandle)){
                driver.switchTo().window(handle);
                Thread.sleep(3000);
                driver.close();
            }
            System.out.println("handle = " + handle);
        }



    }

}