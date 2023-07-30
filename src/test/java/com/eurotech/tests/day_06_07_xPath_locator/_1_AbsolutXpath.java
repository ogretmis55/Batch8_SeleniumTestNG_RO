package com.eurotech.tests.day_06_07_xPath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _1_AbsolutXpath {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open a chrome browser and navigate to "https://demoqa.com/automation-practice-form"
         * locate current address input area with absolute xPath
         * send "Manheim/Kolonya" to the address box area
         * then take the value of address box area
         * verify that both addresses are same
         * close driver
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/automation-practice-form");
        Thread.sleep(2000);

       WebElement addressInputBox=  driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[9]/div[2]/textarea"));

       addressInputBox.sendKeys("Manheim/Kolonya");
       Thread.sleep(2000);

        String actualAddress = addressInputBox.getAttribute("value");
        String expectedAddress= "Manheim/Kolonya";

        if(actualAddress.equals(expectedAddress)){
            System.out.println("Pass");
        }else{
            System.out.println("Failed");
        }

        Thread.sleep(2000);
        driver.close();


    }
}
