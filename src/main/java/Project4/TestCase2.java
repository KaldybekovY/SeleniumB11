package Project4;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class TestCase2 {

    @Test
    public void Test2(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        opt.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        opt.addArguments("disable-infobars");
        WebDriver driver=new ChromeDriver(opt);

        driver.get("http://uitestpractice.com/Students/Index");
        WebElement createNew=driver.findElement(By.xpath("//a[.='Create New']"));

        driver.navigate().to(createNew.getAttribute("href"));
        WebElement firstName= driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("Eric");
        WebElement lastName= driver.findElement(By.xpath("//input[@id='LastName']"));
        lastName.sendKeys("West");
        WebElement enrollmentDate= driver.findElement(By.xpath("//input[@id='EnrollmentDate']"));
        enrollmentDate.sendKeys("2/22/2022");
        WebElement createButton= driver.findElement(By.xpath("//input[@value='Create']"));
        createButton.click();
        WebElement searchBox= driver.findElement(By.xpath("//input[@id='Search_Data']"));
        searchBox.sendKeys("Eric");
        WebElement submit= driver.findElement(By.xpath("//input[@type='submit']"));
        submit.click();
        WebElement firstNameValidation= driver.findElement(By.xpath("//tbody//td[1]"));
        String actualFirstNameValidation= BrowserUtils.getTextMethod(firstNameValidation);
        String expectedFirstNameValidation="Eric";
        Assert.assertEquals(actualFirstNameValidation,expectedFirstNameValidation);

    }
}
