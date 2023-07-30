package com.eurotech.tests.day_11_listOfElements_dropDown;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class _1_listOfElements_FindElements {

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
    public void findElementWithCorrectFormula() throws InterruptedException {
        /**
         * https://demoqa.com/elements adresine git
         * soldaki ana başlıkları tek bir locator ile locate et ve bunları bir liste kaydet
         * listin size'ını al.
         * size'ın 6 olduğunu doğrula.
         * listedeki başlık elementlerinin textlerini yazdır. (For each)
         */
        driver.get("https://demoqa.com/elements");
        Thread.sleep(2000);

        List<WebElement> headers = driver.findElements(By.cssSelector(".header-text"));
        int size = headers.size();
        System.out.println("size = " + size);

        Assert.assertEquals(size, 6, "verify that is 6");

        for (WebElement header : headers) {
            System.out.println("header.getText() = " + header.getText());

        }

        for (WebElement header : headers) {
            Assert.assertTrue(header.isDisplayed());

        }

    }

    @Test
    public void findElementWithIncorrectFormula() throws InterruptedException {
        /**
         * https://demoqa.com/elements adresine git
         * soldaki ana başlıkları tek bir locator ile locate et ve bunları bir liste kaydet
         * listin size'ını al.
         * size'ın 6 olduğunu doğrula.
         * listedeki başlık elementlerinin textlerini yazdır. (For each)
         */
        driver.get("https://demoqa.com/elements");
        Thread.sleep(2000);

        List<WebElement> headers = driver.findElements(By.cssSelector(".header-text"));

    }

        @Test
        public void findElements() throws InterruptedException {

            /**
             * navigate to https://www.saucedemo.com/
             * locate login form elements with one locator (username box, password box and login button)
             * send "standard_user" to username box
             * send "secret_sauce" to password box
             * click Login button
             * then take all product names to a web element list and print the text of elements
             * verify that first web element text is "Sauce Labs Backpack"
             */

            driver.get("https://www.saucedemo.com");
            Thread.sleep(2000);

            List<WebElement> inputs = driver.findElements(By.xpath("//input"));
            inputs.get(0).sendKeys("standard_user");
            inputs.get(1).sendKeys("secret_sauce");
            inputs.get(2).click();

            List<WebElement> itemsName=driver.findElements(By.cssSelector(".inventory_item_name"));

            for (WebElement itemName: itemsName) {
                System.out.println("itemName.getText() = " + itemName.getText());

            }
            String actualFirstItemName=itemsName.get(0).getText();
            String expectedFirst="Sauce Labs Backpack";

            Assert.assertEquals(actualFirstItemName,expectedFirst);

        }

        @Test
        public void findElements_Task() throws InterruptedException {
            /**
             * navigate to http://www.eurotech.study/
             * accept cookies
             * click login
             * locate emailBox, passBox and Login Button with one locator and put them in a list which named as inputs
             * verify that the size of list is 3
             * verify that the value of 3rd element is Login
             * send your credentials to related boxes and then click login button
             * verify success login with "Welcome ......." text
             * locate Experience Credentials and Education Credentials with findElements()
             * then get both element texts and print them
             */

            driver.get("http://www.eurotech.study/");
            WebElement confirmBtn = driver.findElement(By.id("rcc-confirm-button"));
            confirmBtn.click();
            Thread.sleep(3000);
            WebElement loginBtn = driver.findElement(By.cssSelector("a.btn.btn-light"));
            loginBtn.click();

            Thread.sleep(2000);
            List<WebElement> inputs= driver.findElements(By.xpath("//input"));

            int size= inputs.size();
            Thread.sleep(2000);
            System.out.println("size = " + size);
            Assert.assertEquals(size,3, "verify that the size of list is 3" );

            for (WebElement input : inputs) {
                System.out.println("input.getText() = " + input.getText());
                Thread.sleep(2000);

                String actualThirdInputName=input.getCssValue("Login");
                String expectedFirst="Login";

                Assert.assertEquals(actualThirdInputName,expectedFirst);



            }

        }
}
/**
 * Açıklamalar....
 * findElements() --> bize WebElement'leri bir liste olarak döner.. (1 of 3 ise listede 3 element bulunur..)
 * List<WebElement> inputs = driver.findElements(By.xpath("xPathFormülü"));  // diğer yöntemler de kullanılabilir..
 * elements.get(0).click() --> listenin ilk elementine click yapar
 * elements.get(1).getText() --> listenin ikinci elementinin textini alır.
 * elements.get(2).isDisplayed() --> listenin üçüncü elementinin sayfada görünüp/görünmediğini doğrular..
 * ...
 * findElement() ve findElements() arasındaki farklar..
 * a.  findElement() --> WebElement döner, eğer elementi locate edemezse noSuchElementException fırlatır.
 * b.  findElements() --> WebElement listesi döner. eğer elementleri locate edemezse boş bir liste döner
 * bu nedenle hiçbir zaman noSuchElementException hatası fırlatmaz... bulursa dolu, bulamazsa boş liste verir.
 */