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

public class _2_RadioButtons {
    WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void radioButtonTest() throws InterruptedException {
        /**
         * navigate to http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html
         * locate yellow element
         * verify that the element is NOT selected
         * click the element
         * verify that the element is selected
         *
         * locate blue element
         * verify that the element is displayed
         * click the element
         * verify that the blue element is selected
         * verify that the yellow element is NOT selected
         */
        driver.get("http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

        WebElement yellow = driver.findElement(By.cssSelector("[value=\"yellow\"]"));
        Assert.assertFalse(yellow.isSelected());
        yellow.click();
        Thread.sleep(2000);
        Assert.assertTrue(yellow.isSelected());

        WebElement blue = driver.findElement(By.cssSelector("[value='blue']"));
        Assert.assertFalse(blue.isSelected());
        blue.click();
        Thread.sleep(2000);
        Assert.assertTrue(blue.isSelected());
        Assert.assertFalse(yellow.isSelected());
        Thread.sleep(2000);


    }


}
