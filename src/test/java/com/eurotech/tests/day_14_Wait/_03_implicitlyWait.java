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

import java.util.concurrent.TimeUnit;

public class _03_implicitlyWait {

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
    public void testImplicitly() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement remove= driver.findElement(By.xpath("(//button[@autocomplete='off'])[1]"));
        remove.click();
        WebElement textBox= driver.findElement(By.id("message"));
        System.out.println("textBox.getText() = " + textBox.getText());
        Assert.assertTrue(textBox.isEnabled());
    }

    @Test
    public void testImplicitlyWait2() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement remove= driver.findElement(By.xpath("(//button[@autocomplete='off'])[2]"));
        remove.click();

        WebElement enableInput= driver.findElement(By.xpath("//input[@type='text']"));
        enableInput.sendKeys("Hello");

    }
}