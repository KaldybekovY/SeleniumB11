package com.test.orangehrm.tests;

public class DataProvider {
    @org.testng.annotations.DataProvider(name="LoginTest")
    public Object[][] getData(){
        return new Object[][]{
                {"admin1","admin123","Invalid credentials"},
                {"Admin2","Admin","Invalid credentials"},
        };
    }
}
