package com.training.dataStructurePrograms;

import com.training.utility.InputScanner;
import com.training.utility.Stack;

public class BalancedExpression {
    private String inputExpression;
    BalancedExpression(){
        this.inputExpression = "";
    }

    public static boolean isBalancedExpression(String inputExpression){

        Stack<String> myStack = new Stack<String>();

        for(int i=0;i<inputExpression.length();i++){
            if(inputExpression.charAt(i) == '('){
                myStack.push("(");
            }
            else if(inputExpression.charAt(i) == ')'){
                myStack.pop();
            }
        }
        if(myStack.isEmpty()){
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
