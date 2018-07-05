package com.training.functionalPrograms;

import com.training.utility.InputScanner;

public class PrimeFactorFinder {

    private int number;

    public PrimeFactorFinder(){
        this.number = 0;
    }

    public void findPrimeFactor(){
        InputScanner inputScannerObj = new InputScanner();
        PrimeFactorFinder primeFactorFinderObj = new PrimeFactorFinder();

        System.out.println("Enter number to find Prime Factors!");

        primeFactorFinderObj.number = inputScannerObj.inputInteger();

        int flag = 0;

        while(primeFactorFinderObj.number % 2 == 0){
            if(flag == 0)
                System.out.println("2");
            flag = 1;
            primeFactorFinderObj.number /= 2;
        }

        for(int i=3;(i)<=primeFactorFinderObj.number;i+=2){
            flag = 0;
            while(primeFactorFinderObj.number % i == 0){
                if(flag == 0)
                    System.out.println(i);
                flag = 1;
                primeFactorFinderObj.number /= i;
            }
        }
    }
}
