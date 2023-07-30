package com.eurotech.tests.day_01_automation_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_OpenBrowser {
    public static void main(String[] args) {

        //make selenium ready to talk with Chrome
        WebDriverManager.chromedriver().setup();

        // create a driver object
        //driver--> REPRESENT an empty browser

        WebDriver driver =new ChromeDriver();

        //navigate to eurotechstudy web page
        driver.get("https://www.amazon.com");

        //how to get page title
        String actualTitle = driver.getTitle();

        String expectedTitle= "Amazon.com. Spend less. Smile more.";

        //check if the actual and expected values are match or not

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Pass");
        }else
            System.out.println("Failed");
    }

}
