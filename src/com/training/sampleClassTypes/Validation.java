/**
 * 
 */
package com.training.sampleClassTypes;

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
	public static boolean doesStockExist(JSONObject shareJSON, String stockName){
		if(validateInJSONFile ( shareJSON, "CompanyName", stockName) != null)
			return true;
		return false;
	}
	/*
	public static Customer searchCustomer(JSONObject customerJSON,String userName){
		return validateInJSONFile(customerJSON,"Name",userName);
	}
	*/
}
