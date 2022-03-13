package com.test.audiusa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AudiMainPage {

    public AudiMainPage(WebDriver driver){ PageFactory.initElements(driver,this);}

    @FindBy(xpath = "//label[@for='nm-model-band-4574112-types-0']//span[.='SUVs & Wagons']")
    WebElement SuvAndWagonsClick;

    @FindBy(className = "onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon")
    WebElement cookiesClick;

    public void setSuvAndWagonsClick() throws InterruptedException {


        Thread.sleep(2000);
        SuvAndWagonsClick.click();
    }
}
