package fizzbuzz;

import org.junit.*;
import org.junit.Test;

/**
 * Created by Travail on 17/08/2016.
 */

public class FizzBuzzTest {
    @org.junit.Test
    public void GivenNumberBelowOne_ReturnEmptyString(){
        String result = FizzBuzz.Generate(-1);

        Assert.assertNull(result);
    }

    @Test
    public void Given1_Return1(){
        String result = FizzBuzz.Generate(1);

        Assert.assertEquals("1,",result);

    }

    @Test
    public void Given2_Return12(){
        String result = FizzBuzz.Generate(2);

        Assert.assertEquals("1,2,",result);
    }

    @Test
    public void Given3_RetrunFizz(){
        String result = FizzBuzz.Generate(3);
        Assert.assertEquals("1,2,Fizz,",result);
    }
}
