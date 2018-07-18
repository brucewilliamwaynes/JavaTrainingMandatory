package com.training.dataStructurePrograms;

import com.training.utility.InputScanner;
import com.training.utility.StackCustom;

public class BalancedExpression {
    private String inputExpression;
    BalancedExpression(){
        this.inputExpression = "";
    }

    public static boolean isBalancedExpression(String inputExpression){

        StackCustom<String> myStackCustom = new StackCustom<String>();

        for(int i=0;i<inputExpression.length();i++){
            if(inputExpression.charAt(i) == '('){
                myStackCustom.pushCustomStack("(");
            }
            else if(inputExpression.charAt(i) == ')'){
                myStackCustom.popCustomStack();
            }
        }
        if(myStackCustom.isEmptyCustomStack()){
            return true;
        }
        return false;
    }

    public void isBalancedExpressionChecker(){
        InputScanner inputScannerObj = new InputScanner();
        BalancedExpression balancedExpressionObj = new BalancedExpression();
        System.out.println("Enter the expression !");
        balancedExpressionObj.inputExpression = inputScannerObj.inputString();

        if(isBalancedExpression(balancedExpressionObj.inputExpression)){
            System.out.println("TRUE");
        }
        else
            System.out.println("FALSE");
    }
}
