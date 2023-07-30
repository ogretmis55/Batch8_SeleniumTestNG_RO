package com.eurotech.pages;

import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfilePage extends BasePage {

    @FindBy(xpath = "//li[@class='breadcrumb-item'][2]")
    public WebElement userProfilePageTitle;


    @FindBy(css = "div#profile-overview>div:nth-of-type(1)")
    public WebElement profileUpdateMessage;

    public void navigateUserProfileTabs(String tabName) {
        WebElement tab = Driver.get().findElement(By.xpath("//button[text()='" + tabName + "']/parent::li"));
        tab.click();
    }

    public String addedEducationName(String schoolName){
        return Driver.get().findElement(By.xpath("(//span[text()='"+schoolName+"'])[last()]")).getText();
    }


    public void deleteEducationLastRecord(String schoolName){

        WebElement deleteBtn = Driver.get().
                findElement(By.xpath("(//span[text()='"+schoolName+"'])[last()]/ancestor::tr//a"));
        BrowserUtils.scrollToElement(deleteBtn);
        BrowserUtils.clickWithJS(deleteBtn);

        Alert alert = Driver.get().switchTo().alert();
        alert.accept();

    }
    public String addedExperienceName(String jobTitleName){
       return Driver.get().findElement(By.xpath("(//span[text()='" + jobTitleName + "'])[last()]")).getText();
    }
    public void deleteExperience(String jobTitleName){
        WebElement deleteEducationBtn = Driver.get()
                .findElement(By.xpath("(//span[text()='"+jobTitleName+"'])[last()]/ancestor::tr//a"));

        BrowserUtils.waitForClickablility(deleteEducationBtn, 7);
        BrowserUtils.clickWithJS(deleteEducationBtn);
        Alert alert = Driver.get().switchTo().alert();
        BrowserUtils.waitFor(5);
        alert.accept();


    }
}
