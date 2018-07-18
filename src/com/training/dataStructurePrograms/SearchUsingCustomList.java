package com.training.dataStructurePrograms;

import com.training.utility.*;

import java.io.IOException;

public class SearchUsingCustomList {
    private String stringInput;
    private String searchKey;
    SearchUsingCustomList(){
        this.stringInput = "";
        this.searchKey = "";
    }

    public void displayResultOfSearch()throws IOException{
        InputScanner inputScannerObj = new InputScanner();
        SearchUsingCustomList searchUsingCustomListObj = new SearchUsingCustomList();
//        searchUsingCustomListObj.stringInput = InputScanner.readInputFromFile();
        UnorderedList<Integer> myList = new UnorderedList<Integer>();
//        UnorderedList<String>  myList = new UnorderedList<String>();
        System.out.println("Enter size of list!");
        int limit = inputScannerObj.inputInteger();
        for(int i=0;i<limit;i++) {

            System.out.println("Enter a number!");
            myList.insertNode(inputScannerObj.inputInteger());

        }
        myList.displayList();
        myList.bubbleSortForUnorderedList();
        myList.displayList();
//        System.out.println("Enter word to search! ");
//        searchUsingCustomListObj.searchKey = inputScannerObj.inputString();
//        if(myList.searchNode(searchUsingCustomListObj.searchKey)) {
//            System.out.println("Word Found !");
//            myList.removeNodeAtIndex(myList.returnIndexOfItem(searchUsingCustomListObj.searchKey));
//        }
//        else {
//            System.out.println("Opps ! Not Found !");
//            myList.insertNode(searchUsingCustomListObj.searchKey);
//        }
//        InputScanner.writeInputToFileFromList(myList);
    }
}
