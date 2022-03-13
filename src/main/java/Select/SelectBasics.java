package Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class SelectBasics {
    @Test
    public void practice1(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        WebElement dropDown=driver.findElement(By.linkText("Dropdown"));
        dropDown.click();
        WebElement optionBox=driver.findElement(By.xpath("//select[@id='dropdown']"));
        //optionBox.sendKeys("Option 1");
        Select option=new Select(optionBox);//provide webElement location
        //option.selectByVisibleText("Option 1");
        //option.selectByIndex(0);
        option.selectByValue("2");
        List<WebElement> options=option.getOptions();
        for(WebElement Option:options){
            System.out.println(Option.getText().trim());
        }
    }
}
