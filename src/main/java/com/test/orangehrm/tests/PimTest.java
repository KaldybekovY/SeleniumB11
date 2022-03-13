package com.test.orangehrm.tests;

import Utils.BrowserUtils;
import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.LoginPage;
import com.test.orangehrm.pages.MainPage;
import com.test.orangehrm.pages.PimPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PimTest extends TestBase {

    LoginPage loginPage;
    MainPage mainPage;
    PimPage pimPage;


    @BeforeMethod
    public void initializingPages(){

        loginPage=new LoginPage(driver);
        mainPage=new MainPage(driver);
        pimPage=new PimPage(driver);

    }

    @Test
    public void PimTest() throws InterruptedException {

        loginPage.login("Admin","admin123");
        mainPage.clickAdminButton();
        pimPage.addEmployeeForPIM("Eric","West","1991","/Users/ernur/Desktop/kazakh-flag-medium.png");
        Assert.assertEquals(pimPage.nameValid(),"Eric");
        Assert.assertEquals(pimPage.lastValid(),"West");
        Assert.assertTrue(pimPage.empIdValid("1991"));

    }

    @Test
    public void Validate() throws InterruptedException {

        loginPage.login("Admin","admin123");
        mainPage.clickAdminButton();
        pimPage.addEmployeeForPIM("Eric","West","1991","/Users/ernur/Desktop/kazakh-flag-medium.png");
        pimPage.personalDetails();
        Assert.assertEquals(pimPage.validateNationality(),"Kazakhstani");
        Assert.assertEquals(pimPage.validateMarital(),"Married");

    }
}

