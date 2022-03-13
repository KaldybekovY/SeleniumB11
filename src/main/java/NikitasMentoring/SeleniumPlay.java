package NikitasMentoring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SeleniumPlay {

    public static void playNotes(String[] notes, HashMap<String,WebElement> instrument) throws InterruptedException {

        for (String note:notes){
            instrument.get(note).click();
            Thread.sleep(500);
        }

    }


    @Test
    public void MusicPlay() throws InterruptedException {

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.musicca.com/piano");
        driver.manage().window().maximize();

        List<WebElement> whiteKeys= driver.findElements(By.xpath("//span[@data-key]"));

        HashMap<String, WebElement> keyboard=new HashMap<>();

        for (WebElement key:whiteKeys){

            keyboard.put(key.getAttribute("data-note"),key);

        }

//        String[] test={"2g","2g","2e","2e","2d"};

        String [] surprise = {"2g","2g","2g","2d","2e","2e","2d","3b","3b","3a","3a","2g"};

        playNotes(surprise,keyboard);

//        for(WebElement note:keyboard.values()){
//
//            note.click();
//
//        }

//        List<WebElement> blackKeys= driver.findElements(By.xpath("//span[@class='black-key']"));
//
//        Map<WebElement, String> whiteKeysMap=new LinkedHashMap<>();
//        Map<WebElement, String> blackKeysMap=new LinkedHashMap<>();


        Thread.sleep(1000);

        driver.quit();
    }
}
