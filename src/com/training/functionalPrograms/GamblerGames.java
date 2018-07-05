package com.training.functionalPrograms;

import com.training.utility.InputScanner;

public class GamblerGames {

    private double randomNumber;
    private int stake;
    private int goal;
    private int numberOfTimes;
    private int numberOfWins;
    private int numberOfBets;
    private String betStatus;

    public GamblerGames(){
        this.randomNumber = 0.0;
        this.goal = 0;
        this.stake = 0;
        this.numberOfTimes = 0;
        this.numberOfWins = 0;
        this.numberOfBets = 0;
        this.betStatus = "";
    }

    public int calcEachRoundDetail(){

        InputScanner inputScannerObj = new InputScanner();

        int stakeCopy = this.stake;

        while(stakeCopy > 0 && stakeCopy < this.goal) {

            System.out.println("Do you want to place a Bet ? Yes or No ?");

            this.betStatus = inputScannerObj.inputString();
            this.betStatus = this.betStatus.toLowerCase();

            if (this.betStatus.compareTo("yes") == 0) {

                this.numberOfBets += 1;

                System.out.println("Bet Placed ! Fortune Wheel is spinning !");

                this.randomNumber = inputScannerObj.findRandomWithoutRange();

                if (this.randomNumber > 0.5) {
                    System.out.println("You Won the Bet");
                    stakeCopy += 1;
                }

                else{
                    System.out.println("Oh! You lost the Bet! Please play again!");
                    stakeCopy  -= 1;
                }
            }

            else if(this.betStatus.compareTo("no") == 0) {
                System.out.println("You will be charged fee for the round!");
                stakeCopy -= 1;
            }

            else{
                System.out.println("Enter either YES or NO!");
            }

        }

        return stakeCopy;
    }

    public void findGamblingDetails(){

        for(int i=0;i<this.numberOfTimes;i++){

            int stakeCopy = this.calcEachRoundDetail();

            if(stakeCopy == this.goal){
                System.out.println("Congratulations You Won the Round!");
                this.numberOfWins += 1;
            }

            if(stakeCopy == 0){
                System.out.println("Sorry ! You lost all your money for the Round!");
            }
        }
    }

    public void displayGamblingDetails(){

        InputScanner inputScannerObj = new InputScanner();
        GamblerGames gamblerGamesObj = new GamblerGames();

        System.out.println("Enter $Stake, $Goal , Number Of Rounds you want to Suffer!");

        gamblerGamesObj.stake = inputScannerObj.inputInteger();
        gamblerGamesObj.goal = inputScannerObj.inputInteger();
        gamblerGamesObj.numberOfTimes = inputScannerObj.inputInteger();

        gamblerGamesObj.findGamblingDetails();

        System.out.println("Total Wins :" + gamblerGamesObj.numberOfWins);
        System.out.println("Total Bets Placed: " + gamblerGamesObj.numberOfBets);
        System.out.println("Win Percentage :" + inputScannerObj.calculatePercentage(gamblerGamesObj.numberOfWins,gamblerGamesObj.numberOfTimes));
        System.out.println("Loss Percentage :" + (100.00 - inputScannerObj.calculatePercentage(gamblerGamesObj.numberOfWins,gamblerGamesObj.numberOfTimes)));
    }
}
