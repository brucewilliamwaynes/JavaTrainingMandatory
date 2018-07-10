package com.training.utility;

import java.util.Arrays;

public class CommonAlgorithms {

    public static boolean isAnagram(String textOne, String textTwo , int flagCheck){

        if(flagCheck == 0) {
            textOne = textOne.toLowerCase();
            textTwo = textTwo.toLowerCase();
            String tempString = "";
            //Removing any extra characters
            for (int i = 0; i < textOne.length(); i++) {
                if (textOne.charAt(i) >= 97 && textOne.charAt(i) <= 122)
                    tempString += textOne.charAt(i);
            }

            textOne = tempString;
            tempString = "";

            for (int i = 0; i < textTwo.length(); i++) {
                if (textTwo.charAt(i) >= 97 && textTwo.charAt(i) <= 122)
                    tempString += textTwo.charAt(i);
            }

            textTwo = tempString;
        }

        if(textOne.length() == textTwo.length()){
            char stringUno[] = textOne.toCharArray();
            char stringDos[] = textTwo.toCharArray();

            Arrays.sort(stringUno);
            Arrays.sort(stringDos);

            textOne = String.valueOf(stringUno);
            textTwo = String.valueOf(stringDos);
            if(textOne.compareTo(textTwo)==0)
                return true;
        }
        return false;
    }

    public static boolean isAnagramForInteger(String numberOne , String numberTwo){
        return (isAnagram(numberOne,numberTwo,1));
    }

    public static boolean isPallindromeForString(String text){
        char textToCharArray[] = text.toCharArray();
        for(int i=0;i<=(text.length()/2);i++){
            if(textToCharArray[i] != textToCharArray[text.length() - i - 1])
                return false;
        }
        return true;
    }

    public static boolean isPallindromeForInteger(int number){
        return isPallindromeForString(String.valueOf(number));
    }

    public static boolean isPallindromeForDouble(double number){
        String doubleToStringWithDecimalPoint = String.valueOf(number);
        String doubleToStringWithoutDecimalPoint = "";

        for(int i=0;i<doubleToStringWithDecimalPoint.length();i++){
            if(doubleToStringWithDecimalPoint.charAt(i) != '.')
                doubleToStringWithoutDecimalPoint += doubleToStringWithDecimalPoint.charAt(i);
        }

        return isPallindromeForString(doubleToStringWithoutDecimalPoint);
    }

    public static boolean isPrime(int number){
        if(number == 1 || number == 0)
            return false;
        else{
            for(int i = 2; i < (int)(Math.sqrt(number)); i++){
                if(number % i == 0)
                    return false;
            }
        }
        return true;
    }

    public static void PrimeNumbersInRange(int lowerLimit, int upperLimit){
        for(int i=lowerLimit;i<=upperLimit;i++){
            if(CommonAlgorithms.isPrime(i))
                System.out.println(i);
        }
    }

}
