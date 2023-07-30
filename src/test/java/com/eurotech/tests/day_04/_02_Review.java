package com.eurotech.tests.day_04;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _02_Review {
    public static void main(String[] args) throws InterruptedException {


        /**
         * Task
         * open chrome browser
         * go to http://www.eurotech.study/
         * click I understand button and accept cookies
         * register and login (send mail and password)
         * Verify title
         * Verify page
         * Verify back and forward

         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();
        driver.get(" http://www.eurotech.study/");


       Thread.sleep(3000);

        driver.findElement(By.id("rcc-confirm-button")).click();

       // landingpage-innercontainer-buttons

       WebElement loginButton= driver.findElement(By.xpath("//a[@class='btn btn-light']"));
       loginButton.click();

       String email= "ogretmis@gmail.com";
       WebElement emailLabel= driver.findElement(By.id("loginpage-input-email"));
       emailLabel.sendKeys(email);

       String password= "974055";
       WebElement passwordElement= driver.findElement(By.id("loginpage-form-pw-input"));
       passwordElement.sendKeys(password);
       Thread.sleep(2000);

       driver.findElement(By.id("loginpage-form-btn"));

       WebElement loginLastButton= driver.findElement(By.id("loginpage-form-btn"));
       loginLastButton.click();
       Thread.sleep(3000);

      String title= driver.getTitle();
        String actualUrl=driver.getCurrentUrl();
        System.out.println("actualUrl = " + actualUrl);
        String expectedUrl= "http://www.eurotech.study/dashboard";
        Thread.sleep(3000);

        System.out.println("title = " + title);
        if(actualUrl.equals(expectedUrl)){
            System.out.println("Pass");
        }else{
            System.out.println("Failed");
        }
        Thread.sleep(3000);

        driver.close();


    }
}