package com.training.functionalPrograms;

import com.training.utility.InputScanner;

/*
* Learning How to Replace String
* */
public class UserName {

    private String templateString;

    public UserName(){
        this.templateString = "Hello <<UserName>> , How are you ?";
    }

    public void showUserName(){
        System.out.println("Enter UserName !");
        //Object of Utility Class that encapsulates Input Methodology
        InputScanner inputScannerObj = new InputScanner();

        //Using User Defined Methods in Utility Class
        String userName = inputScannerObj.inputString();

        //Using replaceString in Utility Class
        this.templateString = inputScannerObj.replaceString(this.templateString,"<<UserName>>",userName);
        System.out.println(this.templateString);
    }
}
