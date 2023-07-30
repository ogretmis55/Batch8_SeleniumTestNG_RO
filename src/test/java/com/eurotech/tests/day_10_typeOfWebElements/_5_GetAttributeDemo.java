package com.eurotech.tests.day_10_typeOfWebElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _5_GetAttributeDemo {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void getAttributeTest() throws InterruptedException {
        /**
         * navigate to https://demoqa.com/text-box
         * locate the form web element
         * use some of GET (getAttribute, getTagName, getLocation, getCssValue) methods with the element
         */

        driver.get("https://demoqa.com/text-box");
        Thread.sleep(2000);

        WebElement form = driver.findElement(By.xpath("//form"));
        System.out.println("form.getAttribute(\"id\") = " + form.getAttribute("id"));
        System.out.println("----------------------------");
        System.out.println("form.getAttribute(\"innerHTML\") = " + form.getAttribute("innerHTML"));
        System.out.println("----------------------------");
        System.out.println("form.getAttribute(\"outerHTML\") = " + form.getAttribute("outerHTML"));
        System.out.println("----------------------------");
        System.out.println("form.getText() = " + form.getText());

        System.out.println("form.getTagName() = " + form.getTagName());
        System.out.println("form.getLocation() = " + form.getLocation());
        System.out.println("form.getCssValue(\"font\") = " + form.getCssValue("font"));

        /**
         * navigate to https://demoqa.com/text-box
         * locate Full Name input box
         * use getAttribute method with the element
         * get type attribute value and print it
         * get autocomplete attribute value and print it
         * get name attribue value and print it (name attribute olmadığı için boş dönecektir. hata vermez..)
         * get innerHTML and print it (altında child veya grandchild element olmadığından boş döner..)
         * get outerHTML (sadece kendi tag bilgilerini döner..)
         * send Ahmet to the box and take the value (eğer bir text box'ına yazı gönderirsek.. bu gönderlen yazıyı
         * getAttribute("value") metodu ile alabiliriz..)
         * NOT: getAttribute metodu ile bir web elementin texti alınamaz.. onun için getText() metodu kullanılır..
         */
    }
        @Test
        public void getAttributeTestTask() throws InterruptedException {


        driver.navigate().to("https://demoqa.com/text-box");

        WebElement userNameBox = driver.findElement(By.id("userName"));
        System.out.println("userNameBox.getAttribute(\"type\") = " + userNameBox.getAttribute("type"));
        System.out.println("userNameBox.getAttribute(\"autocomplete\") = " + userNameBox.getAttribute("autocomplete"));
        //eğer elementte olmayan bir attribute'ün değerini almaya çalışırsak bize boş değer döndürür.
        //eğer elementte olan ama değeri olmayan bir attribute'ün değerini almaya çalışırsak bize true döndürür.
        System.out.println("fullName.getAttribute(\"name\") = " + userNameBox.getAttribute("name"));
        System.out.println("-----------------------------");
        Thread.sleep(2000);

        System.out.println("userNameBox.getAttribute(\"innetHTML\") = " + userNameBox.getAttribute("innetHTML"));
        System.out.println("userNameBox.getAttribute(\"outerHTML\") = " + userNameBox.getAttribute("outerHTML"));
        userNameBox.sendKeys("Ahmet");
        userNameBox.getAttribute("value");
        Thread.sleep(2000);


    }
}