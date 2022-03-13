package TESTNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RealTestngPractice {

    @Test//testing if website is correct or not
    public void validateWebsite(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        String actualWebsite=driver.getCurrentUrl();
        String expectedWebsite="https://demo.opencart.com/admin/";
        Assert.assertEquals(actualWebsite,expectedWebsite);
        WebElement logIn= driver.findElement(By.xpath("//button[@type='submit']"));
        logIn.click();

    }
    @Test
    public void validateCatalogIsDisplayed(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement logIn= driver.findElement(By.xpath("//button[@type='submit']"));
        logIn.click();
        WebElement catalogBar=driver.findElement(By.id("menu-catalog"));
        boolean ActualCatalog=catalogBar.isDisplayed();
        boolean ExpectedCatalog=true;
        Assert.assertEquals(ActualCatalog,ExpectedCatalog,"Catalog is not there");
        catalogBar.click();
    }

    @Test
    public void validateProductsIsDisplayed() throws InterruptedException{
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement logIn= driver.findElement(By.xpath("//button[@type='submit']"));
        logIn.click();
        WebElement catalogBar=driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        WebElement productBar=driver.findElement(By.xpath("//a[.='Products']"));
        boolean ActualProduct=productBar.isDisplayed();
        boolean ExpectedProduct=true;
        Assert.assertEquals(ActualProduct,ExpectedProduct);
        Thread.sleep(1000);
        productBar.click();
        List<WebElement> checkBoxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
        for(int i=1;i<checkBoxes.size();i++){
            Thread.sleep(500);
            checkBoxes.get(i).click();
            boolean ActualBoxValidation=checkBoxes.get(i).isDisplayed();
            boolean ExpectedBoxValidation=true;
            Assert.assertEquals(ActualBoxValidation,ExpectedBoxValidation);
            boolean ActualBoxValidationIsSelected=checkBoxes.get(i).isSelected();
            boolean ExpectedBoxValidationIsSelected=true;
            Assert.assertEquals(ActualBoxValidationIsSelected,ExpectedBoxValidationIsSelected);
        }
    }
}
