package com.eurotech.tests.day_08_css_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _1_Css_Id_Class {
    public static void main(String[] args) throws InterruptedException {
         /**
         * navigate to http://www.eurotech.study/
         * click cookies button with css id
         * click Sign Up button css class
         * send "Ahmet" to name box by css id with tag
         * click register button by css class with tag
         * close driver
         *--------------------
         * #id
         * tagName#id
         * -------------------
         * .className
         * tagName.className
         * Note: eğer class name'de boşluk varsa silinip yerine . (nokta) konulur.
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.navigate().to(" http://www.eurotech.study/");
        Thread.sleep(3000);

        WebElement confirmButton= driver.findElement(By.cssSelector("#rcc-confirm-button"));
        confirmButton.click();

        WebElement signUpButton= driver.findElement(By.cssSelector(".btn.btn-primary"));
        signUpButton.click();
        Thread.sleep(2000);

        WebElement nameInput= driver.findElement(By.cssSelector("input#signuppage-form-name-input"));
        nameInput.sendKeys("Ahmet");
        Thread.sleep(2000);

        WebElement registerBtn = driver.findElement(By.cssSelector("input.btn.btn-primary"));
        registerBtn.click();
        Thread.sleep(2000);

        driver.close();

    }
}
