package Iframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;//ul[@id='primary-menu']//span[.='Selenium-Java']//..
import org.testng.Assert;
import org.testng.annotations.Test;

public class iframeTask {

    @Test
    public void iframeTask() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://skpatro.github.io/demo/iframes/");
        driver.manage().window().maximize();
        WebElement pavillion= driver.findElement(By.xpath("//a[.='Pavilion']"));
        Thread.sleep(2000);
        pavillion.click();
        BrowserUtils.SwitchByTitle(driver,"Home - qavalidation");
        Thread.sleep(1000);
        WebElement clickSelenium= driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/ul/li[2]/a/span/span"));
        WebElement clickSeleniumJava= driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium-Java']//.."));
        Actions actions=new Actions(driver);
        actions.moveToElement(clickSelenium).perform();
        Thread.sleep(2000);
        actions.moveToElement(clickSeleniumJava).click().perform();
        Thread.sleep(1000);
        WebElement actualText= driver.findElement(By.xpath("//h1"));
        String expectedText="Selenium-Java Tutorial – Basic to Advance";
        Assert.assertEquals(actualText.getText(),expectedText);
        Thread.sleep(1000);
        BrowserUtils.SwitchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame1");
        WebElement category1= driver.findElement(By.xpath("//a[.='Category1']"));
        Thread.sleep(2000);
        category1.click();
        BrowserUtils.SwitchByTitle(driver,"SeleniumTesting Archives - qavalidation");
        Assert.assertTrue(driver.getTitle().endsWith("qavalidation"));
        WebElement actualCategory= driver.findElement(By.xpath("//h1[.='Category Archives: SeleniumTesting']"));
        String expectedCategory="Category Archives: SeleniumTesting";
        Assert.assertEquals(actualCategory.getText(),expectedCategory);
        Thread.sleep(1000);
        BrowserUtils.SwitchByTitle(driver,"iframes");
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("Frame2");
        WebElement category3= driver.findElement(By.xpath("//a[.='Category3']"));
        Thread.sleep(2000);
        category3.click();
        Thread.sleep(1000);
        BrowserUtils.SwitchByTitle(driver,"SoftwareTesting Archives - qavalidation");
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://qavalidation.com/category/softwaretesting/";
        Assert.assertEquals(actualUrl,expectedUrl);
    }
}
