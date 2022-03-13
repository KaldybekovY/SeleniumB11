package Homework.Homework4;

import Utils.BrowserUtils;
import com.github.dockerjava.api.model.Link;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.PseudoColumnUsage;
import java.util.*;

public class Test1 {

    @Test
    public void TestCase1() throws InterruptedException {
        /*
    Navigate to
"http://uitestpractice.com/Students/Select#"
Validate India is selected by default on drop down
box
Validate the size of the Drop down box is 4
Validate the values for Drop down box are :
          India
United States of America
China
England
          Select the China with index number
Select the England with value
Select the United States with visible text
Steps
     */
     WebDriverManager.chromedriver().setup();
     WebDriver driver=new ChromeDriver();
     driver.navigate().to("http://uitestpractice.com/Students/Select#");
     driver.manage().window().maximize();
     WebElement actualSelectIndia= driver.findElement(By.xpath("//select[@id='countriesSingle']//option[@value='india']"));
     actualSelectIndia.click();
     boolean expectedIndia=true;
     Assert.assertTrue(actualSelectIndia.isSelected());
     List<WebElement> allCountries= driver.findElements(By.xpath("//select[@id='countriesSingle']/option"));

     Set<String> countries=new LinkedHashSet<>();
     int count=0;
     for(WebElement all:allCountries){
         countries.add(all.getText().trim());
         count++;
     }
     Set<String> expectedCountries=new LinkedHashSet<>();
     expectedCountries.add("India");
     expectedCountries.add("United states of America");
     expectedCountries.add("China");
     expectedCountries.add("England");
     Assert.assertEquals(countries,expectedCountries);
     int size=4;
     Assert.assertEquals(count,size);

     WebElement china = driver.findElement(By.xpath("//select[@id='countriesSingle']"));
     BrowserUtils.SelectBy(china,"2","index");
     Thread.sleep(2000);
     WebElement england = driver.findElement(By.xpath("//select[@id='countriesSingle']"));
     BrowserUtils.SelectBy(england,"england","value");
     Thread.sleep(2000);
     WebElement usa = driver.findElement(By.xpath("//select[@id='countriesSingle']"));
     BrowserUtils.SelectBy(usa,"United states of America","text");

    }
}
