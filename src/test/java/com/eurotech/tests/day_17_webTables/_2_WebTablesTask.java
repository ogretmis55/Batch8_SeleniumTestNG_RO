package com.eurotech.tests.day_17_webTables;

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

public class _2_WebTablesTask {
    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://webdriveruniversity.com/Data-Table/index.html");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();


    }
    @Test
    public void WebTableTask_1() {
        /**
         * Task-1
         * navigate to https://webdriveruniversity.com/Data-Table/index.html
         * get the third cell of first row --> 45  and make verification
         * get the second cell of second row --> Jackson and make verification
         */

        WebElement thirdCell = driver.findElement(By.xpath("//table[@id='t01']/tbody/tr[2]/td[3]"));
        String actualText= thirdCell.getText();
        System.out.println("actualText = " + actualText);
        String expectedText="45";

        Assert.assertEquals(actualText,expectedText);

        WebElement secondElement = driver.findElement(By.xpath("//table[@id='t01']/tbody/tr[3]/td[2]"));
        String actualText2= secondElement.getText();
        System.out.println("actualText2 = " + actualText2);
        String expectedText2="Jackson";

        Assert.assertEquals(actualText2,expectedText2);

    }
    @Test
    public void WebTableTask_2() {
        /**
         * Task-2
         * navigate to https://webdriveruniversity.com/Data-Table/index.html
         * get the data of specific cell by using row and column numbers
         * write separate methods for this purpose
         * print whole table data by using this method (except column headers)
         */

    }

}
