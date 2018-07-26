/**
 * 
 */
package com.training.objectOrientedProgramming;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.training.utility.InputScanner;

/**
 * @author brucewilliamwaynes
 *
 */
public class RegexUsageDemonstration {
	
	private static String inputText;
	
	RegexUsageDemonstration(){
		inputText = "";
	}
	
	public static void setInputText(String inputString){
		inputText = inputString;
	}
	
	private static void replaceUserNameFull(String userName){
				inputText =  InputScanner.replaceStringUsingRegex(inputText, userName, "<<full name>>");
	}
	
	private static void replaceFirstName(String firstName) {
		// TODO Auto-generated method stub
		inputText = InputScanner.replaceStringUsingRegex(inputText, firstName, "<<name>>");
	}
	
	private static void replacePhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		inputText = InputScanner.replaceStringUsingRegex(inputText, phoneNumber, "XXXXXXXXXX");
	}
	
	private static void replaceDate(){
		//getting current Date
		Date currentDate = new Date();
		//Formatting date in given format
		SimpleDateFormat formatDate = new SimpleDateFormat("MM-dd-YYYY");
		String replaceWithString = String.valueOf(formatDate.format(currentDate));
		inputText = InputScanner.replaceStringUsingRegex(inputText, replaceWithString,"01/01/2016");
	}
	
	public static void regexDemo() throws FileNotFoundException{
		
		InputScanner inputScannerObj = new InputScanner();
		
		String inputString = InputScanner.readInputFromFile();
		setInputText(inputString);
		
		System.out.println("Enter Full User Name ");
		String userNameFull = inputScannerObj.inputString();
		String firstName = userNameFull.substring(0, userNameFull.indexOf(' ') + 1);
		
		System.out.println("Enter your 10 digit mobile number!");
		String phoneNumber = inputScannerObj.inputString();
		
		/*
		 * Replacing name , full name , phone number and date sequentially
		 */
		replaceFirstName(firstName);
		replaceUserNameFull(userNameFull);
		replacePhoneNumber(phoneNumber);
		replaceDate();
		
		System.out.println(inputText);
		
	}
}
