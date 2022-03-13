package com.test.sentrifugo.tests;

import com.test.sentrifugo.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

//    @Test
//    public void validateSuperAdmin(){
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("http://demo.sentrifugo.com/index.php/");
//        WebElement userName= driver.findElement(By.xpath("//input[@id='username']"));
//        userName.sendKeys("EM01");
//        WebElement passWord= driver.findElement(By.xpath("//input[@id='password']"));
//        passWord.sendKeys("sentrifugo");
//        WebElement loginButton= driver.findElement(By.xpath("//input[@id='loginsubmit']"));
//        loginButton.submit();

//        String actualURL= driver.getCurrentUrl();
//        String expectedURL="http://demo.sentrifugo.com/index.php/index/welcome";
//        Assert.assertEquals(actualURL,expectedURL);

    @Test
    public void ValidateSuperAdmin(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.sentrifugo.com/index.php/");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.DynamicLogin("EM05","sentrifugo");
        String actualURL= driver.getCurrentUrl();
        String expectedURL="http://demo.sentrifugo.com/index.php/index/welcome";
        Assert.assertEquals(actualURL,expectedURL);

        }

        @Test
    public void ValidateManagement(){

            WebDriverManager.chromedriver().setup();
            WebDriver driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://demo.sentrifugo.com/index.php/");
            LoginPage loginPage=new LoginPage(driver);
            loginPage.DynamicLogin("EM02","sentrifugo");
            String actualTitle= driver.getTitle();
            String expectedTitle="Sentrifugo - Open Source HRMS";
            Assert.assertEquals(actualTitle,expectedTitle);

        }
    }

