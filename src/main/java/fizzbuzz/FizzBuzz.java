package fizzbuzz;

import java.util.stream.IntStream;

/**
 * Created by Travail on 17/08/2016.
 */
public class FizzBuzz {

    public static String Generate(int max){

        String result= null;
        if(max > 0) {
            result= "";
            result = IntStream.range(1, max+1)
                    .mapToObj(i -> fizzyBuzzy(i))
                    .reduce("", (acc, y) -> acc + y +  ",");
        }
        return result;
    }

    private static  String fizzyBuzzy(int i){
        if(i%5 == 0 && i % 3 == 0){
            return "FizzBuzz";
        }
        if(i % 3 == 0){
           return "Fizz";
        }
        if(i%5 == 0){
            return  "Buzz";
        }
        return String.valueOf(i);
    }
}

