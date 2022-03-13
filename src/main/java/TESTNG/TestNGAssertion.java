package TESTNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertion {

    //create one method that takes two parameter and return the multiplication of these number


    public int result(int a, int b){
        int result=a*b;
        return result;
    }

    public double getDivision(int a, int b){
        if(a>=b){
            return a/b;
        }
        return b/a;
    }

    @Test
    public void validateMultiplication(){

        double ActualResult=result(5,6);
        double ExpectedResult=30;

        Assert.assertEquals(ActualResult,ExpectedResult, "my numbers are 5 and 6");//message will show up when it fails

    }
    public int Substraction(int a, int b){
        if(a>=b){
            return a-b;
        }
        return b-a;
    }


    @Test
    public void validateDivision(){

       double actualResults=getDivision(8,2);
       double expectedResult=4;
       Assert.assertEquals(actualResults,expectedResult);

    }

    @Test public void validateSubstraction(){
        int actualResult=Substraction(4,5);
        int expectedResult=1;
        Assert.assertEquals(actualResult,expectedResult);
    }
}
