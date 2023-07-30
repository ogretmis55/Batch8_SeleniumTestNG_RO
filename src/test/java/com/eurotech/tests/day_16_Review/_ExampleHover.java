package com.eurotech.tests.day_16_Review;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _ExampleHover {
    /**
     * go to https://the-internet.herokuapp.com/hovers
     * locate all users (image on the page) with findElements()
     * hover over all of them and verify that "name:user1-2-3" is displayed
     * if any time issues solve them with implicitly or explicitly waits
     */
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Actions actions=new Actions(driver);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void testHover() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions actions = new Actions(driver);
        for (int i = 2; i <= 4; i++) {

            String imgXpath = "(//img)[" + i + "]";
            //üzerinde hover yapılan elementlere img dersek
            WebElement img = driver.findElement(By.xpath(imgXpath));

            actions.moveToElement(img).perform();

            String textXpath = "//h5[text()='name: user" + (i - 1) + "']";
            //üzerinde hover yapılınca altta çıkan yazılara text dersek
            WebElement text = driver.findElement(By.xpath(textXpath));

            Assert.assertTrue(text.isDisplayed());
        }

    }
}