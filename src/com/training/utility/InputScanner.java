package com.training.utility;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.training.sampleClassTypes.Stock;

import java.awt.*;
import java.io.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    
    public  static  void writeInputToFileFromArray(ArrayList<Stock> list) throws IOException{
    	InputScanner inputScannerObj = new InputScanner();
    	System.out.println("Enter Destination for output file");
    	String inputDestination = inputScannerObj.inputString();
    	FileWriter outputFile = new FileWriter(inputDestination,true);
		for(int i=0;i<list.size();i++){
				outputFile.write(list.get(i).getDetails());
			}
			outputFile.close();
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

    public static void writeInputToFile(OrderedMapCustom<Integer,Integer> map) throws FileNotFoundException,IOException {
        InputScanner inputScannerObj = new InputScanner();
        System.out.println("Enter destination for output file!");
        String inputDestination = inputScannerObj.inputString();
        FileWriter outputFile = new FileWriter(inputDestination,true);

        MapElement<Integer,Integer> currentMapElement = map.head;
        while(currentMapElement != null){
            outputFile.write("The Key is :" + currentMapElement.key + " and the list of numbers in it!" + currentMapElement.chainList.displayListInString() + "\n");
            currentMapElement = currentMapElement.next;
        }
        outputFile.close();
    }

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
    public static int findRandomWithRange(int min,int max){
        return ((int)(Math.random()*((max-min) + 1)) + min);
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

    public static void getInventoryDetails(OrderedMapCustom<String,String> myMap){
        InputScanner inputScannerObj = new InputScanner();
        System.out.println("Enter name!");
        String name = inputScannerObj.inputString();
        String weight = inputScannerObj.inputString();
        String price = inputScannerObj.inputString();
        myMap.addElementToHashMap("name",name);
        myMap.addElementToHashMap("weight",weight);
        myMap.addElementToHashMap("price",price);
    }

    public static void getInventoryDetails(Map myMap){
        InputScanner inputScannerObj = new InputScanner();
        System.out.println("Enter name!");
        String name = inputScannerObj.inputString();
        System.out.println("Enter weight!");
        String weight = inputScannerObj.inputString();
        System.out.println("Enter price!");
        String price = inputScannerObj.inputString();
        myMap.put("name",name);
        myMap.put("weight",weight);
        myMap.put("price",price);
    }

    public static String createJSON(JSONObject jsonObj){
        InputScanner inputScannerObj = new InputScanner();
        System.out.println("Enter destination for output file!");
        String inputDestination = inputScannerObj.inputString();
        try {
            PrintWriter outputFile = new PrintWriter(inputDestination);
            outputFile.write(jsonObj.toJSONString());
            outputFile.flush();
            outputFile.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return inputDestination;
    }

    public static JSONObject readJSONFromFile()throws Exception {
    	InputScanner inputScannerObj = new InputScanner();
    	System.out.println("Enter destination of input file!");
    	String inputDestination = inputScannerObj.inputString();
        Object fileObj = new JSONParser().parse(new FileReader(inputDestination));
        JSONObject jsonObj = (JSONObject) fileObj;
        return jsonObj;
    }
    
    //reaplceWithStringUsingRegex --> inputString : replaceWithString : pattern OR WordToReplace // returns  modified string
    public static String replaceStringUsingRegex(String inputString,String replaceWithString,String patternToReplace){
    	Pattern patternReplace = Pattern.compile(patternToReplace);
    	Matcher matchInput = patternReplace.matcher(inputString);
    	inputString = matchInput.replaceAll(replaceWithString);
    	return inputString;
    }
    
    public static String[] initializeSuit(){
    	String suit[] = {"","Clubs","Diamonds","Hearts","Spades"};
    	return suit;
    }
    
    public static String[] initializeRank(){
    	String rank[] = {"","","2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
    	return rank;
    }

	public static void displayArray(String[][] displayArray, int row, int column) {
		// TODO Auto-generated method stub
		for(int i=0;i<row;i++){
			for(int j=0;j<column;j++){
				System.out.print(displayArray[i][j] + "     " );
			}
			System.out.println();
		}
	}
    
}
