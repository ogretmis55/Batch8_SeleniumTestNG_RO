package com.eurotech.tests.day_15_actions_fileUpload_isExecutor;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class _3_FileUpload {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Actions actions=new Actions(driver);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void fileUpload() {
        /**
         * go to https://demoqa.com/upload-download
         * upload ccc.txt (which is on your desktop)
         * verify that the file is uploaded
         */
        driver.get("https://demoqa.com/upload-download");
        WebElement uploadElement = driver.findElement(By.cssSelector("#uploadFile"));
        uploadElement.sendKeys("C:\\Users\\Fujitsu\\Desktop\\ccc.txt");

        WebElement uploadedFilePath = driver.findElement(By.id("uploadedFilePath"));
        String loadedFileText= uploadedFilePath.getText();
        String fileName= "ccc.txt";
        Assert.assertTrue(loadedFileText.contains(fileName));

    }
    @Test
    public void systemPropertiesTest(){
        Properties properties = System.getProperties();
        //bütün sistem özellikleri
        //  properties.list(System.out);

        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
    }

    @Test
    public void fileUpload2(){
        /**
         * proje kapsamında dosya yükleme işlemi
         * test klasörü altında resources directory'si oluşturulur (projeye dışarıdan eklenecek dosyalar burada olur.)
         * upload edilecek dosya bu klasöre kopyalanır (ccc.txt)
         * System.getProperty() metodu kullanılarak.. projenin yolu (path) alınır..
         * upload edilecek dosyaya sağ click yapılarak, projeden sonraki yolu (path) alınır..
         * iki path araya "/"  slash konularak birleştirilir. Artık projeyi her indirenin kullanabileceği path oluşur..
         * bu path kullanılarak dosya upload edilir.
         */

        driver.get("https://demoqa.com/upload-download");

        WebElement uploadElement = driver.findElement(By.cssSelector("#uploadFile"));

        String projectPath=System.getProperty("user.dir");
        String filePath="src/test/resources/ccc.txt";

        String fullPath=projectPath+"/"+filePath;

        uploadElement.sendKeys(fullPath);

        WebElement uploadedFilePath = driver.findElement(By.id("uploadedFilePath"));
        String loadedFileText = uploadedFilePath.getText();
        String fileName="ccc.txt";

        Assert.assertTrue(loadedFileText.contains(fileName));
    }

    @Test
    public void fileUpload_Task(){
        /**
         * resources klasöründe fileUploadDemo.txt dosyası oluştur.
         * https://the-internet.herokuapp.com/upload sitesine git
         * sitedeki dosya yükleme kısmına bu dosyayı yükle (dynamic path ile)
         * Upload butonuna bas
         * çıkan sayfadan yüklenen dosyanın ismini doğrula
         */
    }
}


