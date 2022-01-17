package org.example;


public class StringCalculator
{
    public static int add(String string )
    {
        int result = 0;
        string = string.replace("\n", ",");
        if (string.contains(",")) {
            String[] numbersInString = string.split(",");
            for (String number : numbersInString) {
                result += Integer.parseInt(number);
            }
        } else if (string.length() > 0){
            result = Integer.parseInt(string);
        }
        return result;
    }

}
