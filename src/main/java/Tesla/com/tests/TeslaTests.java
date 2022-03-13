package Tesla.com.tests;

import Tesla.com.TestBase;
import Tesla.com.pages.TeslaMainPage;
import com.test.audiusa.pages.AudiMainPage;
import org.testng.annotations.Test;

public class TeslaTests extends TestBase {

    @Test
    public void TeslaTestCase1() throws InterruptedException {

        TeslaMainPage teslaMainPage=new TeslaMainPage(driver);
        teslaMainPage.setApparelBtn();

    }
}
