package com.test.openchart.tests;

import Utils.ConfigReader;
import Utils.DriverHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public WebDriver driver;

    @BeforeMethod
    public void setup(){
//        driver=DriverHelper.getDriver();
//        driver.get(ConfigReader.readProperty("urlorangehrm"));
    }

    @AfterMethod
    public void tearDown(){

        DriverHelper.tearDown();

    }
}