package com.training.algorithmPrograms;

import com.training.utility.CommonAlgorithms;
import com.training.utility.InputScanner;

public class MonthlyPaymentAux {
    private double principal;
    private double rate;
    private int years;
    MonthlyPaymentAux(){
        this.principal = 0.0;
        this.rate = 0.0;
        this.years = 0;
    }

    public void calculateMonthlyPayment(){
        InputScanner inputScannerObj = new InputScanner();
        MonthlyPaymentAux monthlyPaymentAuxObj = new MonthlyPaymentAux();

        System.out.println("Enter Principal amount , number of years and rate of interest  !");
        monthlyPaymentAuxObj.principal = inputScannerObj.inputDouble();
        monthlyPaymentAuxObj.years = inputScannerObj.inputInteger();
        monthlyPaymentAuxObj.rate = inputScannerObj.inputDouble();

        System.out.println("Payments Needed to make :" + CommonAlgorithms.monthlyPayment(monthlyPaymentAuxObj.principal,monthlyPaymentAuxObj.years,monthlyPaymentAuxObj.rate));
    }
}
