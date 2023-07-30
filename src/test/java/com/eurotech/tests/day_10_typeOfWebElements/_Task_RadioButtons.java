package com.eurotech.tests.day_10_typeOfWebElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class _Task_RadioButtons {


        /**
         * https://demoqa.com/automation-practice-form
         * locate female gender element
         * verify that the element is NOT selected
         * verify that the element is displayed
         * click the element
         * verify that the element is selected
         * ipucu: eğer elementten istediğiniz sonucu alamıyorsanız.. aynı yeri gösteren diğer elementleri deneyin....!!!!
         */

        WebDriver driver;
        @BeforeMethod
        public void setUp() throws InterruptedException {
            driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().setPosition(new Point(-1000, 0));
            driver.manage().window().maximize();
            Thread.sleep(3000);
        }

        @AfterMethod
        public void tearDown(){
            driver.close();
        }

        @Test
        public void buttonTest() throws InterruptedException {
            driver.get("https://demoqa.com/automation-practice-form");
            Thread.sleep(3000);
            WebElement femaleGenderElement = driver.findElement(By.cssSelector("label[class='custom-control-label'][for='gender-radio-2']"));
            Assert.assertFalse(femaleGenderElement.isSelected());
            Assert.assertTrue(femaleGenderElement.isDisplayed());
            Thread.sleep(2000);
            femaleGenderElement.click();
            Thread.sleep(2000);
            WebElement element2 = driver.findElement(By.xpath("//input[@value='Female']"));
            Assert.assertTrue(element2.isSelected());


        }


    }


