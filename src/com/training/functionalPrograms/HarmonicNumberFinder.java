package com.training.functionalPrograms;

import com.training.utility.InputScanner;

public class HarmonicNumberFinder {

    private int limit;

    public HarmonicNumberFinder(){
        this.limit = 0;
    }

    public void findHarmonicNumber() {

        InputScanner inputScannerObj = new InputScanner();
        HarmonicNumberFinder harmonicNumberFinderObj = new HarmonicNumberFinder();

        System.out.println("Enter a valid limit!");
        harmonicNumberFinderObj.limit = inputScannerObj.inputInteger();

        double harmonicNumber = 0.0;

        for(int i=1;i<=harmonicNumberFinderObj.limit;i++) {
            harmonicNumber += ((double)1/(double)i);
        }

        System.out.println("N'th Harmonic Number "+ harmonicNumber);
    }
}
