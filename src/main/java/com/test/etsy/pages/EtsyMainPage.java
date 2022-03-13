package com.test.etsy.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Locale;

public class EtsyMainPage {
    public EtsyMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='global-enhancements-search-query']")
    WebElement searchBar;
    @FindBy(xpath = "//li//h3")
    List<WebElement> allHeaders;

    public void setSearchBar(String searchItem) throws InterruptedException {
        searchBar.sendKeys(searchItem, Keys.ENTER);
    }

    public boolean validateHeader() {
        for (WebElement header : allHeaders) {
            String headr = header.getText().trim().toLowerCase();
            if (!(headr.contains("iphone") || headr.contains("13") || headr.contains("case"))) {
                return false;
                }
            }
            return true;
        }
    }
