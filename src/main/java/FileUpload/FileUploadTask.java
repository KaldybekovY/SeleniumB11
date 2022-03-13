package FileUpload;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTask {
    @Test
    public void Task() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demo.guru99.com/test/upload/");
        driver.manage().window().maximize();
        WebElement flag= driver.findElement(By.name("uploadfile_0"));
        flag.sendKeys("/Users/ernur/Desktop/Kazakhstan.png");
        WebElement acceptButton= driver.findElement(By.xpath("//input[@type='checkbox']"));
        acceptButton.click();
        Assert.assertTrue(acceptButton.isSelected());
        WebElement submitButton= driver.findElement(By.xpath("//button[@type='button']"));
        submitButton.click();
        Thread.sleep(3000);
        WebElement text = driver.findElement(By.xpath("//h3"));
        String actualText=BrowserUtils.getTextMethod(text);
        String expectedText="1 file\n" +
                "has been successfully uploaded.";
        Assert.assertEquals(actualText,expectedText);
    }
}
