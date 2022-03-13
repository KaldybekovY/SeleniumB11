package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.auxiliary.MethodCallProxy;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ActionClassMethods {


    //ContextClick()-->right click
    @Test
    public void ContextClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        WebElement contextMenu= driver.findElement(By.partialLinkText("Context"));
        contextMenu.click();
        WebElement box= driver.findElement(By.id("hot-spot"));
        Actions actions=new Actions(driver);
        // In action class you must use perform() at the end.
        actions.contextClick(box);
        actions.perform();

    }
    @Test
    public void HoverOver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement hoverOver=driver.findElement(By.linkText("Hovers"));
        hoverOver.click();
        Thread.sleep(2000);
        Actions actions=new Actions(driver);
        List<WebElement> names= driver.findElements(By.xpath("h5"));
        List<WebElement> pictures= driver.findElements(By.xpath("//div[@class='figure']//img"));
        List<String> expectedNames= Arrays.asList("name: user1","name: user2","name: user3");
        for(int i=0;i< names.size();i++){
            Thread.sleep(2000);
            actions.moveToElement(pictures.get(i)).perform();
            Assert.assertEquals(BrowserUtils.getTextMethod(names.get(i)),expectedNames.get(i));

        }

    }
    @Test
    public void DoubleClick(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        driver.manage().window().maximize();
        WebElement doubleClickButton= driver.findElement(By.xpath("//button"));
        Actions actions=new Actions(driver);
      //  actions.doubleClick(doubleClickButton).perform();
        WebElement rightClick= driver.findElement(By.xpath("//span[.='right click me']"));
        actions.doubleClick(rightClick).perform();
    }
    @Test
    public void DoubleClickTask(){
        /*
        //TASK FOR STUDENTS
        /*
        Scenario to Automate:
1. Launch the Chrome web browser.
2. Open a URL "https://selenium08.blogspot.com/2019/11/double-click.html".
3. Locate the element "Double-click".
4.  click on the current location (i.e. on Double-click element).
5. Close the web browser.
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://selenium08.blogspot.com/2019/11/double-click.html");
        driver.manage().window().maximize();
        WebElement doubleClick= driver.findElement(By.xpath("//button[.='Double-Click me to see Alert message']"));
        Actions actions=new Actions(driver);
        actions.doubleClick(doubleClick).perform();
        driver.quit();
    }

    @Test
    public void draAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.manage().window().maximize();
        WebElement cookie=driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        Thread.sleep(1000);
        cookie.click();
        Actions actions=new Actions(driver);
//        for (int i = 0; i < 5; i++) {
//            actions.sendKeys(Keys.ARROW_DOWN).perform();
//        }
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement yellowBox = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualMessage = BrowserUtils.getTextMethod(yellowBox);
        String expectedMessage = "... Or here.";
        Assert.assertEquals(actualMessage, expectedMessage);
        actions.dragAndDrop(draggable,yellowBox).perform();
        Thread.sleep(3000);
        WebElement yellowBox1 = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualAfterDragAndDrop=BrowserUtils.getTextMethod(yellowBox1);
        String expectedAfterDragAndDrop="You did great!";
        Assert.assertEquals(actualAfterDragAndDrop,expectedAfterDragAndDrop);

        String ActualCSSValue=yellowBox.getCssValue("background-color");
        String expectedCSSValue="rgba(238, 111, 11, 1)";
        Assert.assertEquals(ActualCSSValue,expectedCSSValue);
    }


    @Test
    public void ClickAndHold() throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.manage().window().maximize();
        WebElement blueBox= driver.findElement(By.xpath("//div[.='Drag the small circle here ...']"));
        String actualBlueBoxMessage=BrowserUtils.getTextMethod(blueBox);
        String expectedBlueBoxMessage ="Drag the small circle here ...";
        Assert.assertEquals(actualBlueBoxMessage,expectedBlueBoxMessage);
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions=new Actions(driver);
        Thread.sleep(2000);
        actions.clickAndHold(draggable).moveToElement(blueBox).release().build();
    }

    @Test
    public void DragAndDropPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/droppable");
        driver.manage().window().maximize();
        WebElement draggable= driver.findElement(By.xpath("//div[.='Drag me']"));
        WebElement box= driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(draggable,box).perform();
        String actualBox=BrowserUtils.getTextMethod(box);
        String expectedBox="Drop here";
    }

    @Test
    public void ClickAndHoldPractice() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/droppable");
        driver.manage().window().maximize();

        WebElement acceptButton= driver.findElement(By.xpath("//a[.='Accept']"));
        acceptButton.click();

        WebElement clickAcceptable= driver.findElement(By.xpath("//div[.='Acceptable']"));
        WebElement box= driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[2]"));
        Actions actions=new Actions(driver);
        Thread.sleep(2000);
        actions.clickAndHold(clickAcceptable).moveToElement(box).release().perform();

        String ActualCSSValue=box.getCssValue("background-color");
        String ExpectedCSSValue="rgba(70, 130, 180, 1)";
        Assert.assertEquals(ActualCSSValue,ExpectedCSSValue);
        Thread.sleep(1000);
        WebElement nonAcceptable = driver.findElement(By.id("notAcceptable"));
        actions.clickAndHold().release().perform();
        actions.dragAndDrop(nonAcceptable,box).perform();
        Thread.sleep(1000);
        String actualMessage = box.getText().trim();
        String expectedMessage = "Dropped!";
        Assert.assertEquals(actualMessage,expectedMessage);

    }
}
