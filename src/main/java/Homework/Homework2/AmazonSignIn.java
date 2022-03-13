package Homework.Homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSignIn {
    public static void main(String[] args) {
        /*

        1-NAVIGATE TO THE WEBSITE https://www.amazon.com/
        2_Click Hello, Sign in Button
        3-Click Create your amazon account button
        4-Fill the information and click Continue Button
        5-If there is an error or message. Validate it, if not then you completed the task

         */
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        WebElement signIn= driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        signIn.click();
        WebElement createAccount= driver.findElement(By.xpath("//a[@id='createAccountSubmit']"));
        createAccount.click();
        WebElement name= driver.findElement(By.xpath("//input[@id='ap_customer_name']"));
        name.sendKeys("Samanta");
        WebElement email= driver.findElement(By.xpath("//input[@id='ap_email']"));
        email.sendKeys("samanta.88@yahoo.com");
        WebElement password= driver.findElement(By.xpath("//input[@id='ap_password']"));
        password.sendKeys("Sam1988");
        WebElement reenter= driver.findElement(By.xpath("//input[@id='ap_password_check']"));
        reenter.sendKeys("Sam1988");
        WebElement Continue=driver.findElement(By.xpath("//input[@id='continue']"));
        Continue.click();

    }
}
