package com.training.dataStructurePrograms;

import com.training.utility.*;

import java.util.HashMap;

public class PrimeNumberInRange {

    public OrderedMapCustom<Integer,Integer> findAnagrams(OrderedMapCustom<Integer,Integer> twoDArray){
        HashMap<Integer,Integer> mapInBuilt = new HashMap<Integer, Integer>();
        MapElement<Integer,Integer> currentNode = twoDArray.getHead();
        OrderedMapCustom<Integer,Integer> twoDArrayAnagram= new OrderedMapCustom<Integer, Integer>();
        while(currentNode!=null){
            for(int i=0;i<currentNode.chainList.lengthOfList();i++){
                mapInBuilt.put(currentNode.chainList.getElementAtIndex(i),1);
                for(HashMap.Entry<Integer,Integer> element : mapInBuilt.entrySet()){
                    if(CommonAlgorithms.isAnagramForInteger(currentNode.chainList.getElementAtIndex(i),element.getKey()) && currentNode.chainList.getElementAtIndex(i) != element.getKey()){
                        twoDArrayAnagram.addElementToHashMap(currentNode.chainList.getElementAtIndex(i),element.getKey());
                    }
                }
            }
            currentNode = currentNode.next;
        }
        return twoDArrayAnagram;
    }

    public StackCustom<Integer> convertToStack(OrderedMapCustom<Integer,Integer> mapAnagram){
        StackCustom<Integer> myStack = new StackCustom<Integer>();
        MapElement<Integer,Integer> currentMapElement = mapAnagram.getHead();
        while(currentMapElement!=null){
            for(int i=0;i<currentMapElement.chainList.lengthOfList();i++){
                myStack.pushCustomStack(currentMapElement.chainList.getElementAtIndex(i));
            }
            currentMapElement = currentMapElement.next;
        }
        return myStack;
    }

    public QueueCustom<Integer> convertToQueue(OrderedMapCustom<Integer,Integer> mapAnagram){
        QueueCustom<Integer> myQueue = new QueueCustom<Integer>();
        MapElement<Integer,Integer> currentMapElement = mapAnagram.getHead();
        while(currentMapElement!=null){
            for(int i=0;i<currentMapElement.chainList.lengthOfList();i++){
                myQueue.enQueueCustom(currentMapElement.chainList.getElementAtIndex(i));
            }
            currentMapElement = currentMapElement.next;
        }
        return myQueue;
    }

    public void printPrimeNumbersInRange(){
        OrderedMapCustom<Integer,Integer> twoDArrayPrime = new OrderedMapCustom<Integer, Integer>();
        int keyMarker = 0;
        for(int i=0;i<=1000;i++){
            if(i/100 > 0){
                keyMarker = i/100;
            }
            if(CommonAlgorithms.isPrime(i)){
                twoDArrayPrime.addElementToHashMap(keyMarker,i);
            }
        }

        System.out.println("Simple Array List!");

        twoDArrayPrime.displayHashedMap();

        OrderedMapCustom<Integer,Integer> mapAnagram = findAnagrams(twoDArrayPrime);

        System.out.println("Anagram List!");

        mapAnagram.displayHashedMap();

        StackCustom<Integer> myStackCustom = convertToStack(mapAnagram);

//        System.out.println(myStackCustom.sizeCustomStack());

        System.out.println("Stack List!");

        myStackCustom.displayStack();

        System.out.println("Queue List!");

        QueueCustom<Integer> myQueue = convertToQueue(mapAnagram);

        myQueue.displayQueue();

    }
}
