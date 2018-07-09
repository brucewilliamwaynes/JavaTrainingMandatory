package com.training.functionalPrograms;

import com.training.utility.InputScanner;

public class QuadraticEquation {
    private int coefficientOfSqaure;
    private int coefficentOfLinear;
    private int constant;

    QuadraticEquation(){
        this.coefficentOfLinear = 0;
        this.coefficientOfSqaure = 0;
        this.constant = 0;
    }

    public void quadraticEqautionSolver(){
        InputScanner inputScannerObj = new InputScanner();
        QuadraticEquation quadraticEquationObj = new QuadraticEquation();

        System.out.println("Enter values for A,B,C in ax*x + bx + c!");
        quadraticEquationObj.coefficientOfSqaure = inputScannerObj.inputInteger();
        quadraticEquationObj.coefficentOfLinear =  inputScannerObj.inputInteger();
        quadraticEquationObj.constant = inputScannerObj.inputInteger();

        int delta = (quadraticEquationObj.coefficentOfLinear * quadraticEquationObj.coefficentOfLinear) - (4 * quadraticEquationObj.coefficientOfSqaure * quadraticEquationObj.constant);
//        System.out.println(delta);
        if(delta < 0)
            delta = -delta;
//        System.out.println(Math.round(Math.sqrt((double) delta)));
        double root1 = ((-1*quadraticEquationObj.coefficentOfLinear) + Math.round(Math.sqrt((double) delta))) / (2 * quadraticEquationObj.coefficientOfSqaure);
        double root2 = ((-1*quadraticEquationObj.coefficentOfLinear) - Math.round(Math.sqrt((double) delta))) / (2 * quadraticEquationObj.coefficientOfSqaure);

        System.out.println("The Roots of the Expression :" + quadraticEquationObj.coefficientOfSqaure + "x*x + " + quadraticEquationObj.coefficentOfLinear + "x + " + quadraticEquationObj.constant + "are-->" + root1 + " & " + root2);
    }
}
