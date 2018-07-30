/**
 * 
 */
package com.training.sampleClassTypes;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author bridgelabz
 *
 */
public class Validation {
	
	private  static JSONObject validateInJSONFile(JSONObject fileJSONObj, String searchKey, String searchValue){
		for(Object key : fileJSONObj.keySet()){
			JSONObject element = (JSONObject)fileJSONObj.get(key);
			if(element.get(searchKey).equals(searchValue))
				return element;
		}
		return null;
	}
	
	
	public static boolean isUserACustomer(JSONObject customerJSON, String userName){
		if(validateInJSONFile(customerJSON,"Name",userName) != null)
			return true;
		return false;
	}
	
	public static boolean isPhoneNumberCorrect(JSONObject customerJSON, String phoneNumber ){
		if(validateInJSONFile(customerJSON,"PhoneNumber",phoneNumber) != null)
			return true;
		return false;
	}
	
	
	
	public static boolean doesStockExist(ArrayList<Stock> stockList,String stockName){
		for(Stock stockElement : stockList){
			if(stockElement.getStockName().compareTo(stockName) == 0)
				return true;
		}
		return false;
	}
	
	public static Stock searchStock(ArrayList<Stock> stockList, String stockName) {
		// TODO Auto-generated method stub
		for(Stock stockElement : stockList){
			if(stockElement.getStockName().compareTo(stockName) == 0)
				return stockElement;
		}
		return null;
	}
	
	
	/*
	public static Customer searchCustomer(JSONObject customerJSON,String userName){
		return validateInJSONFile(customerJSON,"Name",userName);
	}
	*/
	
	public static boolean validateUserName(ArrayList<Customer> customerList,String name){
		for(Customer customer : customerList){
			if(customer.getName().compareTo(name) == 0)
				return true;
		}
		return false;
	}

	public static boolean validatePhoneNumber(ArrayList<Customer> customerList,String phoneNumber){
		for(Customer customer : customerList){
			if(customer.getMobileNumber().compareTo(phoneNumber) == 0)
				return true;
		}
		return false;
	}
	
	public static Customer searchCustomer(ArrayList<Customer> customerList, String name,String phoneNumber) {
		// TODO Auto-generated method stub
		for(Customer customer : customerList){
			if(customer.getName().compareTo(name) == 0 && customer.getMobileNumber().compareTo(phoneNumber) == 0)
				return customer;
		}
		return null;
	}
	
	
}
