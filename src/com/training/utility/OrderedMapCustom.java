package com.training.utility;

public class OrderedMapCustom<T extends Comparable<? super T>,E extends Comparable<? super E>>{
    MapElement<T,E> head;
    MapElement<T,E> end;

    public OrderedMapCustom(){
        this.head = null;
        this.end = null;
    }

    public MapElement<T, E> getHead() {
        return this.head;
    }

    public boolean doesKeyExist(T itemKey){
        MapElement<T,E> current = this.head;
        while(current != null){
            if(current.key == itemKey)
                return true;
            current = current.next;
        }
        return false;
    }

    public MapElement<T,E> returnKeyHeadNode(T itemKey){
        MapElement<T,E> current = this.head;
        while (current != null){
            if(current.key == itemKey){
                break;
            }
            current = current.next;
        }
        return current;
    }

    public void addElementToHashMap(T itemKey,E itemValue){
        if(this.head == null){
            this.head = new MapElement<T,E>(itemKey,itemValue);
            this.end = this.head;
        }
        else{
            if(doesKeyExist(itemKey)){
                MapElement<T,E> insertNode = returnKeyHeadNode(itemKey);
//                System.out.println("Same Item Key! " + insertNode.key + " same as input : " + itemKey );
                insertNode.chainList.insertNode(itemValue);
            }
            else{
//                System.out.println("Found New Key :" + itemKey);
                MapElement<T,E> currentMapElement = this.head;
                MapElement<T,E> tempNode = null;
                while(currentMapElement.next != null){
                    if(currentMapElement.key.compareTo(itemKey) > 0)
                        break;
                    tempNode = currentMapElement;
                    currentMapElement = currentMapElement.next;
                }
                if(currentMapElement == this.head){
                    if(currentMapElement.key.compareTo(itemKey) > 0){
                        tempNode = new MapElement<T, E>(itemKey,itemValue);
                        tempNode.next = this.head.next;
                        this.head.next = tempNode;
                    }
                    else {
                        tempNode = new MapElement<T, E>(itemKey, itemValue);
                        tempNode.next = this.head;
                        this.head = tempNode;

                    }
                }
                else if (currentMapElement.next == null){
                    if(currentMapElement.key.compareTo(itemKey) > 0){
                        tempNode.next = new MapElement<T, E>(itemKey,itemValue);
                        tempNode.next.next = currentMapElement;
                    }
                    else {
                        currentMapElement.next = new MapElement<T, E>(itemKey,itemValue);
                        currentMapElement.next.next = null;
                        this.end = currentMapElement.next;
                    }
                }
                else {
                    tempNode.next = new MapElement<T, E>(itemKey,itemValue);
                    tempNode.next.next = currentMapElement;
                }
            }
        }
    }

    public void removeElementFromHashMap(T itemKey,E itemValue){
        MapElement<T,E> currentMapElement = this.head;
        while(currentMapElement != null){
            if(currentMapElement.key == itemKey)
                currentMapElement.chainList.removemNodeElement(itemValue);
            currentMapElement = currentMapElement.next;
        }
    }

    public OrderedMapCustom<Integer, Integer> segregateNumbersIntoFile(String inputString){
        OrderedMapCustom<Integer,Integer> tempMap = new OrderedMapCustom<Integer, Integer>();
        String word = "";
        for(int i=0;i<inputString.length();i++){
            if(inputString.charAt(i) != ','){
                word = word + inputString.charAt(i);
            }
            else{
                Integer numberOfWord = Integer.valueOf(word);
                tempMap.addElementToHashMap(numberOfWord%11,numberOfWord);
                word = "";
            }
        }
        Integer numberOfWord = Integer.valueOf(word.substring(0,word.length()-1));
        tempMap.addElementToHashMap(numberOfWord%11,numberOfWord);
        return tempMap;
    }

    public void displayHashedMap(){
        MapElement<T,E> currentElement = this.head;
        while(currentElement != null){
            System.out.println("The Key is : " + currentElement.key);
            System.out.println("The Values Associated Or Hashed are as follows:");
            currentElement.chainList.displayList();
            currentElement = currentElement.next;
        }
    }
}
