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

public class Test3 {
    /*
    Navigate to "https://www.cars.com/"
Select "Certified Cars" from drop down
Select "Toyota" from All Makes
Select "Corolla" from drop down
Select max price is "$30000"
Select 40 miles from drop down box
Insert 60018 as zip code
Click search button
Validate title has Certified Used
Validate "Certified Used Toyota Corolla for Sale" is
displayed
Validate 40 miles selected in dropdown once you click
search button
Validate Certified Pre-Owned selected in radio button
Validate Toyota is selected in checkbox
Validate Corolla is selected in drop down
     */
    @Test
    public void TestCase3() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.cars.com/");
        driver.manage().window().maximize();

        WebElement certifiedCars= driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.SelectBy(certifiedCars,"4","index");
        Thread.sleep(1000);

        WebElement allMakes= driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.SelectBy(allMakes,"toyota","value");
        Thread.sleep(1000);

        WebElement dropDown= driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.SelectBy(dropDown,"toyota-corolla","value");
        Thread.sleep(1000);

        WebElement maxPrice= driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        BrowserUtils.SelectBy(maxPrice,"30000","value");
        Thread.sleep(1000);

        WebElement distance= driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.SelectBy(distance,"40","value");
        Thread.sleep(1000);

        Thread.sleep(1000);
        WebElement zipCode= driver.findElement(By.xpath("//input[@name='zip']"));
        zipCode.clear();
        zipCode.sendKeys("60018");

        Thread.sleep(1000);
        WebElement searchButton= driver.findElement(By.xpath("//button[.='Search']"));
        searchButton.click();

        Thread.sleep(1000);
        WebElement actualHeader= driver.findElement(By.xpath("//h1[.='Certified used Toyota Corolla for sale']"));
        String expectedHeader="Certified used Toyota Corolla for sale";
        Assert.assertEquals(actualHeader.getText(),expectedHeader);

        Thread.sleep(1000);
        WebElement searchWithin= driver.findElement(By.xpath("//select[@id='location-distance']"));
        BrowserUtils.SelectBy(searchWithin,"40","value");

        Thread.sleep(1000);
        WebElement actualCertifiedPreowned=driver.findElement(By.xpath("//a[.='Certified Pre-Owned']"));
        String expectedCertifiedPreowned="Certified Pre-Owned";
        Assert.assertEquals(actualCertifiedPreowned.getText(),expectedCertifiedPreowned);

//        WebElement toyotaCheckBox= driver.findElement(By.xpath(""));
//        boolean actualToyotaCheckBox=toyotaCheckBox.isSelected();
//        Assert.assertTrue(actualToyotaCheckBox);

//        WebElement corollaDropDown= driver.findElement(By.xpath("//div[@class='sds-checkbox']//label[@for='model_toyota-corolla']"));
//        boolean actualCorollaDropDown=corollaDropDown.isSelected();
//        Assert.assertTrue(actualCorollaDropDown);

    }
}
