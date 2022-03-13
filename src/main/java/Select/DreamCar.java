package Select;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.PublicKey;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DreamCar {
    @Test
    public void Bugatti() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.cars.com/");
        driver.manage().window().maximize();
        WebElement bugatti= driver.findElement(By.xpath("//select[@data-activitykey='make']"));
        bugatti.sendKeys("Bugatti");
        WebElement search= driver.findElement(By.xpath("//button[contains(text(), 'Search')]"));
        search.click();
        WebElement header= driver.findElement(By.xpath("//h1"));
        String actualHeader= BrowserUtils.getTextMethod(header);
        String expectedHeader="New and used Bugatti for sale";
        Assert.assertEquals(actualHeader,expectedHeader);
        List<WebElement> allCars = driver.findElements(By.xpath("//h2[@class='title']"));
        Set<String> actualCar = new LinkedHashSet<>();
        Set<String> expectedCar = new TreeSet<>();
        boolean check=true;
        int count=0;
        for (WebElement car : allCars) {
            if(car.getText().contains("Bugatti")){
                System.out.println(car.getText());
                count++;
            }
            actualCar.add(car.getText().trim());
            expectedCar.add(car.getText().trim());
            Assert.assertEquals(actualCar, expectedCar);
            }
        System.out.println(count);
        }
    }

