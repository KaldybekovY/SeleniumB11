package NikitasMentoring.PageObjectModel.tests;

import NikitasMentoring.PageObjectModel.pages.VisitPage;
import NikitasMentoring.PageObjectModel.pages.homePage;
import NikitasMentoring.PageObjectModel.pages.optionsHeader.collectionPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test {
    public void scrollToElement(WebDriver driver, WebElement element) {

        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();

    }


    @org.testng.annotations.Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.nga.gov/");
        homePage homePAge=new homePage(driver);

        homePAge.chooseOptionMenu("collection");
        Thread.sleep(5000);

        collectionPage collectionPage=new collectionPage(driver);
        scrollToElement(driver,collectionPage.highlights.get(0));

        homePAge.chooseOptionMenu("visit");

        VisitPage visitPage=new VisitPage(driver);
        scrollToElement(driver,visitPage.promoContent.get(0));
    }
}
