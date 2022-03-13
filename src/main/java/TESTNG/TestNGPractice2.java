package TESTNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class TestNGPractice2 {
    @Test
    public void validateToAcsendingOrder() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement logIn = driver.findElement(By.xpath("//button[@type='submit']"));
        logIn.click();
        WebElement catalogBar = driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        WebElement optionButton = driver.findElement(By.xpath("//a[.='Options']"));
        Thread.sleep(500);
        optionButton.click();
        WebElement optionName = driver.findElement(By.xpath("//a[.='Options']"));
        Thread.sleep(500);
        optionName.click();
        List<WebElement> allOptions = driver.findElements(By.xpath("//tbody/tr/td[2]"));
        Set<String> actualOptionsOrder = new LinkedHashSet<>();//from website
        Set<String> expectedOptionsOrder = new TreeSet<>();//ascending order
        for (WebElement option : allOptions) {
            actualOptionsOrder.add(option.getText().trim());
            expectedOptionsOrder.add(option.getText().trim());
            Assert.assertEquals(actualOptionsOrder, expectedOptionsOrder);
        }
    }

    @Test
    public void validationOfDescendingOrderOptions() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement logIn = driver.findElement(By.xpath("//button[@type='submit']"));
        logIn.click();
        WebElement catalogBar = driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        WebElement optionButton = driver.findElement(By.xpath("//a[.='Options']"));
        Thread.sleep(500);
        optionButton.click();
        WebElement optionName = driver.findElement(By.xpath("//a[.='Option Name']"));
        optionName.click();
        List<WebElement> allOptions = driver.findElements(By.xpath("//tbody/tr/td[2]"));
        List<String> actualDescendingOptionsOrder = new LinkedList<>();//from website
        List<String> expectedDescendingOptionsOrder = new ArrayList<>();//descending order
        for (WebElement option : allOptions) {
            actualDescendingOptionsOrder.add(option.getText().trim());
            expectedDescendingOptionsOrder.add(option.getText().trim());
            Collections.sort(expectedDescendingOptionsOrder);
            Collections.reverse(expectedDescendingOptionsOrder);
        }
        Assert.assertEquals(actualDescendingOptionsOrder, expectedDescendingOptionsOrder);
    }

    // validate sort order(ascending and descending)
    @Test
    public void AscendingOrderOfSort() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement logIn = driver.findElement(By.xpath("//button[@type='submit']"));
        logIn.click();
        WebElement catalogBar = driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        WebElement optionButton = driver.findElement(By.xpath("//a[.='Options']"));
        Thread.sleep(500);
        optionButton.click();
        WebElement sortButton = driver.findElement(By.xpath("//a[contains(text(),'Sort Order')]"));
        sortButton.click();
        List<WebElement> allSorts = driver.findElements(By.xpath("//tbody/tr/td[3]"));
        Set<String> actualSortsOrder = new LinkedHashSet<>();//from website
        Set<String> expectedSortsOrder = new TreeSet<>();//ascending order
        for (WebElement sort : allSorts) {
            actualSortsOrder.add(sort.getText().trim());
            expectedSortsOrder.add(sort.getText().trim());
            Assert.assertEquals(actualSortsOrder, expectedSortsOrder);
        }
    }

    @Test
    public void DescendingOrderOfSort() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement logIn = driver.findElement(By.xpath("//button[@type='submit']"));
        logIn.click();
        WebElement catalogBar = driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        WebElement optionButton = driver.findElement(By.xpath("//a[.='Options']"));
        Thread.sleep(500);
        optionButton.click();
        WebElement sortButton = driver.findElement(By.xpath("//a[contains(text(),'Sort Order')]"));
        sortButton.click();
        List<WebElement> allSorts = driver.findElements(By.xpath("//tbody/tr/td[3]"));
        List<String> actualDescendingOptionsOrder = new LinkedList<>();//from website
        List<String> expectedDescendingOptionsOrder = new ArrayList<>();//descending order
        for (WebElement sort : allSorts) {
            actualDescendingOptionsOrder.add(sort.getText().trim());
            expectedDescendingOptionsOrder.add(sort.getText());
            Collections.sort(expectedDescendingOptionsOrder);
            Collections.reverse(expectedDescendingOptionsOrder);
            Assert.assertEquals(actualDescendingOptionsOrder, expectedDescendingOptionsOrder);
        }

    }
}
