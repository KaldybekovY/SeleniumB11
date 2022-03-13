package Tesla.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeslaMainPage {

    public TeslaMainPage(WebDriver driver){ PageFactory.initElements(driver,this);}

    @FindBy(xpath = "//span[.='Shop']")
    WebElement shopBtn;

    @FindBy(xpath = "//a[.='Apparel']")
    WebElement apparelBtn;



    public void setApparelBtn() throws InterruptedException {

        Thread.sleep(1000);
        shopBtn.click();
        Thread.sleep(1000);
        apparelBtn.click();

    }
}
