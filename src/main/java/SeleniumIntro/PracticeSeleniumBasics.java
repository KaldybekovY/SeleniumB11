package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;

public class PracticeSeleniumBasics {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        opt.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        opt.addArguments("disable-infobars");
        WebDriver driver=new ChromeDriver(opt);

        driver.get("http://uitestpractice.com/Students/Index");

        WebElement createNew=driver.findElement(By.xpath("//a[.='Create New']"));

        driver.navigate().to(createNew.getAttribute("href"));
    }
}
