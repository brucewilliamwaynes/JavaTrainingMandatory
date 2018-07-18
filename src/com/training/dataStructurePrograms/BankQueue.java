package com.training.dataStructurePrograms;

import com.training.utility.InputScanner;
import com.training.utility.QueueCustom;

public class BankQueue {
    private double totalCashBalance;

    BankQueue(){
        this.totalCashBalance = 0.0;
    }

    public void addMoney(QueueCustom<Double> queueOfAmount){
        InputScanner inputScannerObj = new InputScanner();
        System.out.println("Enter amount to Add!");
        double money = inputScannerObj.inputDouble();
        queueOfAmount.enQueueCustom(money);
    }

    public void removeMoney(QueueCustom<Double> queueOfAmount){
        InputScanner inputScannerObj = new InputScanner();
        System.out.println("Enter amount to withdraw!");
        double money = inputScannerObj.inputDouble();
        queueOfAmount.enQueueCustom(-money);
    }

    public void addPerson(QueueCustom<Double> queueOfAmount){
        InputScanner inputScannerObj = new InputScanner();
        System.out.println("Enter W for Withdrawal or D for Deposit!");
        String inputChoice = inputScannerObj.inputString();
        if(inputChoice.compareTo("D") == 0){
            addMoney(queueOfAmount);
        }
        else if(inputChoice.compareTo("W") == 0){
            removeMoney(queueOfAmount);
        }
        else{
            System.out.println("Enter right choice !");
        }
    }

    public void findBalance(QueueCustom<Double> queueOfAmount){

    }

    public void simulateBankQueue(){
        InputScanner inputScannerObj = new InputScanner();
        BankQueue bankQueueObj = new BankQueue();

        QueueCustom<Double> queueOfAmount = new QueueCustom<Double>();
        String inputStop;
        do {
            System.out.println("Enter A to Add Person or T for Transaction or E to Exit!");
            inputStop = inputScannerObj.inputString();
            if(inputStop.compareTo("A") == 0){
                bankQueueObj.addPerson(queueOfAmount);
            }
            else if(inputStop.compareTo("T") == 0){
//                bankQueueObj.performTransaction();
            }
            else
                break;
        }while (inputStop.compareTo("E") != 0);
    }
}
