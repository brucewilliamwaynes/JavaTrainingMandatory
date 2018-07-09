package com.training.algorithmPrograms;

import com.training.utility.CommonAlgorithms;
import com.training.utility.InputScanner;

import java.util.HashMap;

public class PrimeAnagramPalindrome {
    private int lowerLimit;
    private int upperLimit;

    PrimeAnagramPalindrome(){
        this.lowerLimit = 0;
        this.upperLimit = 0;
    }
    public void findPallindromPrimeAnagrams(){
        InputScanner inputScannerObj = new InputScanner();
        PrimeAnagramPalindrome primeAnagramPalindromeObj = new PrimeAnagramPalindrome();

        System.out.println("Enter lower Limit of the search");
        primeAnagramPalindromeObj.lowerLimit = inputScannerObj.inputInteger();

        System.out.println("Enter upper limit of the search!");
        primeAnagramPalindromeObj.upperLimit = inputScannerObj.inputInteger();



        HashMap<String, String> myHashMap = new HashMap<String, String>();
        for(int i = lowerLimit; i <= upperLimit; i++){
            if(CommonAlgorithms.isPallindromeForInteger(i)){
                System.out.println(i);
            }
            if(CommonAlgorithms.isPrime(i) && CommonAlgorithms.isPallindromeForInteger(i)){

                myHashMap.put(String.valueOf(i), "1" );

                System.out.println(i);

                for( HashMap.Entry<String, String> nextElement : myHashMap.entrySet()){
                    if(CommonAlgorithms.isAnagram(nextElement.getKey(),String.valueOf(i)))
                        System.out.println(nextElement.getKey() + " " + i);
                }
            }
        }

    }
}
