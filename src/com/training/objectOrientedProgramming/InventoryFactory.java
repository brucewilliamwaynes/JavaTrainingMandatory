package com.training.objectOrientedProgramming;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.training.sampleClassTypes.Inventory;
import com.training.utility.InputScanner;

public class InventoryFactory {
	/*
	 * buildInventoryList : Takes in JSONObject of complete JSON file and then creates 2D arrayList of Inventory type , for items with variety(ArrayList Containing variety in List) and without variety(Only 1 Item in variety!)!
	 */
	public static ArrayList<ArrayList<Inventory>> buildInventoryList(JSONObject fileJSONObj){
		//2DArrayList holding Inventory objects for particular item
		//items of same category but different variety are stored in the second dimension , say rice having variety "basmati" and "brown rice" (JSONArray input type)
		//items having just one variety , stored as 1 element in second dimension , say wheat (JSONObject)
		ArrayList<ArrayList<Inventory>> inventoryObjectList = new ArrayList<ArrayList<Inventory>>();
 		/*
 		 * Iterating through each object within fileObject to check whether it is a JSONArray or JSONObject
 		 */
		for(Object key : fileJSONObj.keySet()){
			/*
			 * If JSONArray then create an array containing all the Inventory Object for each of variety 
			 */
			ArrayList<Inventory> jsonArrayList;
			//if(fileJSONObj.get(key).getClass().getName().compareTo("org.json.simple.JSONArray") == 0){
				if(fileJSONObj.get(key) instanceof JSONArray){
//				System.out.println("Array and Variety!");	
				JSONArray categoryArray =  (JSONArray)fileJSONObj.get(key);
				/*
				 * To fill up individual second dimension for JSONArray
				 */
				jsonArrayList = new ArrayList<Inventory>();
				/*
				 * Iterating through JSONArray to be able to Map from JSONArray to ArrayList<Inventory> 
				 */
				for(int i=0;i<categoryArray.size();i++){
						Inventory element = new Inventory();
						JSONObject itemList = (JSONObject) categoryArray.get(i);
						/*
						 * Mapping JSONObject to Inventory Object
						 */
						element.setName((String) itemList.get("name"));
						element.setrate(Double.parseDouble((String)itemList.get("price")));
						element.setWeight(Double.parseDouble((String)itemList.get("weight")));
						/*
						 * Adding mapped One element to Inventory ArrayList
						 */
						jsonArrayList.add(i, element);
					}
				
			}
			else{
//				System.out.println("Object no variety!");
				/*
				 * Creating Inventory Element and adding it as onto second dimension as one object only
				 */
				Inventory element = new Inventory();
				/*
				 * Mapping between JSONObject and Inventory Object
				 */
				JSONObject itemList = (JSONObject)fileJSONObj.get(key);
				jsonArrayList = new ArrayList<Inventory>();
				
				element.setName((String)itemList.get("name"));
				element.setrate(Double.parseDouble((String)itemList.get("price")));
				element.setWeight(Double.parseDouble((String)itemList.get("weight")));
				/*
				 * Adding mapped Inventory Element to List
				 */
				jsonArrayList.add(element);
			}
			/*
				 * Adding the ArrayList<Inventory> to the main list of inventory objects!
			*/
			inventoryObjectList.add(jsonArrayList);
		}
		return inventoryObjectList;
	}
}
