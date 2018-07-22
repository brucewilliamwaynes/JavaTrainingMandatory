package com.training.utility;

import com.training.functionalPrograms.CheckLeapYear;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

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

    public static boolean isAnagramForInteger(Integer numberOne , Integer numberTwo){
        return (isAnagram(String.valueOf(numberOne),String.valueOf(numberTwo),1));
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
            for(int i = 2; i <= (int)(Math.sqrt(number)); i++){
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

    public static int getLowerLimitInPowerOf2(long rawNumber){

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

    public static boolean dateValidator(String inputString){
        if(inputString.trim().equals("")){
            return false;
        }
        else{
            SimpleDateFormat simpleDateFormatObj = new SimpleDateFormat("MM/dd/yyyy");
            simpleDateFormatObj.setLenient(false);

            try{
                Date javaDate = simpleDateFormatObj.parse(inputString);
            }
            catch (ParseException e){
                return false;
            }
        }
        return true;
    }

    public static String dayOfWeek(String inputDate)throws ParseException{

        int month , day , year;
        month = Integer.parseInt(inputDate.substring(0,2));
        day = Integer.parseInt(inputDate.substring(3,5));
        year = Integer.parseInt(inputDate.substring(inputDate.length() - 4));

        year = year - (14-month)/12;
        year = year + (year/4) - (year/100) + (year/400);
        month = month + 12 * ((14-month)/12) - 2;
        day = (day + year + (31 * month)/12) % 7;

        String daysOfWeek[] = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        return daysOfWeek[day];
    }

    public static double temperatureConversion(int choice,double temperature){
        if(choice == 1){
            return ((temperature * 9.0) / 5.0 + 32.0);
        }
        else
            return ((temperature - 32.0) * 5.0)/9.0;
    }

    public static double monthlyPayment(double principal, int year, double rate){
        rate = rate/(12.0*100.0);
        year = 12 * year;
        return (( principal * rate ) / (1.0 - (1.0/(Math.pow(1.0 + rate,year)))));
    }

    public static boolean isNegative(int number){
        return number < 0 ? true : false;
    }

    public static double sqrt(int number){
        return sqrt((double)number);
    }

    public static double sqrt(double number){
        double t = number;
        final double epislon = 1e-15;
        while(Math.abs(t - number/t)>epislon*t) {
            t = (number/t + t)/2;
        }
        return t;
    }

    public static String reverseString(String inputString){
        String tempString = "";
        for(int i=0;i<inputString.length();i++){
            tempString = inputString.charAt(i) + tempString;
        }
        return tempString;
    }

    public static String toBinary(int number){
        String binaryFromNumber = "";
        while(number > 0){
            binaryFromNumber = String.valueOf(number%2) + binaryFromNumber;
            number = number/2;
        }
        return binaryFromNumber;
    }

    public static String addPaddingToBinaryToByte(String binary){
        int limit = (8-(binary.length()));
        for(int i=1;i<=limit;i++){
            binary = "0" + binary;
        }
        return binary;
    }

    public static long toDecimal(String binary){
        long  decimalEquivalent = 0;
        binary = reverseString(binary);
        for(int i=0;i<binary.length();i++){
            if(binary.charAt(i) == '1')
                decimalEquivalent += (long)Math.pow(2,i);
        }
        return decimalEquivalent;
    }
}
