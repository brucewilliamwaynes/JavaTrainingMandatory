package com.training.algorithmPrograms;

import com.training.utility.GenericTemplateClass;
import com.training.utility.InputScanner;

import java.util.ArrayList;

public class TestGeneric {
    public static void main(String args[]){
        Integer wordsList[] = {10,9,6};
        wordsList = GenericTemplateClass.bubbleSortGeneric(wordsList);
        for( int element : wordsList)
            System.out.println(element);
    }
}
