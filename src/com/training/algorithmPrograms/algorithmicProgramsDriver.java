package com.training.algorithmPrograms;

import com.training.utility.CommonAlgorithms;

import java.io.IOException;

public class algorithmicProgramsDriver {

    algorithmicProgramsDriver() throws IOException{

        /*
        CheckAnagram checkAnagramObj = new CheckAnagram();
        checkAnagramObj.anagramFinder();
        */

//        CommonAlgorithms.PrimeNumbersInRange(0,1000);
        /*
        PrimeAnagramPalindrome primeAnagramPalindromeObj = new PrimeAnagramPalindrome();
        primeAnagramPalindromeObj.findPalindromPrimeAnagrams();
        */

//        NthNumberFinder.findNthNumber();
            SearchWordFromFile searchWordFromFileObj = new SearchWordFromFile();
            searchWordFromFileObj.searchWord();


    }

    public static void main(String args[])throws IOException{
        new algorithmicProgramsDriver();
    }
}
