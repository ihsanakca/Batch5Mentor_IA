package com.kraft.pages;

import com.kraft.utilities.ConfigurationReader;
import com.kraft.utilities.Driver;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BasePage{
//    public LoginPage(){
//        PageFactory.initElements(Driver.get(),this);
//    }

    @FindBy(id="email")
    public WebElement emailBox;
    //WebElement emailBox=driver.findElement(By.id("email"));

    @FindBy(id = "yourPassword")
    public WebElement passwordBox;

    @FindBy(tagName = "button")
    public WebElement loginBtn;

    @FindBy(css = ".form-control, button")
    public List<WebElement> loginInputs;

    public void login(){
        emailBox.sendKeys(ConfigurationReader.get("email"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));
        loginBtn.click();
    }
    public void login(String email,String password){
        emailBox.sendKeys(email);
        passwordBox.sendKeys(password);
        loginBtn.click();
    }

}
