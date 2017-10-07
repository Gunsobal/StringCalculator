package is.ru.stringcalculator;

import java.lang.IllegalArgumentException;

public class Calculator
{
    public static int add(String text){
        if (text == "") return 0;
        String[] numbers = text.split(",|\n");
        checkNegatives(numbers);
        return sum(numbers);
    }

    private static int toInt(String number){
        return Integer.parseInt(number);
    }

    private static int sum(String[] numbers){
        int sum = 0;
        for (String number : numbers){
            sum += toInt(number);
        }
        return sum;
    }

    private static void checkNegatives(String[] numbers){
        String negatives = "";
        for (String number : numbers){
            if (toInt(number) < 0){
                negatives += number + ",";
            }
        }
        if (negatives != ""){
            String message = String.format("Negatives not allowed: %s", negatives.substring(0, negatives.length() - 1));
            throw new IllegalArgumentException(message);
        }
    }
}