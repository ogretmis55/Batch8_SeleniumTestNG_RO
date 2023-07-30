package com.eurotech.examples;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _1_example {
    public static void main(String[] args) throws InterruptedException {
        /** Class Task 1
         * open the chrome browser
         * go to  https://www.krafttechexlab.com/login  page
         * click on login button
         * verify that url is not changed
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.navigate().to("https://www.krafttechexlab.com/login");
       // WebElement loginButton= driver.findElement(By.xpath("//*[@id='navbarSupportedContent']/ul/li[6]/a"));
        WebElement loginButton= driver.findElement(By.name("login"));
       // loginButton.submit();
        Thread.sleep(3000);
        loginButton.click();


        String actualUrl= driver.getCurrentUrl();
        String expectedUrl="https://www.krafttechexlab.com/login";
        Thread.sleep(3000);

        if(actualUrl.equals(expectedUrl)){
            System.out.println("Pass");
        }else {
            System.out.println("Failed");
        }
        driver.close();
    }
}
