package com.training.functionalPrograms;
import com.training.utility.InputScanner;

//import java.util.Scanner;
public class CoinFlips {

    private int numberOfFlips;
    private int countTails;

    public CoinFlips(){
        this.numberOfFlips = 0;
        this.countTails = 0;
    }

    public void calculateTailsCount(){
        double randomNumber;
        for(int i=1;i<=this.numberOfFlips;i++) {
            randomNumber = Math.random();
            //System.out.println(randomNumber);
            if(randomNumber < 0.5) {
                this.countTails += 1;
            }
        }
    }

    public double calcTailPercentage(){
        return ((((double)this.countTails)/(double)this.numberOfFlips)*100);
    }

    public void displayCoinFlips(){
        System.out.println("Enter number of flips.");

        CoinFlips coinFlipsObj = new CoinFlips();

        InputScanner inputScannerObj = new InputScanner();
        coinFlipsObj.numberOfFlips = inputScannerObj.inputInteger();

        coinFlipsObj.calculateTailsCount();

        System.out.println("Heads percentage "+ (100.00-(coinFlipsObj.calcTailPercentage())));
        System.out.println("Tails percentage "+ coinFlipsObj.calcTailPercentage());
    }
}