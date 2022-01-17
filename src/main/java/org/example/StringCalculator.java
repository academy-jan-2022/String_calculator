package org.example;


public class StringCalculator
{
    public static int add(String string ) throws Exception {
        int result = 0;

        if (string.contains("-")) {
            String[] numbersInString = string.split(",");
            String negativeNumbersString = "";
            for (int i = 0; i < numbersInString.length; i++) {
                int parsedInt = Integer.parseInt(numbersInString[i]);
                if (parsedInt < 0) {
                    if (i > 0) {
                        negativeNumbersString += ",";
                    }
                    negativeNumbersString += numbersInString[i];
                }
            }
            throw new Exception("negatives not allowed: " + negativeNumbersString);
        }

        if (string.contains("//")) {
            char separator = string.charAt(2);
          string = string.substring(4);
          string = string.replace(separator, ',');
        }

        string = string.replace("\n", ",");
        if (string.contains(",")) {
            String[] numbersInString = string.split(",");
            for (String number : numbersInString) {
                if (Integer.parseInt(number) <= 1000) {
                    result += Integer.parseInt(number);
                }
            }
        } else if (string.length() > 0){
            result = Integer.parseInt(string);
        }
        return result;
    }

}
