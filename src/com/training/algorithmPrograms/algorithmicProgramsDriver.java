package com.training.algorithmPrograms;

import com.training.utility.CommonAlgorithms;

public class algorithmicProgramsDriver {

    algorithmicProgramsDriver(){

        /*
        CheckAnagram checkAnagramObj = new CheckAnagram();
        checkAnagramObj.anagramFinder();

        CommonAlgorithms.PrimeNumbersInRange(0,1000);

        */

        PrimeAnagramPalindrome primeAnagramPalindromeObj = new PrimeAnagramPalindrome();
        primeAnagramPalindromeObj.findPallindromPrimeAnagrams();



//        System.out.println(CommonAlgorithms.isPallindromeForInteger(121));
    }

    public static void main(String args[]){
        new algorithmicProgramsDriver();
    }
}
