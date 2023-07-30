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

public class _Task_DisableElements {
    WebDriver driver;

    /**
     * navigate to http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html
     * locate pumpkin element
     * verify that the element is enabled
     * verify that the element is selected+++++++
     * verify that the element is displayed
     * locate cabbage element
     * verify that the element is NOT enabled
     * verify that the element is NOT selected
     * verify that the element is displayed
     */

        @BeforeMethod
        public void setUp() throws InterruptedException {
            driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().setPosition(new Point(-1000, 0));
            driver.manage().window().maximize();
            Thread.sleep(3000);
            driver.get("http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        }

        @AfterMethod
        public void tearDown(){
            driver.close();
        }
        @Test
        public void disableElements() throws InterruptedException {

            WebElement pumpkinElement = driver.findElement(By.cssSelector("input[value='pumpkin']"));
            Assert.assertTrue(pumpkinElement.isEnabled());
            Thread.sleep(3000);
            Assert.assertTrue(pumpkinElement.isSelected());
            Assert.assertTrue(pumpkinElement.isDisplayed());
            Thread.sleep(3000);
            WebElement cabbageElement= driver.findElement(By.cssSelector("input[value='cabbage']"));
            Assert.assertFalse(cabbageElement.isEnabled());
            Thread.sleep(3000);
            Assert.assertFalse(cabbageElement.isSelected());
            Assert.assertTrue(cabbageElement.isDisplayed());
            Thread.sleep(3000);


        }
}
