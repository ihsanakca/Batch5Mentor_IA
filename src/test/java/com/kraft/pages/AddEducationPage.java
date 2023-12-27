package com.kraft.pages;

import com.kraft.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddEducationPage extends BasePage{

    @FindBy(xpath = "//button[text()='Add Education'][./parent::div]")
    public WebElement addEducationBtn;

    @FindBy(css = "input#school")
    public WebElement schoolBar;

    public void fillingAddEducationForm(String schoolName,String degree,
            String study,String fromDate,String toDate, String description){

        Actions actions=new Actions(Driver.get());

        actions.click(schoolBar)
                .sendKeys(schoolName+ Keys.TAB)
                .sendKeys(degree+ Keys.TAB)
                .sendKeys(study+ Keys.TAB)
                .sendKeys(fromDate+ Keys.TAB+ Keys.TAB)
                .sendKeys(toDate+ Keys.TAB)
                .sendKeys(description+ Keys.TAB+Keys.ENTER)
                .perform();

    }
}
