package Homework.HomeworkSauce;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestCase1 {

    @Test
    public void Test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        WebElement userName= driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement passWord= driver.findElement(By.id("password"));
        passWord.sendKeys("secret_sauce");
        WebElement logIn= driver.findElement(By.name("login-button"));
        logIn.click();
        WebElement ZtoA= driver.findElement(By.xpath("//option[.='Name (Z to A)']"));
        ZtoA.click();
        List<WebElement> allProducts=driver.findElements(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div"));
        List<String> actualProducts=new LinkedList<>();
        List<String> expectedProducts=new ArrayList<>();
        for(WebElement products:allProducts){
            actualProducts.add(products.getText().trim());
            expectedProducts.add(products.getText().trim());
            Collections.sort(expectedProducts);
            Collections.reverse(expectedProducts);
        }
        Assert.assertEquals(actualProducts,expectedProducts);
    }
}
