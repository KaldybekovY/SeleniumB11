package Homework.HomeworkSauce;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestCase5 {
    @Test
    public void Test5(){
        /*
        Navigate to "https://demoqa.com/select-menu"
Select Group 2, option 1
Select Prof. and validate they are selected.

         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demoqa.com/select-menu");
        driver.manage().window().maximize();
        WebElement group= driver.findElement(By.xpath("<div class= css-1wa3eu0-placeholder>Select Option</div>"));
        Select select=new Select(group);
        select.selectByValue(" css-1uccc91-singleValue");
    }
}
