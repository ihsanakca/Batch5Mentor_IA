package com.kraft.pages;

import com.github.javafaker.Faker;
import com.kraft.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddExperiencePage extends BasePage{

    Faker faker=new Faker();

    @FindBy(xpath = "//div/button[text()='Add Experience']")
    public WebElement addExperienceBtn;

    @FindBy(css = "input#job")
    public WebElement jobTitleBox;

    public String jobTitle=faker.job().title();
    String company=faker.company().name();
    String location=faker.address().cityName();
    String fromDate="11122014";
    String toDate="10102018";
    String description=faker.lorem().characters(25,true,false);


    public void fillingAddExperienceForm(){

        Actions actions=new Actions(Driver.get());

        actions.click(jobTitleBox)
                .sendKeys(jobTitle+ Keys.TAB)
                .sendKeys(company+ Keys.TAB)
                .sendKeys(location+ Keys.TAB)
                .sendKeys(fromDate+ Keys.TAB+ Keys.TAB)
                .sendKeys(toDate+ Keys.TAB)
                .sendKeys(description+ Keys.TAB+Keys.ENTER)
                .perform();

    }
}
