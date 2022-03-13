package Homework.Homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NopCommerce {
    public static void main(String[] args) throws InterruptedException {
        /*
        TASK 2:Creating an account for nopcommerce and validation
        1-NAVIGATE TO THE WEBSITE https://demo.nopcommerce.com/
        2-Click Register
        3-Fill the information
        4-Newsletter box should be left unclicked
        5-Click Register
        6-Validate “Your registration completed”
        7-Click Continue (edited)
         */
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        WebElement register= driver.findElement(By.xpath("//a[@class='ico-register']"));
        register.click();
        Thread.sleep(2000);
        WebElement gender= driver.findElement(By.xpath("//input[@value='F']"));
        gender.click();
        Thread.sleep(2000);
        WebElement firstName=driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("Zakosha");
        Thread.sleep(2000);
        WebElement lastName= driver.findElement(By.xpath("//input[@id='LastName']"));
        lastName.sendKeys("Zhubik");
        Thread.sleep(2000);
        WebElement date=driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        date.sendKeys("1");
        Thread.sleep(2000);
        WebElement month=driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
        month.sendKeys("June");
        Thread.sleep(2000);
        WebElement year=driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
        year.sendKeys("1919");
        Thread.sleep(2000);
        WebElement email=driver.findElement(By.xpath("//input[@id='Email']"));
        email.sendKeys("zakosha.95@mail.ru");
        Thread.sleep(2000);
        WebElement company=driver.findElement(By.xpath("//input[@id='Company']"));
        company.sendKeys("Zakosha & Friends");
        Thread.sleep(2000);
        WebElement newsletter=driver.findElement(By.xpath("//input[@id='Newsletter']"));
        newsletter.click();
        Thread.sleep(2000);
        WebElement password= driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("Zak1995");
        Thread.sleep(2000);
        WebElement reenter= driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        reenter.sendKeys("Zak1995");
        Thread.sleep(2000);
        WebElement registerButton= driver.findElement(By.xpath("//button[@id='register-button']"));
        registerButton.click();
        Thread.sleep(2000);
        WebElement validation=driver.findElement(By.xpath("//div[@class='result']"));
        String expected="Your registration completed";
        if(validation.getText().equals(expected)){
            System.out.println("Passed");
        }else
            System.out.println("Failed");
    }
}
