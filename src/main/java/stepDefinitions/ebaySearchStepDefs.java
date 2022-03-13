package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ebaySearchStepDefs {
    WebDriver driver;
    @Given("user is on ebay homepage")
    public void user_is_on_ebay_homepage() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.ebay.com/");
    }

    @When("user searches for iMac 2020")
    public void user_searches_for_i_mac() {
        WebElement searchBox= driver.findElement(By.xpath("//input[@id='gh-ac']"));
        searchBox.sendKeys("iMac 2020", Keys.ENTER);
    }

    @Then("user sees results about iMac only")
    public void user_sees_results_about_i_mac_only() {
        List<WebElement> allHeaders= driver.findElements(By.xpath("//ul//a//h3[@class='s-item__title']"));
        for (WebElement headers:allHeaders){
            Assert.assertTrue(headers.getText().trim().toLowerCase().contains("imac"));
        }
    }

    @Then("there are more than pages of results")
    public void there_are_more_than_pages_of_results(Integer expectedPages) {
        List<WebElement> allPages= driver.findElements(By.xpath("//ol[@class='pagination__items']//li"));
        Assert.assertTrue(allPages.size()>expectedPages);
    }
}
