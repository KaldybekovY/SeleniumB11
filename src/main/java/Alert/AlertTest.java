package Alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest {

    @Test
    public void JSAlert(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
        driver.manage().window().maximize();
        WebElement previewAlert= driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        previewAlert.click();
        Alert alert=driver.switchTo().alert();
        String actualPreview=alert.getText();
        String expectedPreview="Oops, something went wrong!";
        Assert.assertEquals(actualPreview,expectedPreview);
        alert.accept();
    }

    @Test
    public void HTMLAlert(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
        driver.manage().window().maximize();
        WebElement previewHTML= driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        Alert alert=driver.switchTo().alert();
        alert.accept();


    }

    @Test
    public void HTMLAlertWithInspection(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
        driver.manage().window().maximize();
        WebElement previewHTML= driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button"));
        previewHTML.click();
        WebElement htmlClick= driver.findElement(By.xpath("//button[.='OK']"));
        htmlClick.click();

    }
}
