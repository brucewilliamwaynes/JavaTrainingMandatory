package com.training.utility;
import java.io.*;
import java.io.IOException;
import java.util.*;
/*Utility Class Created To use it for Complete Package*/
public class InputScanner extends  GenericTemplateClass{

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

    public static <genericTemplate> genericTemplate genericInput(Class<genericTemplate> classType) throws IOException {
        InputScanner inputScannerObj = new InputScanner();
        try{
            if(classType == Integer.class)
                return classType.cast(inputScannerObj.inputInteger());
            if(classType == String.class)
                return classType.cast(inputScannerObj.inputString());
            if(classType == Double.class)
                return classType.cast(inputScannerObj.inputDouble());
            if(classType == Boolean.class)
                return classType.cast(inputScannerObj.inputBoolean());
        }
        catch (InputMismatchException e){
            System.out.println(e);
        }
        return null;
    }

    public static String readInputFromFile()throws FileNotFoundException{
        InputScanner inputScannerObj = new InputScanner();
        System.out.println("Enter source of input file!");
        String inputDestination = inputScannerObj.inputString();

        File inputFile = new File(inputDestination);
        Scanner sc = new Scanner(inputFile);
        sc.useDelimiter("\\Z");
        String inputFileToString = sc.next();
        inputFileToString = inputFileToString.replace("\n","").replace("\r","");
        return inputFileToString;
    }

    public static void writeInputToFileFromList(UnorderedList<String> list) throws FileNotFoundException,IOException{
        InputScanner inputScannerObj = new InputScanner();
        System.out.println("Enter destination for output file!");
        String inputDestination = inputScannerObj.inputString();

        FileWriter outputFile = new FileWriter(inputDestination,true);
        for(int i=0;i<list.lengthOfList();i++){
            outputFile.write(list.getElementAtIndex(i) + "\n");
        }
        outputFile.close();
    }

    public static void writeInputToFileFromList(OrderedList<Integer> list) throws FileNotFoundException,IOException{
        InputScanner inputScannerObj = new InputScanner();
        System.out.println("Enter destination for output file!");
        String inputDestination = inputScannerObj.inputString();

        FileWriter outputFile = new FileWriter(inputDestination,true);
        for(int i=0;i<list.lengthOfList();i++){
            outputFile.write(list.getElementAtIndex(i) + "\n");
        }
        outputFile.close();
    }


    public String inputString(){
        String temp = sc.next();
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

    public static long getTimeInMilisec(){
        Date dateObj = new Date();
    return (dateObj.getTime());
    }



}
