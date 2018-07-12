package com.training.algorithmPrograms;

import com.training.utility.CommonAlgorithms;
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

    public static void main(String args[]) {

        TestGeneric testGenericObj = new TestGeneric();
        InputScanner inputScannerObj = new InputScanner();



        System.out.println("Do You want Run Bubble Sort!");

        boolean choice = inputScannerObj.inputBoolean();

        if (choice) {
            System.out.println("Enter Limit of List for Bubble Sort!");
            testGenericObj.limit = inputScannerObj.inputInteger();

            ArrayList<Integer> wordsList = new ArrayList<Integer>(testGenericObj.limit);

            for (int i = 0; i < testGenericObj.limit; i++) {
                System.out.println("Enter a new number!");
                wordsList.add(i, inputScannerObj.inputInteger());
            }

            //Integer[] numberList = new Integer[this.limit];


            testGenericObj.startTime = InputScanner.getTimeInMilisec();
            wordsList = GenericTemplateClass.bubbleSortGeneric(wordsList);
            testGenericObj.stopTime = InputScanner.getTimeInMilisec();

            for (Integer element : wordsList)
                System.out.println(element);

            System.out.println("Bubble Sort took " + (testGenericObj.stopTime - testGenericObj.startTime) + "Milliseconds!");
        }
        System.out.println("Do you want to run Insertion Sort!");
        choice = inputScannerObj.inputBoolean();
        if (choice) {
            System.out.println("Enter Limit of List for Insertion Sort!");
            testGenericObj.limit = inputScannerObj.inputInteger();

            ArrayList<String> wordsList = new ArrayList<String>(testGenericObj.limit);

            for (int i = 0; i < testGenericObj.limit; i++) {
                System.out.println("Enter a new String!");
                wordsList.add(i, inputScannerObj.inputString());
            }

            testGenericObj.startTime = InputScanner.getTimeInMilisec();
            wordsList = GenericTemplateClass.insertionSortGeneric(wordsList);
            testGenericObj.stopTime = InputScanner.getTimeInMilisec();

            for (String element : wordsList)
                System.out.println(element);

            System.out.println("Insertion Sort took " + (testGenericObj.stopTime - testGenericObj.startTime) + "Milliseconds!");
            choice = false;
        }
        System.out.println("Do you want to run Binary Search!");
        choice = inputScannerObj.inputBoolean();
        if(choice){
            System.out.println("Enter Limit of List for Binary Search!");
            testGenericObj.limit = inputScannerObj.inputInteger();

            ArrayList<String> wordsList = new ArrayList<String>(testGenericObj.limit);

            for (int i = 0; i < testGenericObj.limit; i++) {
                System.out.println("Enter a new String!");
                wordsList.add(i, inputScannerObj.inputString());
            }

            System.out.println("Enter word to search!");
            String keyToSearch = inputScannerObj.inputString();


            testGenericObj.startTime = InputScanner.getTimeInMilisec();
            boolean ans = GenericTemplateClass.binarySearchGeneric(wordsList, keyToSearch);

            if (ans)
                System.out.println("Found!!");
            else
                System.out.println("Not Found Sorry !");

            testGenericObj.stopTime = InputScanner.getTimeInMilisec();

            System.out.println("Binary Searching took " + (testGenericObj.stopTime - testGenericObj.startTime) + "Milliseconds!");
        }
        System.out.println("Do you want to Run Merge Sort!");
        choice = inputScannerObj.inputBoolean();

        if(choice){
            System.out.println("Enter limit of Merge Sort!");
            testGenericObj.limit = inputScannerObj.inputInteger();

            ArrayList<String> wordsList = new ArrayList<String>(testGenericObj.limit);

            for (int i = 0; i < testGenericObj.limit; i++) {
                System.out.println("Enter a new String!");
                wordsList.add(i, inputScannerObj.inputString());
            }


            wordsList = GenericTemplateClass.mergeSortGenericAuxillary(wordsList,0,wordsList.size()-1);

            System.out.println(wordsList.size());

            for (String element : wordsList)
                System.out.println(element);

        }

    }
}
