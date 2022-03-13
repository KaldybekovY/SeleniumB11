package TESTNG;

import org.testng.annotations.DataProvider;

public class DataForNames {
    @DataProvider(name="NameTest")
    public Object[][] getData(){
        return new Object[][]{
                {"Eric","West","Eric West"},
                {"Eric","East","Eric East"},
                {"Eric","North","Eric North"},
                {"Eric","South","Eric South"},
                {"Alan","West","Alan West"},
                {"Greg","West","Greg West"},
                {"Enes","West","Enes West"},
        };
    }
}
