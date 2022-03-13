package Select;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiSelect {
    @Test
    public void multiSelectAndFirstSelectPractice(){

        WebDriver driver=new ChromeDriver();
        driver.navigate().to("file:///Users/ernur/Downloads/Techtorial%20(2).html");
        driver.manage().window().maximize();
        WebElement multiSelectBox= driver.findElement(By.xpath("//select[@class='select']"));
        BrowserUtils.SelectBy(multiSelectBox,"One","text");
        BrowserUtils.SelectBy(multiSelectBox,"3","index");
        BrowserUtils.SelectBy(multiSelectBox,"5","value");

        Select select=new Select(multiSelectBox);
        select.deselectAll();
        select.deselectByIndex(3);

        WebElement countryList= driver.findElement(By.name("country"));
        Select country=new Select(countryList);
       // String actualFirstSelectedOption=country.getFirstSelectedOption().getText().trim();
        String actualFirstSelectedOption=BrowserUtils.getTextMethod(country.getFirstSelectedOption());
        String expectedFirstSelectedOption="UNITED STATES";
        Assert.assertEquals(actualFirstSelectedOption,expectedFirstSelectedOption);

    }
}
