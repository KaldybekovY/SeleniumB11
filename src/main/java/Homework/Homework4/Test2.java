package Homework.Homework4;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Test2 {
    /*
Navigate to Navigate to
"http://uitestpractice.com/Students/Select#"
Validate the values for Multiple Select are :
          India
United States of America
China
England
Select China and England
Validate "China England" is displayed
Deselect all the countries
Select All the countries
Validate "India United states of America China
England" is
displayed
Deselect the China with index number
Deselect the England with value
Steps
     */
    @Test
    public void TestCase2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("http://uitestpractice.com/Students/Select#");
        driver.manage().window().maximize();
        List<WebElement> allCountries= driver.findElements(By.xpath("//select[@id='countriesMultiple']/option"));

        Set<String> countries=new LinkedHashSet<>();
        for(WebElement all:allCountries){
            countries.add(all.getText().trim());
        }
        Set<String> expectedCountries=new LinkedHashSet<>();
        expectedCountries.add("India");
        expectedCountries.add("United states of America");
        expectedCountries.add("China");
        expectedCountries.add("England");
        Assert.assertEquals(countries,expectedCountries);

        WebElement china = driver.findElement(By.xpath("//select[@id='countriesMultiple']"));
        BrowserUtils.SelectBy(china,"2","index");

        Thread.sleep(2000);
        WebElement england = driver.findElement(By.xpath("//select[@id='countriesMultiple']"));
        BrowserUtils.SelectBy(england,"england","value");

        Thread.sleep(2000);
        Select select=new Select(england);
        select.deselectAll();
        Thread.sleep(2000);

        List<WebElement> options= select.getOptions();
        for(WebElement option:options){
            option.click();
        }

        Thread.sleep(2000);
        WebElement IsDisplayed= driver.findElement(By.xpath("//div[@id='result']"));
        boolean actualIsDisplayed=IsDisplayed.isDisplayed();
        Assert.assertTrue(actualIsDisplayed);

        Thread.sleep(2000);
        select.deselectByIndex(2);

        Thread.sleep(2000);
        select.deselectByIndex(3);


    }
}
