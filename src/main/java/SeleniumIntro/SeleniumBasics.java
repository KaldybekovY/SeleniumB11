package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {

    public static void main(String[] args) {
        // 1. We need to define the chrome driver into the project as a property
        System.setProperty("webdriver.chrome.driver","chromedriver");
        // 2. We need to instantiate or declare our driver
        WebDriver driver = new ChromeDriver();
        /*
        Where do you use polymorphism in your testing framework?
        I use it to instantiate my driver.example
        WebDriver driver=new ChromeDriver();
        Can you instantiate your driver like
        WebDriver driver = new WebDriver();
        // First method:
        get method()
         */
        driver.get("https://www.techtorialacademy.com/");
        // getTitle()-->get the title of the page.
        String title=driver.getTitle();
        System.out.println(title);
        if(title.equals("Home Page - Techtorial")){
            System.out.println("Your test is passed");
        }else{
            System.out.println("Your test is failed");
        }
        String actual=driver.getCurrentUrl();
        String expected="https://www.techtorialacademy.com/";
        if(actual.equals(expected)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

    }

}
