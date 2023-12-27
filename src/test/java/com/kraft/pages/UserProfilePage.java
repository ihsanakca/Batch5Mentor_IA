package com.kraft.pages;

import com.kraft.utilities.BrowserUtils;
import com.kraft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfilePage extends BasePage{

    @FindBy(css = ".breadcrumb-item:nth-of-type(2)")
    public WebElement userProfilePageTitle;


    public void navigateUserProfileTabs(String tabName){
        Driver.get().findElement(By.xpath("//button[text()='"+tabName+"'][./parent::li]")).click();
    }

    public String addedLastEducationRecordName(String schoolName){
        return Driver.get().findElement(By.xpath("(//span[text()='"+schoolName+"'])[last()]")).getText();
    }

    public void deleteLastAddedEducationRecord(String schoolName){

        WebElement deleteBtn =
                Driver.get().findElement(By.xpath("(//span[text()='"+schoolName+"'])[last()]/ancestor::tr//a"));

        BrowserUtils.scrollToElement(deleteBtn);
        BrowserUtils.clickWithJS(deleteBtn);

        System.out.println(Driver.get().switchTo().alert().getText());
        Driver.get().switchTo().alert().accept();

    }

}
