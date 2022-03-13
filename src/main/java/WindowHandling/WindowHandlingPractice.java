package WindowHandling;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowHandlingPractice {
    @Test
    public void WindowHandling() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.manage().window().maximize();
        WebElement tabFour=driver.findElement(By.id("newTabsBtn"));
        tabFour.click();
        BrowserUtils.SwitchByTitle(driver,"Basic Controls");
        String actualBasic = driver.getTitle();
        String expectedBasic ="Basic Controls - H Y R Tutorials";
        Assert.assertEquals(actualBasic,expectedBasic);
        WebElement fName=driver.findElement(By.id("firstName"));
        fName.sendKeys("Eric");
        WebElement lName=driver.findElement(By.id("firstName"));
        lName.sendKeys("West");
        WebElement language=driver.findElement(By.id("englishchbx"));
        language.click();
        WebElement email=driver.findElement(By.xpath("//input[@placeholder='Enter Email']"));
        email.sendKeys("kaldybekov.91@yahoo.com");
        WebElement password=driver.findElement(By.xpath("//input[@placeholder='Enter Password']"));
        password.sendKeys("Password123");
        WebElement register= driver.findElement(By.xpath("//button[.='Register']"));
        register.click();
        WebElement actualRegister= driver.findElement(By.xpath("//label[.='Registration is Successful']"));
        String expectedRegister="Registration is Successful";
        Assert.assertEquals(actualRegister.getText(),expectedRegister);
        BrowserUtils.SwitchByTitle(driver, "AlertsDemo");
        WebElement alert= driver.findElement(By.id("alertBox"));
        alert.click();
        Thread.sleep(2000);
        driver.quit();

    }
}


