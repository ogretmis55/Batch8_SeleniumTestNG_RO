package com.eurotech.tests.day_02_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _3_GetMethods {
    public static void main(String[] args) {
        /**
         * set up a chrome driver
         * navigate to https://www.hepsiburada.com/
         * get title and get url
         * verify that title, url and Page source codes  contain "hepsiburada"
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.get("https://www.hepsiburada.com/");
        String actualTitle= driver.getTitle();

        String actualCurrentUrl= driver.getCurrentUrl();

        String actualPageSource=driver.getPageSource();

        if(actualTitle.toLowerCase().contains("hepsiburada")&& actualCurrentUrl.toLowerCase().contains("hepsiburada")
        && actualPageSource.toLowerCase().contains("hepsiburada")){
            System.out.println("Pass");
        }else{
            System.out.println("Failed");

        }
        System.out.println(actualTitle);
        System.out.println(actualCurrentUrl);
        //System.out.println(actualPageSource);
        driver.close();
    }
}
