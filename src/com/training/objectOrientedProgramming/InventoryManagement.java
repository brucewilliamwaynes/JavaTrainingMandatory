/**
 * 
 */
package com.training.objectOrientedProgramming;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;

import com.training.sampleClassTypes.Inventory;
import com.training.utility.InputScanner;

/**
 * @author brucewilliamwaynes
 *
 */
public class InventoryManagement {
	
	
	
	public static void main(String args[])throws Exception{
		JSONObject fileJSONObj = InputScanner.readJSONFromFile();
		ArrayList<ArrayList<Inventory>> inventoryObjectList = new ArrayList<ArrayList<Inventory>>();
		inventoryObjectList = InventoryFactory.buildInventoryList(fileJSONObj);
		
	}
}
