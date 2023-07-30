package com.eurotech.tests.day_10_typeOfWebElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _1_CheckBoxes {
WebDriver driver;
    /**
     * Açıklamalar   :
     * isSelected()  ----> bir elementin seçili olup olmadığını verir  :  true/false
     * isDisplayed()  ----> bir elementin görünür olup olmadığını verir  :  true/false
     * isEnabled()  ----> bir element ile etkileşime (click, sendKeys vb.) geçilip geçilemeyeceğini verir  :  true/false
     *                    isEnabled() durumunun tersi disabled ile ifade edilir  ama isDisable() metodu yoktur...
     */

    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();


    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void checkBoxTest() throws InterruptedException {
        /**
         * navigate to http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html
         * locate option 3 element
         * verify that the element is selected
         * click the element
         * verify that the element is NOT selected
         *
         * locate option 2
         * verify that the element is NOT selected
         * click the element
         * verify that the element is selected
         */



        driver.navigate().to("http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        Thread.sleep(2000);


        WebElement option3= driver.findElement(By.cssSelector("[value='option-3']"));
        Assert.assertTrue(option3.isSelected(),"verify that option3 is selected");

        option3.click();
        Assert.assertFalse(option3.isSelected(),"verify that option3 is not selected");


        WebElement option2= driver.findElement(By.xpath("//label[text()='Option 2']/input"));
        Assert.assertFalse(option2.isSelected());
        option2.click();
        Assert.assertTrue(option2.isSelected());



    }


}
