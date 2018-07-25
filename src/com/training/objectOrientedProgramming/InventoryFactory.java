package com.training.objectOrientedProgramming;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.training.utility.InputScanner;

public class InventoryFactory {
	public  static ArrayList<CreateInventory> createInventoryObjects() throws Exception{
		JSONObject inventoryObj = InputScanner.readJSONFromFile();
		ArrayList<CreateInventory> inventoryObjectList = new ArrayList<CreateInventory>();
		int index = 0;
		for(Object key : inventoryObj.keySet()){
			inventoryObjectList.add((CreateInventory) key);
		}
		return inventoryObjectList;
	}
}
