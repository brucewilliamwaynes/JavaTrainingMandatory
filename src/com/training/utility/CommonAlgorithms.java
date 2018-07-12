package com.training.utility;

import java.util.ArrayList;
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

    public static String[] bubbleSortForString(String list[]){
        String temp = "";
        for(int i=0;i<list.length-1;i++){
            for(int j=0;j<list.length-i-1;j++){
                if(list[j].compareTo(list[j+1]) > 0){
                    temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        }
        return list;
    }

    public static int[] bubbleSortForInteger(int list[]){
        int temp = 0;
        for(int i=0;i<list.length-1;i++){
            for(int j=0;j<list.length-i-1;j++){
                if(list[j] - list[j+1] > 0){
                    temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        }
        return list;
    }

    public static int[] insertionSortForInteger(int list[]){
        for(int i=1;i<list.length;i++){
            int indexKey = list[i];
            for(int j = i-1; j >= 0 && list[j] > indexKey; j--){
                list[j+1] = list[j];
            }
        }
        return list;
    }

    public static String[] insertionSortForString(String list[]){
        for(int i=1;i<list.length;i++){
            String indexKey = list[i];
            for(int j = i-1; j >= 0 && list[j].compareTo(indexKey) > 0; j--){
                list[j+1] = list[j];
            }
        }
        return list;
    }

    public static boolean binarySearchForInteger(int listOfNumbers[],int searchKey){
        Arrays.sort(listOfNumbers);
        int leftIndex = 0;
        int rightIndex = listOfNumbers.length - 1;
        int mid = (leftIndex + rightIndex)/2;
        while(leftIndex < rightIndex){
            if(listOfNumbers[mid] == searchKey){
                return true;
            }
            else if(listOfNumbers[mid] < searchKey){
                leftIndex = mid + 1;
            }
            else
                rightIndex = mid -1 ;
        }
        return false;
    }


    public static boolean binarySearchForString(String listOfWords[],String searchKey){

        listOfWords = bubbleSortForString(listOfWords);
        int leftIndex = 0;
        int rightIndex = listOfWords.length - 1;
        int mid = (leftIndex + rightIndex)/2;
        while(leftIndex < rightIndex){
            if(listOfWords[mid].compareTo(searchKey) == 0){
                return true;
            }
            else if(listOfWords[mid].compareTo(searchKey) < 0){
                leftIndex = mid + 1;
            }
            else
                rightIndex = mid -1 ;
        }
        return false;
    }

    public static int getLowerLimitInPowerOf2(int rawNumber){

        int count = 0;

        while(rawNumber > 0){
            rawNumber /= 2;
            count++;
        }

        return count;
    }

    public static ArrayList<String> segregateWordsInFile(String inputString){

        String word = "";
        ArrayList<String> list = new ArrayList<String>();

        for(int i=0;i<inputString.length();i++){
            if(inputString.charAt(i) != ',' && inputString.charAt(i) != ' '){
                word += inputString.charAt(i);
            }
            else{
                list.add(word);
                word = "";
            }
        }

        list.add(word.substring(0,word.length()-1));

        return list;
    }

}
