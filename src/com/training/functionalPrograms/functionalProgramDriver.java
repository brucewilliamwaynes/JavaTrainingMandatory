package com.training.functionalPrograms;
import java.io.*;

public class functionalProgramDriver {
    public functionalProgramDriver() {
        /*
        UserName userNameObj = new UserName();
        userNameObj.showUserName();

        CoinFlips coinFlipsObj = new CoinFlips();
        coinFlipsObj.displayCoinFlips();
        */
        CheckLeapYear checkLeapYearObj = new CheckLeapYear();
        checkLeapYearObj.checkLeapYear();
    }
/*


    public void powerOfDos() {
        Scanner sc = new Scanner(System.in);
        int N;
        do {
            System.out.println("Enter valid range!");
            N = sc.nextInt();
        }while(N>31 || N < 0);
        for(int i=0;i<N;i++) {
            System.out.println((int)(Math.pow(2,i)));
        }
    }

    public void findHarmonicNumber() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double harmonicNumber;
        for(int i=1;i<=N;i++) {
            harmonicNumber += (double)((double)1/(double)i);
        }
        System.out.println("N'th Harmonic Number "+ harmonicNumber);
    }
*/
    public static void main(String args[]){
            new functionalProgramDriver();
    }
}
