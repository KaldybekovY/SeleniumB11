package com.test.orangehrm.pages;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminPage {

    public AdminPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "btnAdd")WebElement addButton;

    @FindBy(id = "systemUser_userType")WebElement userRole;

    @FindBy(id = "systemUser_employeeName_empName")WebElement employeeName;

    @FindBy(id = "systemUser_userName")WebElement userName;

    @FindBy(xpath = "//select[@id='systemUser_status']")WebElement status;

    @FindBy(name = "systemUser[password]")WebElement password;

    @FindBy(name = "systemUser[confirmPassword]")WebElement confirmPassword;

    @FindBy(className = "addbutton")WebElement saveButton;

    @FindBy(xpath = "//tr//a[contains(@href,'saveSystemUser')]")
    List<WebElement> allNames;

    @FindBy(id = "searchSystemUser_userType")WebElement userRoleBox;

    @FindBy(id = "searchBtn")WebElement searchBox;


    public void SendInfoForEmployee(String username) throws InterruptedException {

        addButton.click();
        BrowserUtils.SelectBy(userRole,"Admin","text");
        employeeName.sendKeys("Alice Duval");
        userName.sendKeys(username);
        BrowserUtils.SelectBy(status,"0","value");
        password.sendKeys("GalVanIze2020");
        confirmPassword.sendKeys("GalVanIze2020");
        Thread.sleep(1000);
        saveButton.click();
        Thread.sleep(1000);

    }

    public boolean ValidationTheEmpIsCreated(String userName){
        for (WebElement name:allNames){
            if(name.getText().trim().equals(userName)){
              return true;
            }
        }
        return false;
    }
    public void selectUserRoles(String roleName, WebDriver driver){
        BrowserUtils.SelectBy(userRoleBox,roleName,"text");
        BrowserUtils.ClickWithJS(driver,searchBox);
    }

}
