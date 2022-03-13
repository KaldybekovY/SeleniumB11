package Select;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Example {
    @Test
    public void ValidationTripButton(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        driver.manage().window().maximize();
        WebElement oneWay= driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWay.click();
        Assert.assertTrue(oneWay.isDisplayed());//it must be true to pass the assertion
        Assert.assertTrue(oneWay.isSelected());
//        Select One=new Select(oneWay);
//        One.selectByValue("oneway");
        WebElement roundTrip= driver.findElement(By.xpath("//input[@value='roundtrip']"));
        Assert.assertFalse(roundTrip.isSelected());
        Assert.assertTrue(roundTrip.isDisplayed());
    }
    @Test
    public void SelectMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        driver.manage().window().maximize();
        WebElement oneWay= driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWay.click();
        WebElement passengerCount= driver.findElement(By.name("passCount"));
        Select psgr=new Select(passengerCount);
        psgr.selectByIndex(1);
        WebElement depart= driver.findElement(By.name("fromPort"));
        Select dpt=new Select(depart);
        dpt.selectByValue("Paris");
        WebElement on= driver.findElement(By.name("fromMonth"));
        Select on1=new Select(on);
        on1.selectByIndex(1);
        WebElement arrival= driver.findElement(By.name("toPort"));
        Select arrival1=new Select(arrival);
        arrival1.selectByValue("New York");
        WebElement month= driver.findElement(By.name("toMonth"));
        Select month1=new Select(month);
        month1.selectByIndex(3);
        WebElement business= driver.findElement(By.xpath("//input[@value='Business']"));
        business.click();
        WebElement airline= driver.findElement(By.name("airline"));
        Select airline1=new Select(airline);
        airline1.selectByVisibleText("Blue Skies Airlines");
        WebElement contin= driver.findElement(By.xpath("//input[@name='findFlights']"));
        contin.click();
        WebElement header= driver.findElement(By.xpath("//font[@face='Arial, Helvetica, sans-serif']//font[@size='4']"));
        String ActualHeader=header.getText();
        String ExpectedHeader="After flight finder - No Seats Avaialble  ";
        Assert.assertEquals(ActualHeader,ExpectedHeader);
    }
    @Test
    public void SecondWay(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        driver.manage().window().maximize();
        WebElement oneWay= driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWay.click();
        WebElement passengerCount= driver.findElement(By.name("passCount"));
        BrowserUtils.SelectBy(passengerCount,"2","value");
        WebElement depart= driver.findElement(By.name("fromPort"));
        BrowserUtils.SelectBy(depart,"Paris","text");
//        Select dpt=new Select(depart);
//        dpt.selectByValue("Paris");
        WebElement on= driver.findElement(By.name("fromMonth"));
        BrowserUtils.SelectBy(on,"1","index");
//        Select on1=new Select(on);
//        on1.selectByIndex(1);
        WebElement arrival= driver.findElement(By.name("toPort"));
        BrowserUtils.SelectBy(arrival,"New York","value");
//        Select arrival1=new Select(arrival);
//        arrival1.selectByValue("New York");
        WebElement month= driver.findElement(By.name("toMonth"));
        BrowserUtils.SelectBy(month,"3","index");
//        Select month1=new Select(month);
//        month1.selectByIndex(3);
        WebElement business= driver.findElement(By.xpath("//input[@value='Business']"));
        business.click();
        WebElement airline= driver.findElement(By.name("airline"));
        BrowserUtils.SelectBy(airline,"Blue Skies Airlines","text");
//        Select airline1=new Select(airline);
//        airline1.selectByVisibleText("Blue Skies Airlines");
        WebElement contin= driver.findElement(By.xpath("//input[@name='findFlights']"));
        contin.click();
        WebElement header= driver.findElement(By.xpath("//font[@face='Arial, Helvetica, sans-serif']//font[@size='4']"));
        String ActualHeader=header.getText();
        String ExpectedHeader="After flight finder - No Seats Avaialble  ";
        Assert.assertEquals(ActualHeader,ExpectedHeader);
    }
}
