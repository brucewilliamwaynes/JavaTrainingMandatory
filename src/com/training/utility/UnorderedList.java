package com.training.utility;

public class UnorderedList<genericTemplate> {

    Node headList;
    Node endList;

    public UnorderedList(){
        this.headList = null;
        this.endList = null;
    }

    public boolean isEmpty(){
        if(endList != null)
            return false;
        return true;
    }

    public int lengthOfList(){
        Node currentNode = headList;
        int size = 0;
        while (currentNode!=null){
            size++;
            currentNode = currentNode.next;
        }
        return size;
    }

    public void insertNode(genericTemplate item){
        Node currentNode = headList;
        if(headList == null){
            headList = new Node(item);
            endList = headList;
        }
        else{
            endList.next = new Node(item);
            endList = endList.next;
        }
    }

    public void removeNodeAtIndex(int index){
        Node currentNode = headList;
        Node tempNode = currentNode;
        int currentIndex = 0;
        while(currentNode != null && currentIndex < index){
            tempNode = currentNode;
            currentNode = currentNode.next;
            currentIndex++;
        }
        if(currentNode != null) {
            tempNode.next = currentNode.next;
        }
        else{
            System.out.println("Cannot find the index !");
        }
    }

    public <genericTemplate extends Comparable<genericTemplate>>boolean searchNode(genericTemplate item){
        Node currentNode = headList;
        while (currentNode != null){
            if(String.valueOf(currentNode.data).compareTo(String.valueOf(item)) == 0)
                return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    public int returnIndexOfItem(genericTemplate item){
        Node currentNode = headList;
        int currentIndex = 0;
        while (currentNode != null){
            if(currentNode.data == item){
                return currentIndex;
            }
            currentIndex++;
            currentNode = currentNode.next;
        }
        return -1;
    }



    public void displayList(){
        Node currentNode = headList;
        while(currentNode != null){
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public void insertAtIndex(int index,genericTemplate item){
        Node currentNode = headList;
        Node tempNode = currentNode;
        int currentIndex = 0;
        while(currentNode != null && currentIndex < index){
            tempNode = currentNode;
            currentNode = currentNode.next;
            currentIndex++;
        }
        if(currentNode != null) {
            tempNode.next = new Node(item);
            tempNode.next.next = currentNode;
        }
        else{
            System.out.println("Cannot find the index , adding at the last!");
            endList.next = new Node(item);
            endList =  endList.next;
        }
    }

    public void replaceElementAtIndex(int index,genericTemplate item){
        Node currentNode = headList;
        Node tempNode = currentNode;
        int currentIndex = 0;
        while(currentNode != null && currentIndex < index){
            tempNode = currentNode;
            currentNode = currentNode.next;
            currentIndex++;
        }
        if(currentNode != null) {
            currentNode.data = item;
        }
        else{
            System.out.println("Cannot find the index to be replaced! , adding at the last!");
            endList.next = new Node(item);
            endList =  endList.next;
        }
    }

    public void removemNodeElement(genericTemplate item){
        int index = returnIndexOfItem(item);
        if(index > -1)
            removeNodeAtIndex(index);
        else
            System.out.println("Element Cannot Be Found!");
    }

    public static UnorderedList segregateWordsIntoList(String inputString){
        UnorderedList tempList = new UnorderedList();
        String word = "";
        for(int i=0;i<inputString.length();i++){
            if(inputString.charAt(i) != ','){
                word = word + inputString.charAt(i);
            }
            else{
                tempList.insertNode(word);
                word = "";
            }
        }
        tempList.insertNode(word.substring(0,word.length()-1));
        return tempList;
    }

}
