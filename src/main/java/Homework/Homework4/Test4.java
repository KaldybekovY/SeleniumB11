package Homework.Homework4;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Test4 {
    /*
    Navigate to "https://www.cars.com/"
Select "Certified Cars" from drop down
Select "Lexus" from All Makes
Select "ES 350" from drop down
Select max price is "$50000"
Select 50 miles from drop down box
Insert 60016 as zip code
Click search button
Get count of all the cars which is displayed on first
page
Validate count of the cars is not more than 20
Get all car names in first page
Validate All car names has "Lexus ES 350"
Get the Mile distance from zip code for every car
Validate mile distance is no more than 50 mile in first page
Select Sort By --> Price:Highest in drop down
Validate highest price is not more than $50000
     */

    @Test
    public void TestCase4() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.cars.com/");
        driver.manage().window().maximize();

        WebElement certifiedCars= driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.SelectBy(certifiedCars,"1","index");
        Thread.sleep(1000);

        WebElement allMakes= driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.SelectBy(allMakes,"lexus","value");
        Thread.sleep(1000);

        WebElement dropDown= driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.SelectBy(dropDown,"lexus-es_350","value");
        Thread.sleep(1000);

        WebElement maxPrice= driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        BrowserUtils.SelectBy(maxPrice,"50000","value");
        Thread.sleep(1000);

        WebElement distance= driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.SelectBy(distance,"50","value");
        Thread.sleep(1000);

        WebElement zipCode= driver.findElement(By.xpath("//input[@name='zip']"));
        zipCode.clear();
        zipCode.sendKeys("60016");

        Thread.sleep(1000);
        WebElement searchButton= driver.findElement(By.xpath("//button[.='Search']"));
        searchButton.click();

        List<WebElement> actualAllCars= driver.findElements(By.xpath("//h2[@class='title']"));
        int count=0;
        for(WebElement cars:actualAllCars){
            if(count<=20){
                System.out.println("Passed");
            }else{
                System.out.println("Failed");
            }
            count++;
        }
        System.out.println(count);

        List<WebElement> allNames= driver.findElements(By.xpath("//h2[@class='title']"));
        for(WebElement names:allNames){
            System.out.println(names.getText());
            if(names.getText().contains("Lexus ES 350")){
                System.out.println("Passed");
            }else{
                System.out.println("Failed");
            }
        }
        List<WebElement> milesFromZip= driver.findElements(By.xpath("//div[@class='miles-from ']"));
        List<String> distanceFromZip=new ArrayList<>();
        for(WebElement mileFromZip:milesFromZip){
            distanceFromZip.add(mileFromZip.getText().trim());
        }
        System.out.println(distanceFromZip);
       WebElement actualMileDistance= driver.findElement(By.xpath("//select[@id='location-distance']//option[@value='50']"));
       String expectedMileDistance="50 miles";
       Assert.assertEquals(actualMileDistance.getText(),expectedMileDistance);

       WebElement highestInDropDown= driver.findElement(By.xpath("//select[@id='sort-dropdown']//option[.='Highest price']"));
       highestInDropDown.click();

       WebElement highestCompare=driver.findElement(By.xpath("//*[@id=\"7409ddd8-0cfa-49b4-b843-f2ff192466ea\"]/div/div[2]/div[2]/span[1]"));
       String actualHighestPrice=highestCompare.getText().replace("$","");
       int actualPrice=Integer.parseInt(actualHighestPrice);
       Assert.assertEquals(actualPrice,50000);
//       if(actualPrice<=50000){
//           System.out.println("Passed");
//       }else{
//           System.out.println("Failed");
//       }
    }
}
