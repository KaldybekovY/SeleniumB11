package Iframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedFrame {
    @Test
    public void NestedFrame(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.manage().window().maximize();
        driver.switchTo().frame(0);
        WebElement middleFrame= driver.findElement(By.name("frame-middle"));
        driver.switchTo().frame(middleFrame);
        WebElement textBox= driver.findElement(By.xpath("//div[@id='content']"));
        String actualName= BrowserUtils.getTextMethod(textBox);
        String expectedName="MIDDLE";
        Assert.assertEquals(actualName,expectedName);
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-left");
        WebElement leftFrame= driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        String actualText=BrowserUtils.getTextMethod(leftFrame);
        String expectedText="LEFT";
        Assert.assertEquals(actualText,expectedText);
//        driver.switchTo().parentFrame();
//        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        WebElement bottomFrame= driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        String actualBottom=BrowserUtils.getTextMethod(bottomFrame);
        String expectedBottom="BOTTOM";
        Assert.assertEquals(actualText,expectedText);
    }
}
