package com.training.dataStructurePrograms;

import java.io.IOException;

public class dataStructureDriver {
    public static void main(String args[]) throws IOException{
        /*Question UnOrdered LinkList*/
        /*
        SearchUsingCustomList searchUsingCustomListObj = new SearchUsingCustomList();
        searchUsingCustomListObj.displayResultOfSearch();
        */
        /*
        SearchUsingOrderedList searchUsingOrderedListObj = new SearchUsingOrderedList();
        searchUsingOrderedListObj.displaySearchedNumber();
        */
        /*
        BalancedExpression balancedExpressionObj = new BalancedExpression();
        balancedExpressionObj.isBalancedExpressionChecker();
        */
        /*
        BankQueue bankQueueObj = new BankQueue();
        bankQueueObj.simulateBankQueue();
        */
        /*
        PalindromeChecker palindromeCheckerObj = new PalindromeChecker();
        palindromeCheckerObj.palindromeValidator();
        */
        /*
        InputScanner inputScannerObj = new InputScanner();
        System.out.println("Enter number of elements of Map!");
        int n = inputScannerObj.inputInteger();
        OrderedMapCustom<Integer,Integer> myHashMap = new OrderedMapCustom<Integer, Integer>();
        for(int i=0;i<n;i++){
            System.out.println("Enter a number to  insert!");
            int number = inputScannerObj.inputInteger();
            myHashMap.addElementToHashMap((number%11),number);
        }
        myHashMap.displayHashedMap();
        */
        NumberInASlot numberInASlotObj = new NumberInASlot();
        numberInASlotObj.findKeyOfNumber();
    }
}
