package com.eurotech.tests.day_11_listOfElements_dropDown;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;

public class _3_DropDownWithoutSelectTag {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
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
    public void dropDownWithoutSelectTag() throws InterruptedException {
        /**
         * navigate to https://demoqa.com/select-menu
         * locate and click Select Value dropdown
         * select (click) "Group 1, option 2" from Select Value dropdown
         * locate the new "Group 1, option 2" web element (stale element daha sonra anlatılacak)
         * verify that the element text is "Group 1, option 2"
         */
        driver.get("https://demoqa.com/select-menu");

        WebElement dropDownMenu = driver.findElement(By.xpath("//div[text()='Select Option']"));
        dropDownMenu.click();
        Thread.sleep(2000);

        WebElement group1Option2 = driver.findElement(By.xpath("//div[text()='Group 1, option 2']"));
        group1Option2.click();
        Thread.sleep(2000);
        WebElement group1Option2_1 = driver.findElement(By.xpath("//div[text()='Group 1, option 2']"));
        Thread.sleep(2000);

        String actualText= group1Option2_1.getText();
        String expectedText="Group 1, option 2";

        Assert.assertEquals(actualText,expectedText);

    }
    @Test
    public void dropDownWithoutSelectTag_Task() throws InterruptedException {
        /**
         * navigate to https://demoqa.com/select-menu
         * click Select One dropdown
         * click on 'Mrs.'
         * locate new 'Mrs.' webElement
         * get the selected option text verify that the text is "Mrs."
         *
         * NOT:right click/inspect/eventlisteners/blur  burada bulunan b&uuml;t&uuml;n se&ccedil;enekler silinir.
         */
        driver.get("https://demoqa.com/select-menu");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[text()='Select Title']")).click();


        WebElement MrsSelect = driver.findElement(By.id("react-select-3-option-0-2"));
        MrsSelect.click();
        Thread.sleep(5000);
        WebElement MrsSelect_2= driver.findElement(By.cssSelector("div.css-1uccc91-singleValue"));

        String actualMrs= MrsSelect_2.getText();
        String expectedMrs= "Mrs.";
        Assert.assertEquals(actualMrs,expectedMrs);

    }
    @Test
    public void dropDownWithoutSelectTag_2() throws InterruptedException {
        /**
         * navigate to https://demo.aspnetawesome.com/
         * locate and click DropdownList (Mango ile başlayan liste)
         * get all option names and print them
         * click potato by index (6)
         * relocate dropdown menu (çünkü listenin yapısı değişti)
         * click banana with its own locator (banana'yı locate edip tıklayalım.)
         */
        driver.get("https://demo.aspnetawesome.com/");
        WebElement dropDownList = driver.findElement(By.cssSelector("button#AllMeals-awed.o-ddbtn.o-btn.awe-btn"));
        dropDownList.click();
        Thread.sleep(2000);
        System.out.println("OPTIONS");
        System.out.println("_________");
        List<WebElement> allOptions= driver.findElements(By.cssSelector("li.o-itm.o-v.o-ditm"));
        Thread.sleep(3000);
        for (WebElement allOption : allOptions) {
            System.out.println(allOption.getText());

        }
        //WebElement potatoElement = driver.findElement(By.cssSelector("li.o-itm.o-v.o-ditm"));
        //System.out.println("allOptions.get(6).getText() = " + allOptions.get(6).getText());
        allOptions.get(6).click();
        Thread.sleep(4000);
        dropDownList.click();
        Thread.sleep(4000);
        WebElement bananaElement = driver.findElement(By.cssSelector("(//div[text()='Banana'])[2]"));
        System.out.println("bananaElement.getText() = " + bananaElement.getText());
        bananaElement.click();

    }

    @Test
    public void staleElement() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);

        WebElement header = driver.findElement(By.xpath("//div[text()='Swag Labs']"));
        System.out.println("header.getText() = " + header.getText());
        Thread.sleep(2000);

        driver.navigate().refresh();
        WebElement header1 = driver.findElement(By.xpath("//div[text()='Swag Labs']"));
        Thread.sleep(2000);

        System.out.println("header1.getText() = " + header1.getText());

    }
}

