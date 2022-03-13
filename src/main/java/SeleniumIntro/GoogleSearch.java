package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    public static void main(String[] args) {
        WebDriver drive=new ChromeDriver();
        drive.get("https://www.google.com/");
        WebElement searchText=drive.findElement(By.name("btnK"));
        System.out.println(searchText.getAttribute("aria-label"));
        if(searchText.getAttribute("value").equals("Google Search")){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
    }
}
