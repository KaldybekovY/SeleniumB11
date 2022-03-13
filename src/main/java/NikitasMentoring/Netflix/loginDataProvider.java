package NikitasMentoring.Netflix;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class loginDataProvider {
    WebDriver driver;
    @Test(dataProvider = "data_for_login")

    public void loginNetflix(String login, String password) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get("https://www.netflix.com/login");

        //send info to name
        driver.findElement(By.xpath("//input[@name='userLoginId']")).sendKeys(login);
        //send info to password
        driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys(password);

        //submit button
        driver.findElement(By.xpath("//button[@type='submit' and @data-uia='login-submit-button']")).click();

        System.out.println("Username is "+login );
        System.out.println("Password is "+password );

        Thread.sleep(5000);
        driver.quit();

    }

    @DataProvider (name="data_for_login")
    public Object[][] dataForLogin () {
        Object [][] loginData= new Object[4][2];

        loginData[0][0] = "LoginOne";
        loginData[0][1] = "PasswordOne";

        loginData[1][0] = "LoginTwo";
        loginData[1][1] = "PasswordTwo";

        loginData[2][0] = "LoginThree";
        loginData[2][1] = "PasswordThree";

        loginData[3][0] = "LoginFour";
        loginData[3][1] = "PasswordFour";

        return loginData;

    }


    public static class loginParameter {
        WebDriver driver;

        @Test
        @Parameters({"email","pass","test"})
        public void loginNetflix(String email, String pass,String test) throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://www.netflix.com/login");


            //send info to name
            driver.findElement(By.xpath("//input[@name=\"userLoginId\"]")).sendKeys(email);
            //send info to password
            driver.findElement(By.xpath("//input[@id=\"id_password\"]")).sendKeys(pass);

            //submit button
            driver.findElement(By.xpath("//button[@type=\"submit\" and @data-uia=\"login-submit-button\"]")).click();

            System.out.println("Username is "+email );
            System.out.println("Password is "+pass );
            System.out.println(test);

            Thread.sleep(5000);
            driver.quit();



        }




    }
}
