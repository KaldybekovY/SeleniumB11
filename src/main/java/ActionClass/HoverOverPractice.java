package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HoverOverPractice {
    @Test
    public void practiceHoverOver() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.edureka.co/?utm_source=Google-Search-Brand&utm_medium=cpc&utm_campaign=Brand-Search-US&gclid=Cj0KCQiAmKiQBhClARIsAKtSj-ku-6DUVkzlg14zjObBXS8K8gahi0RG92R6HMG-wL8MfxPf9wSo5HkaAjo2EALw_wcB");
        WebElement browser = driver.findElement(By.xpath("//a[@class='dropdown-toggle hidden-xs hidden-sm ga_browse_top_cat']"));
        Actions action = new Actions(driver);
        action.moveToElement(browser).perform();
        WebElement dataScience = driver.findElement(By.xpath("//a[@class='dropdown-toggle ga_top_category' and .='Data Science']"));
        action.moveToElement(dataScience).perform();
        // browser-->CyberSecurity-->validate three names
    }

    @Test
    public void PlanBpractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");
        driver.manage().window().maximize();
        List<WebElement> pictures = driver.findElements(By.xpath("//div[@role='listitem']"));
        List<WebElement> allPrices = driver.findElements(By.xpath("//div[@class='product-description']//p"));
        List<Double> prices = new ArrayList<>();
        Actions actions = new Actions(driver);
        for (int i = 0; i < pictures.size(); i++) {
            Thread.sleep(1000);
            actions.moveToElement(pictures.get(i)).perform();
            prices.add(Double.parseDouble(allPrices.get(i).getText().trim().replace("$", "")));
        }
        Collections.sort(prices);
        System.out.println(prices.get(1));
        Collections.reverse(prices);
        System.out.println(prices);
    }
}
