package com.training.dataStructurePrograms;

import com.training.utility.InputScanner;
import com.training.utility.OrderedList;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SearchUsingOrderedList {
    private String inputString;
    private int numberToBeSearched;
    SearchUsingOrderedList(){
        this.inputString = "";
        this.numberToBeSearched = 0;
    }

    public void displaySearchedNumber()throws IOException,FileNotFoundException{
        InputScanner inputScannerObj = new InputScanner();
        SearchUsingOrderedList searchUsingOrderedListObj = new SearchUsingOrderedList();
        searchUsingOrderedListObj.inputString = InputScanner.readInputFromFile();

        OrderedList<Integer> myList = new OrderedList<Integer>();
        myList = OrderedList.segregateNumbersIntoList(searchUsingOrderedListObj.inputString);
        System.out.println("Enter number to search! ");
        searchUsingOrderedListObj.numberToBeSearched = inputScannerObj.inputInteger();
        if(myList.searchNode(searchUsingOrderedListObj.numberToBeSearched)) {
            System.out.println("Word Found !");
            myList.removemNodeElement(searchUsingOrderedListObj.numberToBeSearched);
        }
        else {
            System.out.println("Opps ! Not Found !");
            myList.insertNode(searchUsingOrderedListObj.numberToBeSearched);
        }
        InputScanner.writeInputToFileFromList(myList);
    }
}

