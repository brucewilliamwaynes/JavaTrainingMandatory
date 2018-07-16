package com.training.utility;

public class UnorderedList<T extends Comparable<? super T>> {

    private Node<T> headList;
    private Node<T> endList;

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

    public void insertNode(T item){
//        Node<T> currentNode = headList;
        if(headList == null){
            headList = new Node<T>(item);
            endList = headList;
        }
        else{
            endList.next = new Node<T>(item);
            endList = endList.next;
        }
    }

    public void removeNodeAtIndex(int index){
        Node<T> currentNode = headList;
        Node<T> tempNode = currentNode;
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

    public boolean searchNode(T item){
        Node<T> currentNode = headList;
        while (currentNode != null){
            if(item.compareTo(currentNode.data) == 0)
                return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    public int returnIndexOfItem(T item){
        Node<T> currentNode = headList;
        int currentIndex = 0;
        while (currentNode != null){
            if(item.compareTo(currentNode.data) == 0){
                return currentIndex;
            }
            currentIndex++;
            currentNode = currentNode.next;
        }
        return -1;
    }

    public void displayList(){
        Node<T> currentNode = headList;
        while(currentNode != null){
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public void insertAtIndex(int index,T item){
        Node<T> currentNode = headList;
        Node<T> tempNode = currentNode;
        int currentIndex = 0;
        while(currentNode != null && currentIndex < index){
            tempNode = currentNode;
            currentNode = currentNode.next;
            currentIndex++;
        }
        if(currentNode != null) {
            tempNode.next = new Node<T>(item);
            tempNode.next.next = currentNode;
        }
        else{
            System.out.println("Cannot find the index , adding at the last!");
            endList.next = new Node<T>(item);
            endList =  endList.next;
        }
    }

    public void replaceElementAtIndex(int index,T item){
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
            endList.next = new Node<T>(item);
            endList =  endList.next;
        }
    }

    public void removemNodeElement(T item){
        int index = returnIndexOfItem(item);
        if(index > -1)
            removeNodeAtIndex(index);
        else
            System.out.println("Element Cannot Be Found!");
    }

    public static UnorderedList segregateWordsIntoList(String inputString){
        UnorderedList<String> tempList = new UnorderedList<String>();
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
