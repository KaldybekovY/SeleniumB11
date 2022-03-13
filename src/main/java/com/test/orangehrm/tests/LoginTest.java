package com.test.orangehrm.tests;

import TESTNG.DataForNames;
import Utils.ConfigReader;
import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.LoginPage;
import com.test.orangehrm.pages.PimPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    LoginPage loginPage;

    @BeforeMethod
    public void setup(){
        loginPage=new LoginPage(driver);

    }

    @Test
    public void ValidateLoginPositive(){

        loginPage.login(ConfigReader.readProperty("orangehrmusername"),ConfigReader.readProperty("orangehrmpassword"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/index.php/dashboard");

    }

    @Test(dataProvider = "LoginTest",dataProviderClass = DataProvider.class)
    public void validateLoginNegative(String username, String password, String expectedFullPassword){

        loginPage.login(username,password);
        Assert.assertEquals(loginPage.GetInvalidCredentials(),expectedFullPassword);
    }

    //2 more negative scenarios (wrong username, correct password), (wrong username, wrong password)

    @Test
    public void validateLoginNegative2(){

        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("","");
        String actualInvalid= loginPage.GetInvalidCredentials();
        String expectedInvalid="Username cannot be empty";
        Assert.assertEquals(actualInvalid,expectedInvalid);
        String actualColorOfMessage=loginPage.getColorOfMessage();
        String expectedColorOfMessage="rgba(221, 119, 0, 1)";
        Assert.assertEquals(actualColorOfMessage,expectedColorOfMessage);

    }

}
