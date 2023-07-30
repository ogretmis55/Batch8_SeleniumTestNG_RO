package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//ul[@class=\"d-flex align-items-center\"]/li")
    public List<WebElement> tabMenu;

    @FindBy(xpath = "//span[@class='d-none d-md-block dropdown-toggle ps-2']")
    public WebElement userNameAtRightTop;
    public List<String> getTabMenuNames(){
        List<String> list=new ArrayList<>();
        for (WebElement menu : tabMenu) {
            list.add(menu.getText());
        }
        return list;
    }

    public void navigateToTabsAndModules(String tabName){
        WebElement tab = Driver.get().findElement(By.xpath("//span[text()='" + tabName + "']"));
        tab.click();

    }
    public void navigateToTabsAndModules(String tabName,String moduleName) {
        WebElement tab = Driver.get().findElement(By.xpath("//span[text()='" + tabName + "']"));
        tab.click();
        if (!moduleName.isEmpty()) {
            WebElement module = Driver.get().findElement(By.xpath("//span[text()='" + moduleName + "']"));
            module.click();

        }
    }
}