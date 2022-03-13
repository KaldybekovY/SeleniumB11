package Alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertIntro {
@Test
    public void JSBasicAlertTest(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    driver.manage().window().maximize();
    WebElement JSalert= driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
    JSalert.click();

//    WebElement header= driver.findElement(By.xpath("//h3"));
//    System.out.println(header.getText());

    Alert alert=driver.switchTo().alert();
    String actualText=alert.getText();
    String expectedText="I am a JS Alert";
    Assert.assertEquals(actualText,expectedText);
    alert.accept();
    WebElement actualSuccess= driver.findElement(By.xpath("//p[.='You successfully clicked an alert']"));
    String expectedSuccess="You successfully clicked an alert";
    Assert.assertEquals(actualSuccess.getText(),expectedSuccess);
    WebElement JSConfirm= driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
    JSConfirm.click();
    alert.dismiss();
    WebElement actualDismiss= driver.findElement(By.id("result"));
    String expectedDismiss="You clicked: Cancel";
    Assert.assertEquals(actualDismiss.getText(),expectedDismiss);
    WebElement JSPrompt= driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
    JSPrompt.click();
    alert.sendKeys("Eric");
    alert.accept();
    WebElement actualName= driver.findElement(By.xpath("//p[.='You entered: Eric']"));
    String expectedName="You entered: Eric";
    Assert.assertEquals(actualName.getText(),expectedName);

    }
}
