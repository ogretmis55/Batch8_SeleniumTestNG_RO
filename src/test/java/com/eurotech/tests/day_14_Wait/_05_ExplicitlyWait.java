package com.eurotech.tests.day_14_Wait;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _05_ExplicitlyWait {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void testExplicitlyWait(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement enable= driver.findElement(By.xpath("(//button[@autocomplete='off'])[2]"));
        enable.click();

        WebElement enableInput= driver.findElement(By.xpath("//input[@type='text']"));
        WebDriverWait wait= new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(enableInput));
        enableInput.sendKeys("Hello");

    }

    @Test
    public void testExplicitlyWait2() {
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        driver.findElement(By.id("display-other-button")).click();

        WebElement hiddenBtn= driver.findElement(By.id("hidden"));
        WebDriverWait wait= new WebDriverWait(driver,12);
        wait.until(ExpectedConditions.visibilityOf(hiddenBtn));

        Assert.assertTrue(hiddenBtn.isEnabled());

    }
}
