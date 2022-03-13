package com.test.audiusa.tests;

import com.test.audiusa.AudiTestBase;
import com.test.audiusa.pages.AudiMainPage;
import com.test.orangehrm.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;


public class AudiMainTests extends AudiTestBase {


    @Test
    public void MainValidations() throws InterruptedException {

        AudiMainPage audiMainPage=new AudiMainPage(driver);
//        driver.manage().deleteAllCookies();
        audiMainPage.setSuvAndWagonsClick();
    }
}
