package com.eurotech.tests.day_18_properties_singleton;

import com.eurotech.utilities.Driver;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class _4_SingletonTest {

    @Test
    public void test1() {
        //WebDriver driver = WebDriverFactory.getDriver("chrome");
        WebDriver driver = Driver.get();
        driver.get("https://www.amazon.com.tr");
    }
        @Test
        public void test2 () {
            //WebDriver driver = WebDriverFactory.getDriver("chrome");
            WebDriver driver = Driver.get();
            driver.get("https://www.google.com");
        }
       @Test
       public void test3 () {
        //WebDriver driver = WebDriverFactory.getDriver("chrome")
        WebDriver driver = Driver.get();
        driver.get("https://www.amazon.com.tr");

    }
        @Test
        public void test4() {
            //WebDriver driver = WebDriverFactory.getDriver("chrome");
            WebDriver driver = Driver.get();
            driver.get("https://www.google.com.tr");
           // driver.findElement(By.name("q")).sendKeys("selenium" + Keys.ENTER);
        }
    }
