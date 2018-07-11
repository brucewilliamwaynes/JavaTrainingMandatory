package com.training.algorithmPrograms;

import com.training.utility.GenericTemplateClass;
import com.training.utility.InputScanner;
import sun.net.www.content.text.Generic;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TestGeneric {

    private long startTime;
    private long stopTime;
    private int limit;


    TestGeneric(){
        this.startTime = 0;
        this.stopTime = 0;
        this.limit = 0;
    }

    public static void main(String args[]){

        TestGeneric testGenericObj = new TestGeneric();
        InputScanner inputScannerObj = new InputScanner();

        System.out.println("Enter Limit of List!");
        testGenericObj.limit = inputScannerObj.inputInteger();

        String[] wordsList = new String[testGenericObj.limit];

        for(int i=0;i<testGenericObj.limit;i++) {
            System.out.println("Enter a new String!");
            wordsList[i] = inputScannerObj.inputString();
        }

        //Integer[] numberList = new Integer[this.limit];


        testGenericObj.startTime = InputScanner.getTimeInMilisec();
        wordsList = GenericTemplateClass.bubbleSortGeneric(wordsList);
        testGenericObj.stopTime = InputScanner.getTimeInMilisec();

        for( String element : wordsList)
            System.out.println(element);

        System.out.println("Bubble Sort took " + (testGenericObj.stopTime - testGenericObj.startTime) + "Milliseconds!");

        testGenericObj.startTime = InputScanner.getTimeInMilisec();
        wordsList = GenericTemplateClass.insertionSortGeneric(wordsList);
        testGenericObj.stopTime = InputScanner.getTimeInMilisec();

        for( String element : wordsList)
            System.out.println(element);

        System.out.println("Insertion Sort took " + (testGenericObj.stopTime - testGenericObj.startTime) + "Milliseconds!");

        System.out.println("Enter word to search!");
        String keyToSeach = inputScannerObj.inputString();

        testGenericObj.startTime = InputScanner.getTimeInMilisec();
        boolean ans = GenericTemplateClass.binarySearchGeneric(wordsList, keyToSeach);
        testGenericObj.stopTime = InputScanner.getTimeInMilisec();

        if(ans)
            System.out.println("Found!!");
        else
            System.out.println("Not Found Sorry !");

        System.out.println("Binary Searching took " + (testGenericObj.stopTime - testGenericObj.startTime) + "Milliseconds!");

    }
}
