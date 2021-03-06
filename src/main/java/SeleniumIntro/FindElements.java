package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElements {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        WebElement abtesting=driver.findElement(By.linkText("ng"));
        System.out.println(abtesting.getText());
        List<WebElement> allLists=driver.findElements(By.xpath("//li/a"));
        int count=0;
        for(WebElement list:allLists){
            if(list.getText().length()<=12){
                System.out.println(list.getText());
                count++;
            }
        }
        System.out.println(count);
        // can you find only the links that its size less than 12 and count how many we have
        }
    }
