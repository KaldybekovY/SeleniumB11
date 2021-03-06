package com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    // we are going to store our element locations and methods here.

    @FindBy(xpath = "//input[@id='username']")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='loginsubmit']")WebElement loginButton;

//    public void login(){
//        username.sendKeys("EM01");
//        password.sendKeys("sentrifugo");
//        loginButton.submit();
//    }

    public void DynamicLogin(String username,String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.submit();
    }



}
