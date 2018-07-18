package com.training.utility;

public class UnorderedList<T extends Comparable<? super T>> {

    private Node<T> headList;
    private Node<T> endList;

    public UnorderedList(){
        this.headList = null;
        this.endList = null;
    }

    public boolean isEmpty(){
        if(this.endList != null)
            return false;
        return true;
    }

    public int lengthOfList(){
        Node currentNode = this.headList;
        int size = 0;
        while (currentNode!=null){
            size++;
            currentNode = currentNode.next;
        }
        return size;
    }

    public void insertNode(T item){
//        Node<T> currentNode = this.headList;
        if(this.headList == null){
            this.headList = new Node<T>(item);
            this.endList = this.headList;
        }
        else{
            this.endList.next = new Node<T>(item);
            this.endList = this.endList.next;
        }
    }

    public void removeNodeAtIndex(int index){
        Node<T> currentNode = this.headList;
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

    public T getElementAtIndex(int index){
        int currentIndex = 0;
        Node<T> currentNode = this.headList;
        if(index < lengthOfList() && index > -1){
            while(currentIndex<index){
                currentIndex++;
                currentNode = currentNode.next;
            }
            return currentNode.data;
        }
        return null;
    }

    public boolean searchNode(T item){
        Node<T> currentNode = this.headList;
        while (currentNode != null){
            if(item.compareTo(currentNode.data) == 0)
                return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    public int returnIndexOfItem(T item){
        Node<T> currentNode = this.headList;
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
        Node<T> currentNode = this.headList;
        while(currentNode != null){
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public void insertAtIndex(int index,T item){
        Node<T> currentNode = this.headList;
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
            this.endList.next = new Node<T>(item);
            this.endList =  this.endList.next;
        }
    }

    public void replaceElementAtIndex(int index,T item){
        Node currentNode = this.headList;
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
            this.endList.next = new Node<T>(item);
            this.endList =  this.endList.next;
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

    public void bubbleSortForUnorderedList(){
        Node<T> prev;
        Node<T> current;
        Node<T> next;
        Node<T> outerLoop;
        Node<T> endPoint;
        outerLoop = this.headList;
        endPoint = null;
        while(outerLoop!=null){
            current = this.headList;
            prev = current;
            next = current.next;
            System.out.println(current.data);
            /*
            while (current!= endPoint){
                if(current.data.compareTo(next.data) > 0){
                    System.out.println("Two swapped numbers are :" + current.data + " and " + next.data);
                    prev.next = next;
                    current.next = next.next;
                    next.next = current;
                }
                prev = current;
                current = current.next;
                next = next.next;
            }
            */
            endPoint = prev;
            outerLoop = outerLoop.next;
            System.out.println("The last element is :" + endPoint.data);
            System.out.println("The round was for :" + outerLoop.data);
        }
    }
}
