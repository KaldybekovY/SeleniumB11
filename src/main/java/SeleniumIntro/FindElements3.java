package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElements3 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.yahoo.com/");
        driver.manage().window().maximize();
        WebElement news=driver.findElement(By.xpath("//a[@id='root_2']"));
        news.click();
        List<WebElement> allLists=driver.findElements(By.xpath("//h3"));
        int count=0;
        for(WebElement list:allLists){
            if(list.getText().contains("COVID")){
                System.out.println(list.getText());
                count++;
                }
            }
        System.out.println(count);
    }
}
