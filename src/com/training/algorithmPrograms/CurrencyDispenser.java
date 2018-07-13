package com.training.algorithmPrograms;

import com.training.utility.InputScanner;

import java.util.Arrays;

public class CurrencyDispenser {
    private int totalSum;
    private int totalCount;

    CurrencyDispenser(){
        this.totalSum = 0;
    }

    public int  calculateChange(int denomination){
        int temp = this.totalSum / denomination;
        this.totalSum = this.totalSum % denomination;
        return temp;
    }


    public void displayDispensedCurrency(){
        InputScanner inputScannerObj = new InputScanner();
        CurrencyDispenser currencyDispenserObj = new CurrencyDispenser();

        System.out.println("Enter total sum to be returned ! ");
        currencyDispenserObj.totalSum = inputScannerObj.inputInteger();

        int[] denominations = new int[8];

        System.out.println("Enter denominations present!");
        for(int i=0;i<8;i++)
            denominations[i] = inputScannerObj.inputInteger();

        Arrays.sort(denominations);
        int countForEachDenomination;
        for(int i =7;i>=0;i--){
                countForEachDenomination = currencyDispenserObj.calculateChange(denominations[i]);
                if(countForEachDenomination > 0)
                    System.out.println(denominations[i] + "$ Used " + countForEachDenomination);
                currencyDispenserObj.totalCount += countForEachDenomination;

        }
        System.out.println("Total Count of Currency Dispensed ! " + currencyDispenserObj.totalCount);
    }
}
