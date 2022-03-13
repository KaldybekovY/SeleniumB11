package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookPractice {
    public static void main (String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.facebook.com/";
        if(actualUrl.equals(expectedUrl)){
            System.out.println("The website is correct");
        }else{
            System.out.println("The website is wrong");
        }

        driver.get("https://www.facebook.com/");
        WebElement createNew= driver.findElement(By.xpath("//a[.='Create new account']"));
        createNew.click();
        Thread.sleep(3000);
        WebElement firstName= driver.findElement(By.xpath("//input[@tabindex='0']"));
        firstName.sendKeys("Yenlik");
        Thread.sleep(3000);
        WebElement lastName= driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Karaguzova");
        Thread.sleep(3000);
        WebElement mobileNumber= driver.findElement(By.xpath("//input[@name='reg_email__']"));
        mobileNumber.sendKeys("3056753535");
        Thread.sleep(3000);
        WebElement newPassword= driver.findElement(By.xpath("//input[@autocomplete='new-password']"));
        newPassword.sendKeys("Arhehe4545");
        Thread.sleep(3000);
        WebElement month= driver.findElement(By.xpath("//select[@title='Month']"));
        month.sendKeys("Mar");
        Thread.sleep(3000);
        WebElement day= driver.findElement(By.xpath("//select[@name='birthday_day']"));
        day.sendKeys("3");
        Thread.sleep(3000);
        WebElement year= driver.findElement(By.name("birthday_year"));
        year.sendKeys("2000");
        Thread.sleep(3000);
        WebElement gender= driver.findElement(By.xpath("//input[@name='sex' and @value='2']"));
        gender.click();
        Thread.sleep(3000);
        WebElement signUp= driver.findElement(By.xpath("//button[@name='websubmit']"));
        signUp.click();
        WebElement error=driver.findElement(By.xpath("//div[@tabindex='0' and @id='reg_error_inner']"));
        String expectedError="There was an error with your registration. Please try registering again.";
        if(error.getText().equals(expectedError)){
            System.out.println("Your error has been validated");
        }else{
            System.out.println("Your error has not been validated");
        }
        Thread.sleep(3000);
        WebElement moreInfo = driver.findElement(By.xpath("//div[@class='l9j0dhe7 du4w35lb j83agx80 pfnyh3mw taijpn5t bp9cbjyn owycx6da btwxx1t3 kt9q3ron ak7q8e6j isp2s0ed ri5dt5u2 rt8b4zig n8ej3o3l agehan2d sk4xxmp2 rq0escxv d1544ag0 tw6a2znq s1i5eluu tv7at329']"));
        moreInfo.click();
    }
}
