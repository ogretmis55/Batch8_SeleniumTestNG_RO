package com.eurotech.tests.day_06_07_xPath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.*;

public class _2_RelativeXpath {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome
         * navigate to https://www.amazon.com.tr/
         * accept cookies if any (use xPath formula with known attribute value)
         * locate search bar with xPath formula with known attribute value
         * send "Selenium" word to the serach bar
         * locate seacrh button with xPath formula with known attribute value
         * click search button
         * Get the search result by the formula of the text feature of Xpath (two ways)
         * get the text of web element and print it.
         * close driver.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.navigate().to("https://www.amazon.com.tr/");
        Thread.sleep(4000);


        WebElement confirmButton= driver.findElement(By.xpath("//input[@name='accept']"));
        confirmButton.click();
        Thread.sleep(2000);

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Selenium");
       // searchBox.sendKeys("Selenium"+ Keys.ENTER);
        Thread.sleep(2000);

        WebElement searchButton = driver.findElement(By.xpath("//input[@value='Git']"));
        searchButton.click();
        Thread.sleep(2000);

        //1.Yol
        WebElement resultText = driver.findElement(By.xpath("//span[text()='\"Selenium\"']"));
        System.out.println("resultText = " + resultText.getText());

        //2.Yol
        WebElement resultText2= driver.findElement(By.xpath("//span[.='\"Selenium\"']"));
        System.out.println("resultText2 = " + resultText2.getText());


        driver.close();

    }
}
