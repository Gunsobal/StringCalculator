package is.ru.stringcalculator;

import java.lang.IllegalArgumentException;

public class Calculator
{
    public static int add(String text){
        String[] numbers = splitNumbers(text);
        if (numbers[0].length() == 0) return 0;
        checkNegatives(numbers);
        return sum(numbers);
    }

    private static String[] splitNumbers(String text){
        String delimiter = ",|\n";
        String numbers = text;
        if (text.startsWith("//")){
            String[] split = text.split("\n", 2);
            delimiter = split[0].substring(2);
            numbers = split[1];
        }
        return numbers.split(delimiter);
    }

    private static int toInt(String number){
        return Integer.parseInt(number);
    }

    private static int sum(String[] numbers){
        int sum = 0;
        for (String number : numbers){
            int n = toInt(number);
            if (n <= 1000){
                sum += n;
            }
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