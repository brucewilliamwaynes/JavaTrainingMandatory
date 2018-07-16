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
        searchUsingCustomListObj.stringInput = InputScanner.readInputFromFile();

        UnorderedList<String>  myList = new UnorderedList<String>();
        myList = UnorderedList.segregateWordsIntoList(searchUsingCustomListObj.stringInput);
        System.out.println("Enter word to search! ");
        searchUsingCustomListObj.searchKey = inputScannerObj.inputString();
        if(myList.searchNode(searchUsingCustomListObj.searchKey)) {
            System.out.println("Word Found !");
            myList.removeNodeAtIndex(myList.returnIndexOfItem(searchUsingCustomListObj.searchKey));
        }
        else {
            System.out.println("Opps ! Not Found !");
            myList.insertNode(searchUsingCustomListObj.searchKey);
        }
        InputScanner.writeInputToFileFromList(myList);
    }
}
