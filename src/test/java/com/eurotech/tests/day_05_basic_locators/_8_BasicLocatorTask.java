package com.eurotech.tests.day_05_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _8_BasicLocatorTask {
    public static void main(String[] args) throws InterruptedException {

        /** Class Task
         * go to the url - "https://www.browserstack.com/users/sign_up"
         * maximize the window
         * accept cookies if any ,
         * fill in the blanks with the faker class
         * click "Term of service" checkbox
         * and close the window
         *
         * hint: u can use any locator you want
         *
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.navigate().to("https://www.browserstack.com/users/sign_up");
        Thread.sleep(2000);
        WebElement confirmBtn= driver.findElement(By.id("accept-cookie-notification"));
        confirmBtn.click();

        Faker faker=new Faker();

        WebElement userFullName= driver.findElement(By.id("user_full_name"));
        String fullName= faker.name().fullName();
        userFullName.sendKeys(fullName);
        Thread.sleep(2000);

        WebElement userEmail= driver.findElement(By.name("user[email]"));
        String email= faker.internet().emailAddress();
        userEmail.sendKeys(email);
        Thread.sleep(2000);

        WebElement password= driver.findElement(By.id("user_password"));
        String passWord= faker.internet().password();
        password.sendKeys(passWord);
        Thread.sleep(2000);

        WebElement termsBtn= driver.findElement(By.id("tnc_checkbox"));
        termsBtn.click();

        System.out.println("fullName+email = " + fullName + email);

        driver.close();




    }
}
