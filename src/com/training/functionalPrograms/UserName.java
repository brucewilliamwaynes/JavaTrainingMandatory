package com.training.functionalPrograms;

import com.training.utility.InputScanner;


public class UserName {

    private String templateString;

    public UserName(){
        this.templateString = "Hello <<UserName>> , How are you ?";
    }

    public void showUserName(){
        System.out.println("Enter UserName !");
        InputScanner inputScannerObj = new InputScanner();
        String userName = inputScannerObj.inputString();
        this.templateString = inputScannerObj.replaceString(this.templateString,"<<UserName>>",userName);
        System.out.println(this.templateString);
    }
}
