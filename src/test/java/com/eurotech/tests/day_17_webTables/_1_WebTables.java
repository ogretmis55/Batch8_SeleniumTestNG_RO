package com.eurotech.tests.day_17_webTables;

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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class

_1_WebTables {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/tables");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void printWholeTable() {
        /**
         * navigate to https://the-internet.herokuapp.com/tables
         * get the whole data from table (including column headers)
         * verify that the table contains fbach@yahoo.com
         * and print all table datas
         */

        WebElement table= driver.findElement(By.xpath("//table[@id='table1']"));
        String wholeTableText= table.getText();
        System.out.println("wholeTable = " + wholeTableText);
        String expectedData= "fbach@yahoo.com";

        Assert.assertTrue(wholeTableText.contains(expectedData));

    }

    @Test
    public void getAllColumnHeaders() {
        /**
         * navigate to https://the-internet.herokuapp.com/tables
         * get the column headers
         * verify that the column headers contains First Name
         * and print all headers' name
         */
        WebElement columnHeaders = driver.findElement(By.xpath("//table[@id='table1']/thead/tr"));
        String columnHeaderNames= columnHeaders.getText();

        String expectedHeader= "First Name";
        Assert.assertTrue(columnHeaderNames.contains(expectedHeader));
        System.out.println("columnHeaderNames = " + columnHeaderNames);
    }

    @Test
    public void getColumnHeadersOneByOne() {
        /**
         * navigate to https://the-internet.herokuapp.com/tables
         * get all web elements of column names  to a list
         * print all column names
         */

        List<WebElement> columnHeaders= driver.findElements(By.xpath("//table[@id='table1']//th"));
        columnHeaders.forEach(header-> System.out.println(header.getText()));
        for (WebElement header: columnHeaders) {
            System.out.println("header.getText() = " + header.getText());

        }

    }

    @Test
    public void getSingleRow() {
        /**
         * navigate to https://the-internet.herokuapp.com/tables
         * get the second row info and print it
         * get all row and print them
         * get all row dynamically and print them
         */

        WebElement secondRowElement = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        System.out.println("secondRowElement = " + secondRowElement.getText());
        List<WebElement> allRowWithoutHeaders = driver.findElements(By.xpath("/table[@id='table1']/tbody/tr"));
        System.out.println("---------------------");
        for (WebElement row: allRowWithoutHeaders) {
            System.out.println("row.getText() = " + row.getText());
        }
        String dynamicallyRowText= dataOfRow(3);
        System.out.println("dynamicallyRowText = " + dynamicallyRowText);

    }
    @Test
    public void getAllCellsInOneRow(){
        /**
         * navigate to https://the-internet.herokuapp.com/tables
         * get the second row info cell by cell and print it
         */
        List<WebElement> secondRowData = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[2]/td"));
        for (WebElement cellData: secondRowData) {
            System.out.println("cellData.getText() = " + cellData.getText());

            System.out.println("due: " + secondRowData.get(3));

        }



    }
    @Test
    public void getSingleCellOfTable(){
        /**
         * navigate to https://the-internet.herokuapp.com/tables
         * get the data of specific cell by using row and column numbers
         */

        int numberOfColumns= getNumberOfColumns();
        int numberOfRows=getNumberOfRows();
        System.out.println("numberOfColumns = " + numberOfColumns);
        System.out.println("numberOfRows = " + numberOfRows);

        System.out.print("dataOfCell(4,2) = " + dataOfCell(4, 2));

        for (int i = 1; i <= numberOfRows ; i++) {
            for (int j = 1; j <=numberOfColumns ; j++) {
                System.out.print(dataOfCell(i, j)+" ");

            }
            System.out.println();

        }
    }

    private int getNumberOfRows() {
        List<WebElement> allRowWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return allRowWithoutHeader.size();
    }

    private int getNumberOfColumns() {
        List<WebElement> allColumnsHeaders = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
        return allColumnsHeaders.size();
    }


    private String dataOfRow(int rowNumber) {
        String xPathOfSingleRow="//table[@id='table1']/tbody/tr["+rowNumber+"]";
        WebElement row= driver.findElement(By.xpath(xPathOfSingleRow));
        return row.getText();
    }
    private String dataOfCell(int row, int column){
        String cellXPath="//table[@id='table1']/tbody//tr["+row+"]/td["+column+"]";
        WebElement cell= driver.findElement(By.xpath(cellXPath));
        return  cell.getText();
    }

}
/**
 * WebTables
 * In html tables are represented with <table> tag -- tablonun tamamını temsil eder
 * Tables are made of <thead> and <tbody> -- tablolar genellikle <thead> ve <tbody> bölümlerinden oluşur.
 * <thead> --> this is the table header, here we have table column names -- sütun başlıklarını tanımlamak içindir.
 * <tr> table row, indicates one whole row  -- tablodaki bütün bir satırı tanımlar.
 * <th> --> this tag indicates a cell that is used for table headers  -- tek bir sütun/satır başlığını tanımlamak içindir
 * <tbody> this is where the data is -- tablonun verisinin olduğu bölümü tanımlar.
 * <tr> table row, indicates one whole row -- tablodaki bütün bir satırı tanımlar.
 * <td> --> cell in a table body  -- hücreyi tanımlar ve veri burada tutulur.
 *
 * Note : Web Table'lardan veri çekmek için xPath kullanmak gerekir. (index ve child to parent işlevi nedeniyle)
 */