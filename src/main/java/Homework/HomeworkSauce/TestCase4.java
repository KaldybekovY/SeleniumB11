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
import java.util.LinkedList;
import java.util.List;

public class TestCase4 {
    /*
    Steps
Navigate to "https://www.saucedemo.com/"
Enter username "standard_user"
Enter password "secret_sauce"
Click Login button
Find the highest priced two product on the page
Add them to the cart
Click cart button
Click CheckOut Button
Fill out First Name, Last Name and Zip Code
Click continue button
Validate Item total price is equals to total price of
selected product
Validate Total is equals to Item Total price plus Tax
amount
Validate the Url contains "checkout"
Click finish button
Validate "THANK YOU FOR YOUR ORDER" message is
displayed
     */
    @Test
        public void TestCase4() {
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
        BrowserUtils.SelectBy(select, "hilo", "value");
        List<WebElement> allPrices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<Double> twoHighest = new ArrayList<>();
        for (int i = 0; i < allPrices.size(); i++) {
            twoHighest.add(Double.parseDouble(allPrices.get(i).getText().trim().replace("$", "")));
        }
        System.out.println(twoHighest.get(0));
        System.out.println(twoHighest.get(1));
        WebElement highest = driver.findElement(By.name("add-to-cart-sauce-labs-fleece-jacket"));
        highest.click();
        WebElement secondHighest = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        secondHighest.click();
        WebElement shoppingCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        shoppingCart.click();
        WebElement checkOut= driver.findElement(By.xpath("//button[.='Checkout']"));
        checkOut.click();
        WebElement firstName= driver.findElement(By.name("firstName"));
        firstName.sendKeys("Eric");
        WebElement lastName= driver.findElement(By.name("lastName"));
        lastName.sendKeys("Eric");
        WebElement zipCode= driver.findElement(By.name("postalCode"));
        zipCode.sendKeys("60515");
        WebElement Continue= driver.findElement(By.name("continue"));
        Continue.click();
        WebElement Total= driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));
        String actualTotal=BrowserUtils.getTextMethod(Total);
        String expectedTotal="Item total: $79.98";
        Assert.assertEquals(actualTotal,expectedTotal);
        WebElement TotalPlusTax=driver.findElement(By.xpath("//div[@class='summary_total_label']"));
        String actualTotalPlusTax=BrowserUtils.getTextMethod(TotalPlusTax);
        String expectedTotalPlusTax="Total: $86.38";
        Assert.assertEquals(actualTotalPlusTax,expectedTotalPlusTax);
        String ActualUrl=driver.getCurrentUrl();
        String ExpectedUrl="https://www.saucedemo.com/checkout-step-two.html";
        if(ActualUrl.contains("checkout")){
            Assert.assertEquals(ActualUrl,ExpectedUrl);
        }
        WebElement finish= driver.findElement(By.name("finish"));
        finish.click();
        WebElement thankYou= driver.findElement(By.xpath("//h2[.='THANK YOU FOR YOUR ORDER']"));
        String actualTY=BrowserUtils.getTextMethod(thankYou);
        String expectedTY="THANK YOU FOR YOUR ORDER";
        Assert.assertEquals(actualTY,expectedTY);
    }
}
