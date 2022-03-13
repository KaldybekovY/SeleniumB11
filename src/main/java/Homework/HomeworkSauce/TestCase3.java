package Homework.HomeworkSauce;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class TestCase3 {
    /*
Steps
Navigate to "https://www.saucedemo.com/"
Enter username "standard_user"
Enter password "secret_sauce"
Click Login button
Find the cheapest two product on the page
Add them to the cart
Click cart button
Validate these two products is added to the cart
     */
    @Test
    public void TestCase3(){
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
        List<WebElement> allPrices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<Double> twoCheapest=new ArrayList<>();
        for (int i = 0; i < allPrices.size(); i++) {
            twoCheapest.add(Double.parseDouble(allPrices.get(i).getText().trim().replace("$","")));
        }
        System.out.println(twoCheapest.get(0));
        System.out.println(twoCheapest.get(1));
        WebElement cheapest= driver.findElement(By.name("add-to-cart-sauce-labs-onesie"));
        cheapest.click();
        WebElement secondCheapest= driver.findElement(By.name("add-to-cart-sauce-labs-bike-light"));
        secondCheapest.click();
        WebElement shoppingCart= driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        shoppingCart.click();
        List<WebElement> twoProducts= driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> actualProducts=new LinkedList<>();
        List<String> expectedProducts=new ArrayList<>();
        for(WebElement products:twoProducts){
            actualProducts.add(products.getText().trim());
            expectedProducts.add(products.getText().trim());
        }
        Assert.assertEquals(actualProducts,expectedProducts);
    }
   }

