package com.kraft.pages;

import com.kraft.utilities.ConfigurationReader;
import com.kraft.utilities.Driver;
import org.openqa.selenium.By;

public interface LoginPageLocators {

    By email_Box= By.id("email");
    By password_Box= By.id("yourPassword");
    By login_Btn= By.tagName("button");

    default void login(){
        Driver.get().findElement(email_Box).sendKeys(ConfigurationReader.get("email"));
        Driver.get().findElement(password_Box).sendKeys(ConfigurationReader.get("password"));
        Driver.get().findElement(login_Btn).click();

    }

    default void login(String email, String password){
        Driver.get().findElement(email_Box).sendKeys(email);
        Driver.get().findElement(password_Box).sendKeys(password);
        Driver.get().findElement(login_Btn).click();

    }


}
