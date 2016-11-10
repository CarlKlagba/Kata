package calculator;

/**
 * Created by Travail on 15/08/2016.
 */
public class Calculator {

    public static int Add(String numbers){
        if(numbers.equals("") || numbers.equals(null)){
            return 0;
        }

        String delimiter = ",";
        if(numbers.startsWith("//")){
            delimiter = Character.toString(numbers.charAt(2));
            numbers = numbers.replaceFirst("//.\\n", "");
        }

        String[] numbersTab =  numbers.split("("+delimiter+"|\\n)");
        int sum = 0;
        int current;
        for (int i = 0; i < numbersTab.length; i++){
            current = Integer.parseInt(numbersTab[i]);
            sum += current;
        }

        return  sum;
    }
}
