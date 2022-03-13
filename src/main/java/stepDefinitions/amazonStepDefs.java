package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class amazonStepDefs {
    WebDriver driver;

    @When("I navigate to Amazon homepage")
    public void i_navigate_to_amazon_homepage() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
    }

    @When("I search for iphone 13 case")
    public void i_search_for_iphone_case() {
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone 13 case", Keys.ENTER);
    }

    @Then("i should get more than {int} results")
    public void i_should_get_more_than_results(Integer expectedCount) {
        List<WebElement> allLinks=driver.findElements(By.xpath("//h2"));
        Assert.assertTrue(allLinks.size()>expectedCount);
    }

    @And("I validate the search result number")
    public void i_validate_the_search_result_number() {
        WebElement validateResult= driver.findElement(By.xpath("//span[contains(text(),'1-16 of over 30,000 results for')]"));
        String [] resultsArr=validateResult.getText().trim().split(" ");
        int result=Integer.parseInt(resultsArr[3].replace(",",""));
        Assert.assertEquals(result,30000);
    }
}
