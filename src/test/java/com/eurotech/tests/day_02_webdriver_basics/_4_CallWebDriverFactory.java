package com.eurotech.tests.day_02_webdriver_basics;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class _4_CallWebDriverFactory {
    public static void main(String[] args) {

        /**
         * set up a chrome driver with WebDriverFactory
         * navigate to https://tr-tr.facebook.com/
         * verify that the url is correct
         */
       WebDriver driver=  WebDriverFactory.getDriver("Chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.get("https://tr-tr.facebook.com/");
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://tr-tr.facebook.com/";

        if(actualUrl.equals(expectedUrl)){
            System.out.println("Pass");
        }else{
            System.out.println("Failed");
        }
        driver.quit();

    }
}
