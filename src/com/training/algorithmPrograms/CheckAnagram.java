package com.training.algorithmPrograms;

import com.training.utility.CommonAlgorithms;
import com.training.utility.InputScanner;

public class CheckAnagram {
    private String stringOne;
    private String stringTwo;

    CheckAnagram(){
        this.stringOne = "";
        this.stringTwo = "";
    }

    public void anagramFinder(){
        InputScanner inputScannerObj = new InputScanner();
//        CommonAlgorithms commonAlgorithmsObj = new CommonAlgorithms();
        CheckAnagram checkAnagramObj = new CheckAnagram();

        System.out.println("Enter String One:");
        checkAnagramObj.stringOne = inputScannerObj.inputString();
        System.out.println("Enter String Two:");
        checkAnagramObj.stringTwo = inputScannerObj.inputString();

        if(CommonAlgorithms.isAnagram(checkAnagramObj.stringOne,checkAnagramObj.stringTwo,0)){
            System.out.println("Yes, " + checkAnagramObj.stringOne + " and " + checkAnagramObj.stringTwo + " are Anagrams!");
        }
        else{
            System.out.println("Sorry not Anagrams!");
        }

    }
}
