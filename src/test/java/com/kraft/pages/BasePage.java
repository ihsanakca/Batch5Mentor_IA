package com.kraft.pages;

import com.kraft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

//    public abstract void verifyPageTitle();

    public void navigateTabAndModule(String tabName, String moduleName) {
        WebElement tab = Driver.get().findElement(By.xpath("//span[text()='" + tabName + "']"));
        tab.click();

        if (!moduleName.isEmpty()) {
            WebElement module = Driver.get().findElement(By.xpath("//span[text()='" + moduleName + "']"));
            module.click();
        }
    }

}
