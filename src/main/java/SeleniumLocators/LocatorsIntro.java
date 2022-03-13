package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/ernur/Downloads/Techtorial%20(2).html");
        //getText()-->it gives you the text of the element
        WebElement header = driver.findElement(By.id("techtorial1"));
        String actualText = header.getText();//from the system
        String expectedText = "Techtorial Academy";// from the business requirement
        if (actualText.equals(expectedText)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        WebElement paragraph=driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());
        String actualText1=paragraph.getText();
        if(actualText1.equals("To create your account, \\n\" +\n" +
                "                \"        we'll need some basic information about you. This information will be \\n\" +\n" +
                "                \"        used to send reservation confirmation emails, mail tickets when needed \\n\" +\n" +
                "                \"        and contact you if your travel arrangements change. Please fill in the \\n\" +\n" +
                "                \"        form completely.")){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        WebElement tools=driver.findElement(By.className("group_checkbox"));
        System.out.println(tools.getText());

        // Locator: Name

        WebElement name=driver.findElement(By.name("firstName"));
        name.sendKeys("Eric");

        WebElement lastName=driver.findElement(By.name("lastName"));
        lastName.sendKeys("Kaldybekov");

        WebElement phone=driver.findElement(By.name("phone"));
        phone.sendKeys("3053958286");

        WebElement email=driver.findElement(By.name("userName"));
        email.sendKeys("kaldybekov.91@gmail.com");

        WebElement javaBox=driver.findElement(By.id("cond1"));
        javaBox.click();
        System.out.println(javaBox.isDisplayed());//return true or false
        System.out.println(javaBox.isSelected());//return true or false

        WebElement testNg=driver.findElement(By.id("cond3"));
        testNg.click();
        System.out.println(testNg.isSelected());
        System.out.println(testNg.isDisplayed());

        WebElement cucumber=driver.findElement(By.id("cond4"));
        cucumber.click();
        System.out.println(cucumber.isSelected());
        System.out.println(cucumber.isDisplayed());


    }
}
