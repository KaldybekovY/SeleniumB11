package Homework.Homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase4 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        WebElement userName= driver.findElement(By.id("user-name"));
        userName.sendKeys("standart_user");
        WebElement passWord= driver.findElement(By.id("password"));
        passWord.sendKeys("secret_sauce");
        WebElement button=driver.findElement(By.id("login-button"));
        button.click();
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.saucedemo.com/";
        if(actualUrl.equals(expectedUrl)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
    }
}
