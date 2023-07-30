package com.eurotech.tests.day_08_css_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _3_Css_Contains_StartsWith_EndsWith_ParentToChild {
    public static void main(String[] args) throws InterruptedException {

            /**
             * class task
             * navigate to http://www.eurotech.study/
             * click cookies button css contains (*)
             * click login button with css starts-with (^)
             * send your email to email box with css ends-with ($)
             * send your password to password box with css parent to child (>)
             * click login btn with css parent to child (space)
             * -----------------------------
             * [attribute*='value'] (contains)
             * tagName[attribute*='value'] (contains)
             *
             * [attribute^='firstPartOfValue'] (starts with)
             * tagName[attribute^='firstPartOfValue'] (starts with)
             *
             * [attribute$='lastPartOfValue'] (ends-with)
             * tagName[attribute$='lastPartOfValue'] (ends-with)
             *
             * xpath '/'  --> parent to child
             * css   '>'  --> parent to child
             * xpath '//' --> parent to grandson
             * css   ' '  --> parent to grandson  (space-boşluk)
             *   */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.navigate().to(" http://www.eurotech.study/");
        Thread.sleep(3000);

        WebElement confirmButton= driver.findElement(By.cssSelector("[aria-label*= ' cookies']"));
        confirmButton.click();

        WebElement loginButton= driver.findElement(By.cssSelector("a[class^='btn btn-l'"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement emailBox= driver.findElement(By.cssSelector("[name$='l']"));
        emailBox.sendKeys("ogretmis@gmail.com");
        Thread.sleep(2000);

        WebElement passwordBox= driver.findElement(By.cssSelector("div>input[name='password']"));
        passwordBox.sendKeys("974055");
        Thread.sleep(2000);

        WebElement loginBtn= driver.findElement(By.cssSelector("section [type='submit']"));
        loginBtn.click();
        Thread.sleep(2000);

        driver.close();




    }
}
