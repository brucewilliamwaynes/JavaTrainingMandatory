/**
 * 
 */
package com.training.sampleClassTypes;

import org.json.simple.JSONObject;

import com.training.utility.InputScanner;

/**
 * @author bridgelabz
 *
 */
public class StockAccount {

	/**
	 * @param args
	 */
	private static JSONObject shareJSON;
	
	public StockAccount() throws Exception{
		shareJSON = InputScanner.readJSONFromFile();
	}
	
	public static void processCustomer(Customer customerNew){
		String choice = null;	
		InputScanner sc = new InputScanner();
		do{
			System.out.println("Enter 1 to Buy Share,2 To Sell Share, 3 to find Evaluation of customer, 4 to save the details ");
			if(choice == "1"){
				System.out.println("Enter name of Stock!");
				String stockName = sc.inputString();
				
				if(!Validation.doesStockExist(shareJSON, stockName)){
					continue;
				}
				
				System.out.println("Enter number of shares you want to buy!");
				int numberOfShares = sc.inputInteger();
				
			
			}
			else if(choice == "2"){
				
			}
			else if (choice == "3"){
				
			}
			else if (choice == "4"){
				
			}
			else {
				System.out.println("Wrong choice! Please enter a valid choice!");
			}
		}while(!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4")) ;
	}
}
