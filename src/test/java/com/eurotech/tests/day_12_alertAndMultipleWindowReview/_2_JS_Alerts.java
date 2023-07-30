package com.eurotech.tests.day_12_alertAndMultipleWindowReview;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _2_JS_Alerts {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void jsAlert_Accept() throws InterruptedException {

        /**
         * navigate to https://the-internet.herokuapp.com/javascript_alerts
         * click on click For Js Alert button
         * create an alert object
         * take text on the alert button and print it
         * click on OK button by using alert object
         * verify that "You successfully clicked an alert" text is seen
         */
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement clickForJSAlert = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        clickForJSAlert.click();

        Thread.sleep(2000);

        Alert alert=driver.switchTo().alert();

        System.out.println(alert.getText());

        alert.accept();

        WebElement result = driver.findElement(By.cssSelector("#result"));
        String actualText = result.getText();
        String expectedText="You successfully clicked an alert";

        Assert.assertEquals(actualText,expectedText);


    }

    @Test
    public void jsAlert_Dismiss() throws InterruptedException {

        /**
         * navigate to https://the-internet.herokuapp.com/javascript_alerts
         * click on click For JS Confirm button
         * create an alert object
         * take text on the alert button and print it
         * click on CANCEL button by using alert object
         * verify that "You clicked: Cancel" text is seen
         */
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(2000);

        WebElement clickForJSConfirm = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        clickForJSConfirm.click();
        Thread.sleep(2000);

        Alert alert=driver.switchTo().alert();

        System.out.println(alert.getText());

        alert.dismiss();

        WebElement result = driver.findElement(By.cssSelector("#result"));
        String actualText = result.getText();
        String expectedText="You clicked: Cancel";

        Assert.assertEquals(actualText,expectedText);

    }

    @Test
    public void jsAlert_SendKeys() throws InterruptedException {
        /**
         * navigate to https://the-internet.herokuapp.com/javascript_alerts
         * click on click  JS Prompt button
         * create an alert object
         * take text on the alert button and print it
         * send "Ahmet Ay" text to the bar which is on the alert
         * click on OK button by using alert object
         * verify that "You entered: Ahmet Ay" text is seen and verify the correction
         */

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(2000);

        WebElement clickForJSPrompt = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        clickForJSPrompt.click();
        Thread.sleep(2000);

        Alert alert=driver.switchTo().alert();

        System.out.println(alert.getText());

        String text="Ahmet Ay";

        alert.sendKeys(text);
        Thread.sleep(2000);

        alert.accept();

        //verification
        WebElement result = driver.findElement(By.cssSelector("#result"));
        String actualText = result.getText();
        String expectedText="You entered: "+text;

        Assert.assertEquals(actualText,expectedText);

    }

    @Test
    public void jsAlert_Task() {
        /**
         * navigate to https://testpages.herokuapp.com/styled/alerts/alert-test.html
         * click alert box
         * then take message on the js popup and print it
         * accept alert
         *
         * click show confirm box
         * then take message on the js popup and print it
         * dismiss alert
         * verify that you clicked cancel button (Alınan mesajın Cancel içerdiğini doğrula)
         *
         * click show prompt box
         * then take message on the js popup and print it
         * send Ahmet to the popup box
         * accept alert
         * verify that Ahmet is sent to the box.
         *
         * NOT: tüm taskı tek test metodunda yapabilirsiniz..
         */
    }
}
