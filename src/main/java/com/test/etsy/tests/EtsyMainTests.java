package com.test.etsy.tests;

import com.test.etsy.EtsyTestBase;
import com.test.etsy.pages.EtsyMainPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EtsyMainTests extends EtsyTestBase {

    @Parameters("item")

    @Test
    public void validateHeaders(String Iphone) throws InterruptedException {
        EtsyMainPage etsyMainPage=new EtsyMainPage(driver);
        etsyMainPage.setSearchBar(Iphone);
        Assert.assertTrue(etsyMainPage.validateHeader());
    }
}
