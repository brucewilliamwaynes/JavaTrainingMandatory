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

    public void findPalindromPrimeAnagrams(){
        InputScanner inputScannerObj = new InputScanner();
        PrimeAnagramPalindrome primeAnagramPalindromeObj = new PrimeAnagramPalindrome();

        System.out.println("Enter lower Limit of the search");
        primeAnagramPalindromeObj.lowerLimit = inputScannerObj.inputInteger();

        System.out.println("Enter upper limit of the search!");
        primeAnagramPalindromeObj.upperLimit = inputScannerObj.inputInteger();



        HashMap<String, String> myHashMap = new HashMap<String, String>();
        for(int i = primeAnagramPalindromeObj.lowerLimit; i <= primeAnagramPalindromeObj.upperLimit; i++){
            if(CommonAlgorithms.isPrime(i) && CommonAlgorithms.isPallindromeForInteger(i)) {
                System.out.println(i);
            }
            if(CommonAlgorithms.isPrime(i)){
                myHashMap.put(String.valueOf(i), "1" );

                for( HashMap.Entry<String, String> nextElement : myHashMap.entrySet()){
                    if(CommonAlgorithms.isAnagramForInteger(Integer.parseInt(nextElement.getKey()),i))
                        System.out.println(i + " " + nextElement.getKey());
                }
            }
        }

    }
}
