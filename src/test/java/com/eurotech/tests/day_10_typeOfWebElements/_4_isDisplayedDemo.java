package com.eurotech.tests.day_10_typeOfWebElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _4_isDisplayedDemo {


    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
    @Test
    public void displayed_Test() throws InterruptedException {
        /**
         * navigate to https://the-internet.herokuapp.com/dynamic_loading
         * click the second link (Example 1: Element on page that is hidden)
         * locate start button and "Hello World!" text element
         * verify that Hello World! is NOT displayed
         * click start button
         * wait 5 seconds
         * verify that Hello World! is now displayed
         * take the text of element and print it
         */

        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        Thread.sleep(3000);
        driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
        WebElement hello = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        Assert.assertFalse(hello.isDisplayed());

        WebElement startBtn=driver.findElement(By.xpath("//button[text()='Start']"));
        startBtn.click();
        Thread.sleep(5000);

        Assert.assertTrue(hello.isDisplayed());

        Thread.sleep(3000);

    }
    @Test
    public void displayedTest_Task() throws InterruptedException {
        /**  Task
         * navigate to https://the-internet.herokuapp.com/dynamic_loading
         * click the second link (Example 2: Element rendered after the fact)
         * click start button
         * verify that hello element is displayed (bu elementin locate işlemi starta clickten sonra yapılmalı)
         * get the element text and print it
         */

        driver.get("https://the-internet.herokuapp.com/dynamic_loading");

        WebElement secondElement = driver.findElement(By.linkText("Example 2: Element rendered after the fact"));
        Thread.sleep(2000);
        secondElement.click();
        WebElement startBtn= driver.findElement(By.xpath("//button[text()='Start']"));
        startBtn.click();
        Thread.sleep(5000);

        WebElement helloText = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        String actualText= helloText.getText();
        System.out.println("actualText = " + actualText);
        String expectedText= "Hello World!";

        Assert.assertEquals(actualText,expectedText);
        Thread.sleep(3000);

    }

}
/**
 * Açıklama  :
 * Eğer bir element web sayfasında bir şarta bağlı olarak görünüyorsa bu durumda:
 *      a. element o şart gerçekleşmeden önce HTML kodunda (DOM) var ise elementi locate ederken sorun yaşamayız... (Hidden element -gizli element)
 *      b. element o şart gerçekleştikten sonra HTML koduna (DOM) yükleniyor ise elementi şart yerine gelmeden locate edemeyiz..
 * eğer locate etmeye kalkarsak "No Such Element" hatası alırız... şart gerçekleştikten sonra locate etmeliyiz..
 */