package TESTNG;

import org.testng.annotations.*;

public class TestNGAnnotations {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
        //you can use to setup your chrome Browser properties
        //(deletecookies)
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
        //You can use to launch your browser
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
        //You can navigate to the website
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
        //you can use it to login the page
    }
    @Test
    public void test1(){
        System.out.println("test-1");
        //You can take a screenshot for failed test annotations
        //Driver.quit();
    }
    @Test
    public void test2(){
        System.out.println("test-2");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }
    @AfterClass
    public void afterTest(){
        System.out.println("After Test");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }
}
