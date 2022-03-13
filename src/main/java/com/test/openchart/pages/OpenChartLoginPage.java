package com.test.openchart.pages;

import Utils.BrowserUtils;
import com.test.orangehrm.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenChartLoginPage {

    public OpenChartLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='input-username']")WebElement userName;
    @FindBy(xpath = "//input[@id='input-password']")WebElement password;
    @FindBy(xpath = "//button[@type='submit']")WebElement loginBtn;
    @FindBy(xpath = "//div[@class='tile-body']//h2[.='12K']")WebElement totalOrders;
    @FindBy(xpath = "//div[@class='tile-body']//h2[.='11.8M']")WebElement totalSales;
    @FindBy(xpath = "//div[@class='tile-body']//h2[.='144.8K']")WebElement totalCustomers;
    @FindBy(xpath = "//a[contains(text(),'View more...')]")WebElement viewMoreBtn;

    public void clickLoginBtn() throws InterruptedException {
        userName.clear();
        userName.sendKeys("demo");
        Thread.sleep(1000);
        loginBtn.click();
        viewMoreBtn.click();
    }

    public String validateTotalOrders(){
        return BrowserUtils.getTextMethod(totalOrders);
    }

    public String validateTotalSales(){
        return BrowserUtils.getTextMethod(totalSales);
    }

    public String validateTotalCustomers(){
        return BrowserUtils.getTextMethod(totalCustomers);
    }

    /*
    Loginpage-->login to the website user name: demo password: demo
    1-Navigate to the website(it is already in your testbase)
    2-Login to the openchartwebsite
    MainPage-->do these validations
    3-Validate total orders is "12K"
    4-Validate total sales is "11.8M"
    5-Validate Customers is "144.8K"
    CustomerPage--?fill there boxe and validate the message and color
    6-Click Customers on the side tab
    7-Click Customers on the open tab from Customers
    8-Click+button to add customers
    9-Fill the all boxes
    1--Click save button
    11-validate the message and color
     */

}
