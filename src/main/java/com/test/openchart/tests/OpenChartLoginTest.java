package com.test.openchart.tests;

import com.test.openchart.pages.OpenChartLoginPage;
import com.test.orangehrm.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenChartLoginTest  extends TestBase {

    @Test
    public void ValidateTotalOrders () throws InterruptedException {
        OpenChartLoginPage openChartLoginPage=new OpenChartLoginPage(driver);
        openChartLoginPage.clickLoginBtn();
        Assert.assertEquals(openChartLoginPage.validateTotalOrders(),"12K");
        Assert.assertEquals(openChartLoginPage.validateTotalSales(),"11.8M");
        Assert.assertEquals(openChartLoginPage.validateTotalCustomers(),"144.8K");
    }
}
