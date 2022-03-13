package com.test.orangehrm.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    //modify this page according to POM

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "txtUsername") WebElement userName;

    @FindBy(id = "txtPassword")WebElement password;

    @FindBy(id = "btnLogin")WebElement loginButton;

    @FindBy(id = "spanMessage")WebElement invalidCredentials;

    public void login(String username, String password){
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.submit();

    }
    public String GetInvalidCredentials(){

        return BrowserUtils.getTextMethod(invalidCredentials);

    }

    public String getColorOfMessage(){

        return invalidCredentials.getCssValue("color");

    }
}
