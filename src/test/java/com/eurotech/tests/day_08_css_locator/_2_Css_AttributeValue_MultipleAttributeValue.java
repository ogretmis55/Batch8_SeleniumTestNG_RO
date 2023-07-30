package com.eurotech.tests.day_08_css_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _2_Css_AttributeValue_MultipleAttributeValue {
    public static void main(String[] args) throws InterruptedException {
        /**
         * navigate to http://www.eurotech.study/
         * click cookies button with one css attribute value
         * take DevEx text with css multiple attribute value (and)
         * take main text with css multiple attribute value (or)
         * close driver
         * --------------------
         * [attribute='value']
         * tagName[attribute='value']
         * ----------------------
         * birden çok attribute ile css'de locate etme:
         * [attribute1='value1'][attribute2='value2'] (and)
         * tagName[attribute1='value1'][attribute2='value2'] (and)
         *
         * [attribute1='value1'],[attribute2='value2'] (or)
         * tagName[attribute1='value1'],[attribute2='value2'] (or)
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        driver.navigate().to(" http://www.eurotech.study/");
        Thread.sleep(3000);

        WebElement confirmButton= driver.findElement(By.cssSelector("[aria-label='Accept cookies']"));
        confirmButton.click();
        Thread.sleep(2000);

        WebElement devEx= driver.findElement(By.cssSelector("[id='landingpage-innercontainer-h1'][class='x-large']"));
        String devExText = devEx.getText();
        System.out.println("devExText = " + devExText);
        Thread.sleep(2000);

        WebElement mainText= driver.findElement(By.cssSelector("[id='landingpage-innercontainer-p'],[class='lead']"));
        String mainTextText = mainText.getText();
        System.out.println("mainTextText = " + mainTextText);
        Thread.sleep(2000);

        driver.close();
    }
}
