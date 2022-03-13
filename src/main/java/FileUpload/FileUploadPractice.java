package FileUpload;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadPractice {
    @Test
    public void FileUpload(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        WebElement flag= driver.findElement(By.id("file-upload"));
        flag.sendKeys("/Users/ernur/Desktop/Kazakhstan.png");
        WebElement uploadButton= driver.findElement(By.id("file-submit"));
        uploadButton.click();
        WebElement message1= driver.findElement(By.tagName("h3"));
        String actualMessage1= BrowserUtils.getTextMethod(message1);
        String expectedMessage1="File Uploaded!";
        WebElement message2= driver.findElement(By.id("uploaded-files"));
        String actualMessage2=BrowserUtils.getTextMethod(message2);
        String expectedMessage2="Kazakhstan.png";
        Assert.assertEquals(actualMessage2,expectedMessage2);
    }
}
