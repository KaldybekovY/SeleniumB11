package com.test.orangehrm.tests;

import Utils.ConfigReader;
import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.AdminPage;
import com.test.orangehrm.pages.LoginPage;
import com.test.orangehrm.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminTest extends TestBase {

    @Test
    public void ValidateNewEmpMessage() throws InterruptedException {

        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("Admin","admin123");
        MainPage mainPage=new MainPage(driver);
        mainPage.clickAdminButton();
        AdminPage adminPage=new AdminPage(driver);
        adminPage.SendInfoForEmployee("Setchenov");
        Assert.assertTrue(adminPage.ValidationTheEmpIsCreated("Setchenov"));
        
    }
    @Test
    public void ValidateSelectRoleFunctions(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(ConfigReader.readProperty("orangehrmusername"),ConfigReader.readProperty("orangehrmpassword"));
        MainPage mainPage=new MainPage(driver);
        mainPage.clickAdminButton();
        AdminPage adminPage=new AdminPage(driver);
        adminPage.selectUserRoles("Admin",driver);

    }

    @Test
    public void ValidateSelectRoleFunctions2(){

        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(ConfigReader.readProperty("orangehrmusername"),ConfigReader.readProperty("orangehrmpassword"));
        MainPage mainPage=new MainPage(driver);
        mainPage.clickAdminButton();
        AdminPage adminPage=new AdminPage(driver);
        adminPage.selectUserRoles("ESS",driver);

    }
}
