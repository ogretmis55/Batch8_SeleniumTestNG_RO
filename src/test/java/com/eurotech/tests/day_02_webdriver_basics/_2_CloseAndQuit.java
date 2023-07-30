package com.eurotech.tests.day_02_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_CloseAndQuit {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.get("http://www.eurotech.study/");

        Thread.sleep(2000);

        //close driver
        driver.close();

        WebDriverManager.chromedriver().setup();
        WebDriver driver1=new ChromeDriver();

        driver1.manage().window().setPosition(new Point(-1000,0));
        driver1.manage().window().maximize();

        driver1.navigate().to("https://www.amazon.com");

        //close all tabs
        driver1.quit();


    }
}
