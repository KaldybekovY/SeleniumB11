package Homework.Homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase3 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        WebElement userName= driver.findElement(By.id("user-name"));
        userName.sendKeys("Java");
        WebElement passWord= driver.findElement(By.id("password"));
        passWord.sendKeys("Selenium");
        WebElement button=driver.findElement(By.id("login-button"));
        button.click();
        WebElement error= driver.findElement(By.xpath("//h3"));
        String expectedError="Epic sadface: Username and password do not match any user in this service";
        if(error.getText().equals(expectedError)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
    }
}
