package Homework.Homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/radio-button");
        WebElement yes = driver.findElement(By.id("yesRadio"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",yes);
        WebElement validYes= driver.findElement(By.xpath("//p[@class='mt-3']"));
        String expected="You have selected Yes";
        if(validYes.getText().equals(expected)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        WebElement impressive = driver.findElement(By.id("impressiveRadio"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",impressive);
        WebElement validImp= driver.findElement(By.xpath("//p[@class='mt-3']"));
        String exprectedImp="You have selected Impressive";
        if(validImp.getText().equals(exprectedImp)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
    }
}
