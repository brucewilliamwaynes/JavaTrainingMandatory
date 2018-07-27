/**
 * 
 */
package com.training.objectOrientedProgramming;

import org.json.simple.JSONObject;

import com.training.sampleClassTypes.Customer;
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
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		JSONObject fileJSONObj = InputScanner.readJSONFromFile();
		InputScanner inputScannerObj = new InputScanner();
		
		System.out.println("Enter Customer Name and Account Number!");
		String name = inputScannerObj.inputString();
		int accNumber = inputScannerObj.inputInteger();
		
		if(!Validation.isUserACustomer(fileJSONObj, name) && !Validation.isAccountNumberCorrect(fileJSONObj, accNumber)){
			createNewUser(fileJSONObj,name,accNumber);
		}
		
	}

	private static void createNewUser(JSONObject fileJSONObj, String name, int accNumber) {
		// TODO Auto-generated method stub
		
	}

}
