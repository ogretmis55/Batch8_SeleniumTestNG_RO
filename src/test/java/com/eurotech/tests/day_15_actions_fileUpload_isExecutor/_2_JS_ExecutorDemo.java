package com.eurotech.tests.day_15_actions_fileUpload_isExecutor;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _2_JS_ExecutorDemo {

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
        driver.quit();
    }

    @Test
    public void clickWithJS() throws InterruptedException {
        /**
         * navigate to https://www.amazon.com.tr/
         * accept cookies if any
         * click Almanya link with js executor
         * accept cookies if any
         * verify that the url contains amazon.de
         *
         * note : ask google how to click with js executor
         */

        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.id("sp-cc-accept")).click();

        WebElement almanya = driver.findElement(By.linkText("Almanya"));

        JavascriptExecutor jse=(JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click();", almanya);
        Thread.sleep(2000);
        driver.findElement(By.id("sp-cc-accept")).click();
        String currentUrl= driver.getCurrentUrl();

        //Assert.assertEquals(currentUrl.contains("amazon.de"));
    }

    @Test
    public void typeWithJS() {
        /**
         * go to https://the-internet.herokuapp.com/dynamic_controls
         * send "Hello World!" to the disabled box with js executor
         *
         * note : ask google--> how to sendKeys using JSExecutor
         */

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement textBox = driver.findElement(By.cssSelector("#input-example>input"));
        String text= "Hello World";

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='"+text+"';", textBox);
    }

    @Test
    public void scrollDownAndUp() {
        /**
         * go to https://www.amazon.com.tr/"
         *  accept cookies if any
         * make scroll down and up
         */
        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.id("sp-cc-accept")).click();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,4000)");


    }

    @Test
    public void scrollToElement() throws InterruptedException {
        /**
         * navigate to https://www.amazon.com.tr/
         * accept cookies if any
         * scroll to the Almanya and click it
         */
        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.id("sp-cc-accept")).click();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement almanya = driver.findElement(By.linkText("Almanya"));
        jse.executeScript("arguments[0].scrollIntoView(true);",almanya);
        jse.executeScript("arguments[0].scrollIntoView(true);"+ "arguments[0].click(); ",almanya);

        Thread.sleep(2000);


    }

    @Test
    public void jsExecutor_Task() {
        /**
         * navigate to https://www.krafttechexlab.com/forms/elements
         * scroll 1000 px down
         * change the Range position (actions ile)
         * change the Disabled Range position
         * scroll to the Number label
         * change the color from blue to red
         * select the Disabled Radio 3 button
         * scroll to the submit button
         * scroll again to the number label
         * scroll to the submit button and click on it
         * take the new page title and url
         * verify that the page title contains "Kraft"
         *
         * not: all steps should be done with js executor except step 3 and last one.
         */
    }
}
