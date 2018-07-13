package com.training.algorithmPrograms;

import com.training.utility.CommonAlgorithms;
import com.training.utility.GenericTemplateClass;
import com.training.utility.InputScanner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class SearchWordFromFile {

    private String inputString;
    private String searchKey;

    SearchWordFromFile(){
        this.inputString = "";
        this.searchKey = "";
    }

    public void searchWord() throws IOException{

        InputScanner inputScannerObj = new InputScanner();
        SearchWordFromFile searchWordFromFileObj = new SearchWordFromFile();

        searchWordFromFileObj.inputString = InputScanner.readInputFromFile();

        ArrayList<String> listOfWords;

        listOfWords = CommonAlgorithms.segregateWordsInFile(searchWordFromFileObj.inputString);

        for(String element : listOfWords)
            System.out.println(element);

        Collections.sort(listOfWords);

        System.out.println("Enter Word to be Searched!");

        searchWordFromFileObj.searchKey = inputScannerObj.inputString();

        if(GenericTemplateClass.binarySearchGeneric(listOfWords,searchWordFromFileObj.searchKey))
            System.out.println("Word Found!");
        else
            System.out.println("Cannot be Found Sorry!");

    }

}
