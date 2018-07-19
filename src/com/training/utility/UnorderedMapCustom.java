package com.training.utility;

public class UnorderedMapCustom<T,E extends Comparable<? super E>>{
    MapElement<T,E> head;
    MapElement<T,E> end;

    public UnorderedMapCustom(){
        this.head = null;
        this.end = null;
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
            this.head = new MapElement<T, E>(itemKey,itemValue);
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
                this.end.next = new MapElement<T, E>(itemKey,itemValue);
                this.end = this.end.next;
            }
        }
    }

    public void displayHashedMap(){
        MapElement<T,E> currentElement = this.head;
        while(currentElement != null){
            System.out.println("The Key is :" + currentElement.key);
            System.out.println("The Values Associated Or Hashed are as follows:");
            currentElement.chainList.displayList();
            currentElement = currentElement.next;
        }
    }
}
