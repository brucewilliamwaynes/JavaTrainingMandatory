package com.training.utility;
import java.util.*;
/*Utility Class Created To use it for Complete Package*/
public class InputScanner {

    //Class Variables of various data types and Scanner Object
    private Scanner sc;
    private String inputString;
    private int inputInt;
    private double inputDbl;
    private boolean inputBool;

    //Default Constructor to Create sc Object for each time we need input
    public InputScanner(){
        sc = new Scanner(System.in);
    }

    /*
        Parameterized Constructor to initialize different data types
    */
    public InputScanner(String temp){
        this.inputString = temp;
    }

    public InputScanner(int temp){
        this.inputInt = temp;
    }

    public InputScanner(double temp){
        this.inputDbl = temp;
    }
    public InputScanner(boolean temp){
        this.inputBool = temp;
    }

    /*
        Function for different data types to input and return the Input Data
    */
    public String inputString(){
        String temp = sc.nextLine();
        InputScanner inputScannerObj = new InputScanner(temp);
        return inputScannerObj.inputString;
    }

    public int inputInteger(){
        int temp = sc.nextInt();
        InputScanner inputScannerObj = new InputScanner(temp);
        return inputScannerObj.inputInt;
    }
    public double inputDouble(){
        double temp = sc.nextDouble();
        InputScanner inputScannerObj = new InputScanner(temp);
        return inputScannerObj.inputDbl;
    }
    public boolean inputBoolean(){
        boolean temp = sc.nextBoolean();
        InputScanner inputScannerObj = new InputScanner(temp);
        return inputScannerObj.inputBool;
    }

    /*
        Utility Function to replace String
    */
    public String replaceString(String mainTextToBeEdited,String textToBeReplaced,String textReplaceWith){
        mainTextToBeEdited = mainTextToBeEdited.replace(textToBeReplaced,textReplaceWith);
        return mainTextToBeEdited;
    }

    //Utility Function to find RandomNumber without Range
    public double findRandomWithoutRange(){
        return Math.random();
    }

    //Utility Function to find RandomNumber within a given Range
    public static double findRandomWithRange(int min,int max){
        return ((Math.random()*(max-min + 1)) - min);
    }

    //Utility Function to calculate Percentage with eventSpace and totalSampleSpace
    public double calculatePercentage(int event,int totalEvents){
        return ((double)(event)/(double)(totalEvents))*100.0;
    }

    //Utility to implement swap character functionality in String using toCharArray() and valueOf()

    public static String swapString(String sampleString , int leftIndex , int rightIndex){
        char charArrayFromString [] = sampleString.toCharArray();
        char temp;
        temp = charArrayFromString[leftIndex];
        charArrayFromString[leftIndex] = charArrayFromString[rightIndex];
        charArrayFromString[rightIndex] = temp;
        return (String.valueOf(charArrayFromString));
    }

}
