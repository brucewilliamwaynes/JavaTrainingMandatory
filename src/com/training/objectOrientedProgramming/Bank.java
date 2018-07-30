/**
 * 
 */
package com.training.objectOrientedProgramming;

import java.util.ArrayList;

import org.json.simple.JSONObject;

import com.training.sampleClassTypes.Customer;
import com.training.sampleClassTypes.Stock;
import com.training.sampleClassTypes.StockAccount;
import com.training.sampleClassTypes.Transaction;
import com.training.sampleClassTypes.Validation;
import com.training.utility.InputScanner;

/**
 * @author bridgelabz
 *
 */
public class Bank {

	/**
	 * @param args
	 * @throws Exception 
	 */
	private static ArrayList<Customer> customerList;
	private static ArrayList<Stock> stockList;
 	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
//		JSONObject customerJSON = InputScanner.readJSONFromFile();
		
		InputScanner inputScannerObj = new InputScanner();
		
		customerList = new ArrayList<Customer>();
		stockList = new ArrayList<Stock>();
		
		
		Customer.updateListInitialize(customerList);
		Stock.updateListInitialize(stockList);
		Transaction.loadTransactionJSON();
		
		System.out.println("Enter Customer Name and Account Number!");
		String name = inputScannerObj.inputString();
		String phoneNumber = inputScannerObj.inputString();
		
		Customer customerNew = null;
		
//		if(!Validation.isUserACustomer(customerJSON, name) && !Validation.isPhoneNumberCorrect(customerJSON, phoneNumber)){
		if(!Validation.validateUserName(customerList, name) && !Validation.validatePhoneNumber(customerList, phoneNumber)){
		
			String balance;
			
			do{
				
				System.out.println("Enter the amount you want to add as opening balance  , minimum 1000$");
				
				balance  = inputScannerObj.inputString();
		
			}while(Double.parseDouble(balance) <1000.0);
			
			customerNew = Customer.createNewUser(name,phoneNumber,balance);
			
			Customer.updateCustomerJSON(customerNew);
			
			Customer.addToCustomerList(customerList, customerNew);
			
			System.out.println("Hello New Customer " + name);
		
		}
		
		String choice = null;
		
		do{
			
			System.out.println("Enter 1 to Work with Customer details, 2 to delete Customer, 3 to display Report in File!!");
			
			choice = inputScannerObj.inputString();
			
			if(choice == "1"){
				
				customerNew = Validation.searchCustomer(customerList, name, phoneNumber);
				
				if(customerNew == null){
					System.out.println("Deatils searched are wrong, Please enter correct details!");
					System.out.println("Enter Customer Name and Account Number!");
					name = inputScannerObj.inputString();
					phoneNumber = inputScannerObj.inputString();
					continue;
				}
				
				StockAccount.processCustomer(customerNew);
				
			}
			else if(choice == "2"){
				
			}
			else if(choice == "3"){
				
			}
			else{
				System.out.println("Invalid Input ! ");
			}
		}while(!choice.equals("1") && !choice.equals("2") && !choice.equals("3"));
	}

	/**
	 * @return the customerList
	 */
	public static ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	/**
	 * @return the stockList
	 */
	public static ArrayList<Stock> getStockList() {
		return stockList;
	}
}
