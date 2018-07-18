package com.training.dataStructurePrograms;

import com.training.utility.DequeueCustom;
import com.training.utility.InputScanner;

public class PalindromeChecker {
    private String inputString;
    PalindromeChecker(){
        this.inputString = "";
    }

    public static boolean isPalindrome(DequeueCustom<Character> letters){
        if(letters.isEmptyDeQueue()){
            return true;
        }
        else{
            do{
            if(letters.peekFrontDeQueue().compareTo(letters.peekRearDeQueue()) != 0)
                return false;
            letters.removeFrontDeQueue();
            letters.removeRearDeQueue();
            }while(!letters.isEmptyDeQueue() && letters.sizeDeQueue() != 1);
            return true;
        }
    }

    public void pallindromeValidator(){
        InputScanner inputScannerObj  = new InputScanner();
        PalindromeChecker palindromeCheckerObj = new PalindromeChecker();
        System.out.println("Enter a string to check for Palindrome!");
        palindromeCheckerObj.inputString = inputScannerObj.inputString();
        DequeueCustom<Character> letters = new DequeueCustom<Character>();
        for(int i=0;i<palindromeCheckerObj.inputString.length();i++)
            letters.addRearDeQueue(palindromeCheckerObj.inputString.charAt(i));
        if(isPalindrome(letters))
            System.out.println("Duh ! " + palindromeCheckerObj.inputString + " is a palindrome!");
        else
            System.out.println("Opps! " + palindromeCheckerObj.inputString + " isn't a palindrome!");

    }
}
