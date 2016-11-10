package calculator;

import calculator.Calculator;
import org.junit.Assert;

/**
 * Created by Travail on 15/08/2016.
 */

public class Test {
    @org.junit.Test
    public void test1(){
        String numbers = "";
        int expectedResult=0;

        int result = Calculator.Add(numbers);
        Assert.assertEquals(expectedResult,result);
    }
    @org.junit.Test
    public void test2(){
        String numbers = "1";
        int expectedResult=1;

        int result = Calculator.Add(numbers);
        Assert.assertEquals(expectedResult,result);
    }
    @org.junit.Test
    public void test3(){
        String numbers = "1,2";
        int expectedResult=3;

        int result = Calculator.Add(numbers);
        Assert.assertEquals(expectedResult,result);
    }

    @org.junit.Test
    public void test4(){
        String numbers = "1,1,1,1,1,1,1,1";
        int expectedResult=8;

        int result = Calculator.Add(numbers);
        Assert.assertEquals(expectedResult,result);
    }

    @org.junit.Test
    public void test5(){
        String numbers = "1\n2,3";
        int expectedResult=6;

        int result = Calculator.Add(numbers);
        Assert.assertEquals(expectedResult,result);
    }

    @org.junit.Test
    public void test6(){
        String numbers = "//;\n1\n2;3";
        int expectedResult=6;

        int result = Calculator.Add(numbers);
        Assert.assertEquals(expectedResult,result);
    }

    @org.junit.Test
    public void test7(){
        String numbers = "//;\n1;1;1;1;1;1;1;1";
        int expectedResult=8;

        int result = Calculator.Add(numbers);
        Assert.assertEquals(expectedResult,result);
    }

    @org.junit.Test
    public void test8(){
        String numbers = "//;\n1;2";
        int expectedResult=3;

        int result = Calculator.Add(numbers);
        Assert.assertEquals(expectedResult,result);
    }
}
