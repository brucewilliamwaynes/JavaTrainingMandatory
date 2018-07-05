package com.training.utility;
import java.util.*;

public class InputScanner {

    private Scanner sc;
    private String inputString;
    private int inputInt;
    private double inputDbl;
    private boolean inputBool;

    public InputScanner(){
        sc = new Scanner(System.in);
    }

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

    public String replaceString(String mainTextToBeEdited,String textToBeReplaced,String textReplaceWith){
        mainTextToBeEdited = mainTextToBeEdited.replace(textToBeReplaced,textReplaceWith);
        return mainTextToBeEdited;
    }

    public double findRandomWithoutRange(){
        return Math.random();
    }

    public static double findRandomWithRange(int min,int max){
        return ((Math.random()*(max-min + 1)) - min);
    }

    public double calculatePercentage(int event,int totalEvents){
        return ((double)(event)/(double)(totalEvents))*100.0;
    }
}
