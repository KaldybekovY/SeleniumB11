package Wait;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitlyWaitPractice {

    @Test
    public void GetTheText(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.manage().window().maximize();
        WebElement startBtn= driver.findElement(By.xpath("//button[.='Start']"));
        startBtn.click();
//        WebElement HelloText= driver.findElement(By.xpath("//h4[.='Hello World!']"));
//        String actualText= BrowserUtils.getTextMethod(HelloText);
//        Assert.assertEquals(actualText,"Hello World!");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement text1=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[.='Hello World!']"))));
        Assert.assertEquals(text1.getText(),"Hello World!");


    }
}
