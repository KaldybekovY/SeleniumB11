package Homework.HomeworkSauce;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestCase2 {
    @Test
    public void TestCase2() {

        /*
        Steps:
Navigate to "https://www.saucedemo.com/"
Enter username "standard_user"
Enter password "secret_sauce"
Click Login button
Select Price (low-high) from drop down box
Validate the products are displayed according to their price
and they are displayed low price to high price
Steps
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement passWord = driver.findElement(By.id("password"));
        passWord.sendKeys("secret_sauce");
        WebElement logIn = driver.findElement(By.name("login-button"));
        logIn.click();
        WebElement select = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        BrowserUtils.SelectBy(select, "lohi", "value");
        List<WebElement> allProducts = driver.findElements(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div"));
        List<String> actualProducts = new LinkedList<>();
        List<String> expectedProducts = new ArrayList<>();
        for (WebElement products : allProducts) {
            actualProducts.add(products.getText().trim());
            expectedProducts.add(products.getText().trim());
        }
        Assert.assertEquals(actualProducts, expectedProducts);
    }
}
