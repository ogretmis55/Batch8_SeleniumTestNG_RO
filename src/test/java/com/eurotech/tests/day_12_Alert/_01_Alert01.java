package com.eurotech.tests.day_12_Alert;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _01_Alert01 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
    @Test
    public void testAlert() throws InterruptedException {


        WebElement alert1=driver.findElement(By.id("alertButton"));
        alert1.click();

        /*WebDriverWait wait=new WebDriverWait(driver,2);
        wait.until(ExpectedConditions.alertIsPresent());*/

        driver.switchTo().alert().accept();
        Thread.sleep(2000);


    }

    @Test
    public void testTimerAlert() throws InterruptedException {
        WebElement alertTime=driver.findElement(By.id("timerAlertButton"));
        alertTime.click();
        Thread.sleep(5000);

        driver.switchTo().alert().accept();
        Assert.assertTrue(alertTime.isDisplayed());
        Thread.sleep(5000);

        String actualText = driver.switchTo().alert().getText();

        String expectedText= "This alert appeared after 5 seconds";

        Assert.assertEquals(actualText,expectedText,"Actual result is not as expected!!!");

    }

    @Test
    public void testAlertDismissAndAccept() throws InterruptedException {

        WebElement alert2=driver.findElement(By.id("confirmButton"));
        alert2.click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();

        WebElement alertResult= driver.findElement(By.id("confirmResult"));

        Assert.assertTrue(alertResult.getText().contains("Cancel"));


    }

    @Test
    public void testAlertSendKey() throws InterruptedException {
        WebElement alert3= driver.findElement(By.id("promtButton"));
        alert3.click();
        Thread.sleep(3000);

        driver.switchTo().alert().sendKeys("Ramazan");

        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        WebElement alertName= driver.findElement(By.id("promptResult"));
        Thread.sleep(2000);
        Assert.assertTrue(alertName.getText().contains("Ramazan"));
    }
}