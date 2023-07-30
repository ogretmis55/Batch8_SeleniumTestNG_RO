package com.eurotech.tests.day_15_actions_fileUpload_isExecutor;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class _1_Actions {
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
    public void hoverOver() {
        /**
         * navigate to https://testpages.herokuapp.com/styled/csspseudo/css-hover.html
         * hover over "Hover Para" element
         * get the text which is seen after hover action
         * and verify that the text is "You can see this paragraph now that you hovered on the above 'button'."
         * also verify that the text is displayed (use explicit wait)
         * hover over the "Hover Div" and verify that the text is not displayed anymore. (use explicit wait)
         */

        driver.get("https://testpages.herokuapp.com/styled/csspseudo/css-hover.html");
        WebElement hoverPara = driver.findElement(By.id("hoverpara"));

        Actions actions=new Actions(driver);

        actions.moveToElement(hoverPara).perform();

        WebElement hoverEffect = driver.findElement(By.id("hoverparaeffect"));

        String actualText=hoverEffect.getText();
        String expectedText="You can see this paragraph now that you hovered on the above 'button'.";

        Assert.assertEquals(actualText,expectedText);

        Assert.assertTrue(new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(hoverEffect)).isDisplayed());

        WebElement hoverDiv = driver.findElement(By.id("hoverdiv"));
        actions.moveToElement(hoverDiv).perform();

        Assert.assertTrue(new WebDriverWait(driver,12).until(ExpectedConditions.invisibilityOf(hoverEffect)));
    }

    @Test
    public void hoverOver_Task() {
        /**
         * go to https://the-internet.herokuapp.com/hovers
         * locate all users (image on the page) with findElements()
         * hover over all of them and verify that "name:user1-2-3" is displayed
         * if any time issues solve them with implicitly or explicitly waits
         */

        driver.get("https://the-internet.herokuapp.com/hovers");
    }

    @Test
    public void dragAndDrop() {
        /**
         * go to https://webdriveruniversity.com/Actions/index.html
         * take the "DRAG ME TO MY TARGET!" box and drop it "DROP HERE!" place
         * verify that "Dropped!" text is displayed..(make text correction at the same time)
         */
       /* driver.get("https://webdriveruniversity.com/Actions/index.html");
        WebElement dragElement = driver.findElement(By.id("draggable"));
        WebElement dropElement = driver.findElement(By.id("droppable"));


        actions.dragAndDrop(dragElement,dropElement).perform();

        driver.findElement(By.cssSelector())
*/

    }

    @Test
    public void dragAndDrop_Task() {
        /**
         * go to https://demoqa.com/droppable
         * take "Drag me" and drop it "Drop here" section
         * verify that the "Dropped!" message is displayed (make text verification)
         */
    }

    @Test
    public void clickWithAction() throws InterruptedException {
        /**
         * navigate to https://skill-test.net/mouse-double-click
         * make double click to the Click box
         * make a normal click to the Click Box (not the middle of element)
         * click on Right Click Test link from left menu (use actions)
         * make right click to the Start box and wait three seconds
         * make normal click on Reset box (use actions)
         */

        driver.get("https://skill-test.net/mouse-double-click");
        WebElement clicker = driver.findElement(By.id("clicker"));
        Actions actions=new Actions(driver);
        actions.doubleClick(clicker).perform();

        WebElement rightClick = driver.findElement(By.xpath("//span[text()='Right Click Test']"));
        actions.click(rightClick).perform();
        WebElement startBtn= driver.findElement(By.id("clicker"));
        actions.contextClick(startBtn).perform();
        Thread.sleep(2000);

        WebElement resetBtn = driver.findElement(By.id("reset"));
        actions.click(resetBtn).perform();


    }

    @Test
    public void rightClickOpenNewTab() throws InterruptedException {
        /**
         * go to https://testpages.herokuapp.com/styled/csspseudo/css-hover.html
         * make right click and open in new tab  (sağ ctrl+click)
         * switch to new opened tab
         * verify that the page title is "EvilTester.com"
         */
        driver.get("https://testpages.herokuapp.com/styled/csspseudo/css-hover.html");
        Thread.sleep(2000);
        WebElement link =driver.findElement(By.linkText("EvilTester.com"));
        Actions actions=new Actions(driver);
        actions.keyDown(Keys.LEFT_CONTROL)
                .click(link)
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();

        ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        String actualTitle=driver.getTitle();
        String expectedTitle="EvilTester.com";

        Assert.assertEquals(actualTitle,expectedTitle);

    }
}