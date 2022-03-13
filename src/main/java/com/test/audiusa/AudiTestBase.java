package com.test.audiusa;

import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AudiTestBase {

    public WebDriver driver= DriverHelper.getDriver();;

    @BeforeMethod
    public void setup(){
        driver.get("https://www.audiusa.com/");
    }

    @AfterMethod
    public void tearDown(){
        DriverHelper.tearDown();
    }
}
