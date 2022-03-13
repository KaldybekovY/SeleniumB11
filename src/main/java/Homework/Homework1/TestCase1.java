package Homework.Homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {
    public static void main(String[] args) {
        // First step of starting automation should be reading the test case(task)
        // step by step implement the requirements.
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        WebElement fullName = driver.findElement(By.xpath("//input[@id='userName']"));
        fullName.sendKeys("Yernur Kaldybekov");
        String expectedName="Yernur Kaldybekov";
        WebElement email= driver.findElement(By.id("userEmail"));
        email.sendKeys("kaldybekov.91@gmail.com");
        WebElement address= driver.findElement(By.id("currentAddress"));
        address.sendKeys("2462 Forest Drive, Woodridge, IL, 60517");
        WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("2462 Forest Drive, Woodridge, IL, 60517");
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        WebElement actualName= driver.findElement(By.xpath("//p[@id='name']"));
        String expected="Name:Yernur Kaldybekov";
        if(actualName.getText().equals(expected)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        WebElement actualEmail= driver.findElement(By.xpath("//p[@id='email']"));
        String expectedEmail="Email:kaldybekov.91@gmail.com";
        if(actualEmail.getText().equals(expectedEmail)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        WebElement actualAddress= driver.findElement(By.xpath("//p[@id='currentAddress']"));
        String expectedAddress="Current Address :2462 Forest Drive, Woodridge, IL, 60517";
        if(actualAddress.getText().equals(expectedAddress)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        WebElement actualPermanentAddress= driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        String expectedPermanentAddress="Permananet Address :2462 Forest Drive, Woodridge, IL, 60517";
        if(actualPermanentAddress.getText().equals(expectedPermanentAddress)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
    }
}
