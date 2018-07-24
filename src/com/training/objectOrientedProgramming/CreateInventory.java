package com.training.objectOrientedProgramming;

import com.training.utility.InputScanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/*
JSON Parsing using simpleJSON Object
Creating a JSON of Inventory including attributes as name / weight / $ per kg for each one of Rice , Pulse and Wheat.
 */
public class CreateInventory {

    private JSONObject inventoryObj;
    private JSONArray riceArray;
    private JSONArray wheatArray;
    private JSONArray pulseArray;
    private String categoryValue;

    CreateInventory(){
        this.inventoryObj = new JSONObject();
        this.riceArray = new JSONArray();
        this.wheatArray = new JSONArray();
        this.pulseArray = new JSONArray();
        this.categoryValue = "Rice,Wheat,Pulse";
    }

    private void initializeRiceInventory(){
        /*
//        Using Custom Map to work with Inventory
        OrderedMapCustom<String,String> myCustomMap = new OrderedMapCustom<String, String>();
        InputScanner.getInventoryDetails(myCustomMap);
        riceObj.put("Rice",myCustomMap);
        */
        Map myMap = new LinkedHashMap(3);
        InputScanner.getInventoryDetails(myMap);
        this.riceArray.add(myMap);
    }


    private void initializeWheatInventory(){
        Map myMap = new LinkedHashMap(3);
        InputScanner.getInventoryDetails(myMap);
        this.wheatArray.add(myMap);
    }


    private void initializePulseInventory(){
        Map myMap = new LinkedHashMap(3);
        InputScanner.getInventoryDetails(myMap);
        this.pulseArray.add(myMap);
    }

    public void initializeInventory(int choice){
        InputScanner inputScannerObj = new InputScanner();
        String s = inputScannerObj.inputString();
        switch (choice){
            case 1:initializeRiceInventory();
                    this.inventoryObj.put(s,this.riceArray);
                    break;
            case 2:initializeWheatInventory();
                this.inventoryObj.put("Wheat",this.wheatArray);
                break;
            case 3:initializePulseInventory();
                this.inventoryObj.put("Pulse",this.pulseArray);
                break;
        }
    }

    public boolean isItemPresentInInventory(String itemName,JSONArray itemArray){
        Iterator itemIterator = itemArray.iterator();
        Iterator<Map.Entry> mapIterator;
        while(itemIterator.hasNext()){
            mapIterator = ((Map)itemIterator.next()).entrySet().iterator();
            while (mapIterator.hasNext()){
                Map.Entry pair = mapIterator.next();
                if(String.valueOf(pair.getKey()).compareTo("name") == 0 && String.valueOf(pair.getValue()).compareTo(itemName) == 0)
                    return true;
            }
        }
        return false;
    }

    public double calculateValueOfItem(String itemName,JSONArray itemArray){
        double value = 0.0;
        Iterator itemIterator = itemArray.iterator();
        Iterator<Map.Entry> mapIterator;
        while(itemIterator.hasNext()) {
            mapIterator = ((Map) itemIterator.next()).entrySet().iterator();
            while (mapIterator.hasNext()) {
                Map.Entry pair = mapIterator.next();
                if (String.valueOf(pair.getKey()).compareTo("name") == 0 && String.valueOf(pair.getValue()).compareTo(itemName) == 0) {
                    Map.Entry weightItem = mapIterator.next();
                    Map.Entry valueItem = mapIterator.next();
                    value = Double.valueOf(String.valueOf(weightItem.getValue())) * Double.valueOf(String.valueOf(valueItem.getValue()));
                    break;
                }
            }
        }
        return value;
    }

    public void processItemOfCategory(JSONArray categoryItemArray){
        InputScanner inputScannerObj = new InputScanner();
        System.out.println("Enter item to calculate Value!");
        String itemName = inputScannerObj.inputString();
        if(isItemPresentInInventory(itemName,categoryItemArray)){
            System.out.println(calculateValueOfItem(itemName,categoryItemArray));
        }
        else{
            System.out.println("Oops! Item cannot be found!");
        }
    }

    public void workingWithInventory() {
        InputScanner inputScannerObj = new InputScanner();
        CreateInventory createInventoryObj = new CreateInventory();
        String choice;
        String type = "";
        while (true){
            System.out.println("Enter 1 to read Inventory details from file, 2 To write Inventory details to file, 3 to create Inventory,4 to calculate value for inventory, 0 to Exit!");
            choice = inputScannerObj.inputString();
            if(choice.compareTo("1") == 0){
                //Read from JSON
            }
            else if(choice.compareTo("2") == 0){
                //Write to File in JSON format
                String fileDestination = InputScanner.createJSON(createInventoryObj.inventoryObj);
            }
            else if(choice.compareTo("3") == 0) {
                do {
                    System.out.println("Enter 1 to initialize details for Rice, 2 for Wheat, 3 for Pulses !");
                    type = inputScannerObj.inputString();
                } while (type.compareTo("1") < 0 || type.compareTo("3") > 0);
                createInventoryObj.initializeInventory(Integer.valueOf(type));
            }
            else if(choice.compareTo("4") == 0){
                String categoryName;
                do {
                    System.out.println("Enter category of inventory to calculate value!" + createInventoryObj.categoryValue);
                    categoryName = inputScannerObj.inputString();
                }while(!createInventoryObj.inventoryObj.containsKey(categoryName));
                JSONArray categoryItemArray = (JSONArray) createInventoryObj.inventoryObj.get(categoryName);
                createInventoryObj.processItemOfCategory(categoryItemArray);
            }
            else
                break;
        }
    }
}
