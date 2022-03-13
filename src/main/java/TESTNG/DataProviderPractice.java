package TESTNG;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

//    @DataProvider(name="NameTest")
//    public Object[][] getData(){
//        return new Object[][]{
//                {"Eric","West","Eric West"},
//                {"Eric","East","Eric East"},
//                {"Eric","North","Eric North"},
//                {"Eric","South","Eric South"},
//                {"Alan","West","Alan West"},
//                {"Greg","West","Greg West"},
//                {"Enes","West","Enes West"},
//        };
//    }

    @Test(dataProvider = "NameTest",dataProviderClass = DataForNames.class)
    public void test(String username, String lastname, String expectedfullName){
        String userName=username;
        String lastName=lastname;
        String fullName=username+" "+lastname;
        Assert.assertEquals(fullName,expectedfullName);
    }

//    @Test
//    public void test1(){
//        String username="Eric";
//        String lastname="East";
//        String fullName=username+" "+lastname;
//        Assert.assertEquals(fullName,"Eric East");
//    }
//
//    @Test
//    public void test2(){
//        String username="Eric";
//        String lastname="North";
//        String fullName=username+" "+lastname;
//        Assert.assertEquals(fullName,"Eric North");
//    }
//
//    @Test
//    public void test3(){
//        String username="Eric";
//        String lastname="South";
//        String fullName=username+" "+lastname;
//        Assert.assertEquals(fullName,"Eric South");
//    }
//
//    @Test
//    public void test4(){
//        String username="Alan";
//        String lastname="West";
//        String fullName=username+" "+lastname;
//        Assert.assertEquals(fullName,"Alan West");
//    }
//
//    @Test
//    public void test5(){
//        String username="Greg";
//        String lastname="West";
//        String fullName=username+" "+lastname;
//        Assert.assertEquals(fullName,"Greg West");
//    }
//
//    @Test
//    public void test6(){
//        String username="Enes";
//        String lastname="West";
//        String fullName=username+" "+lastname;
//        Assert.assertEquals(fullName,"Enes West");
//    }
}
