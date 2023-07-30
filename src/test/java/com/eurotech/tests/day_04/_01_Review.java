package com.eurotech.tests.day_04;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class _01_Review {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.abeyis.com");
        driver.manage().window().maximize();


    }
}
