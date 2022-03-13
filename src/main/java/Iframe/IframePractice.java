package Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframePractice {

  @Test
  public void iframe(){

      WebDriverManager.chromedriver().setup();
      WebDriver driver=new ChromeDriver();
      driver.get("https://the-internet.herokuapp.com/iframe");
      driver.manage().window().maximize();
      driver.switchTo().frame("mce_0_ifr");
      WebElement text= driver.findElement(By.id("tinymce"));
      text.clear();
      text.sendKeys("I love Selenium");
      driver.switchTo().parentFrame();
      WebElement ActualText1= driver.findElement(By.xpath("//h3"));
      String expectedText1="An iFrame containing the TinyMCE WYSIWYG Editor";
      Assert.assertEquals(ActualText1.getText(),expectedText1);

  }
}
