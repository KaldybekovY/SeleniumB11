package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HorizontalSlider {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement horizontal=driver.findElement(By.xpath("//h3"));
        System.out.println(horizontal.getText());

        WebElement text=driver.findElement(By.xpath("//h4"));
        System.out.println(text.getText());

        WebElement powered=driver.findElement(By.xpath("//a[@href='http://elementalselenium.com/']"));
        System.out.println(powered.getText());

        // CONTAINS: it works with text
        // tagname[contains(text(),'Horizontal Slide')]//

        WebElement elemental=driver.findElement(By.xpath("//a[contains(text(), 'Elemental Selenium')]"));
        System.out.println(elemental.getText());

        // Text: it works with text as well. This is easier than contains method. It looks for exact text
        //h3[.='text']
    }
}
