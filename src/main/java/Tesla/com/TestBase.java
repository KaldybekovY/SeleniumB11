package Tesla.com;

import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public WebDriver driver= DriverHelper.getDriver();;

    @BeforeMethod
    public void setup(){
        driver.get("https://www.tesla.com/");
    }

//    @AfterMethod
//    public void tearDown(){
//        DriverHelper.tearDown();
//    }
}
