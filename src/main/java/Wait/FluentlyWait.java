package Wait;

import Utils.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentlyWait {



    @Test
    public void fluentWaitTest() {

        WebDriver driver = DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeBtn = driver.findElement(By.xpath("//button[.='Remove']"));
        removeBtn.click();

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(2))
                .withMessage("Text on the page")
                .withTimeout(Duration.ofSeconds(10))
                .ignoring(Exception.class);

        WebElement message=fluentWait.until(driver1 -> driver.findElement(By.xpath("//p[@id='message']")));
        Assert.assertEquals(message.getText().trim(),"It's gone!");
    }
}

