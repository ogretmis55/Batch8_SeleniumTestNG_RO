package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddExperiencePage extends BasePage {

    Faker faker=new Faker();


    @FindBy(xpath = "//button[@value='experience']")
    public WebElement addExperienceBtn;

    @FindBy(xpath = "//input[@id='job']")
    public WebElement jobTitle;

    @FindBy(xpath = "//li/button[text()='Add Experience']")
    public WebElement addExperienceBox;

    public String jobTitleName=faker.job().title();

    String companyName=faker.company().name();

    String locationName=faker.address().cityName();

    String fromDate="11112001";
    String toDate="10102010";

    String jobDescription= faker.lorem().characters(25,false,false);



    public void fillAddExperienceForm(){
        Actions actions = new Actions(Driver.get());

            actions.click(jobTitle)
                .sendKeys(jobTitleName+ Keys.TAB)
                .sendKeys(companyName+Keys.TAB)
                .sendKeys(locationName+Keys.TAB)
                .sendKeys(fromDate+Keys.TAB+Keys.TAB)
                .sendKeys(toDate+Keys.TAB)
                .sendKeys(jobDescription+Keys.TAB+Keys.ENTER).perform();

    }
}
