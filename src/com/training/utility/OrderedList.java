package com.training.utility;

public class OrderedList<T extends Comparable<? super  T>> {
    private Node<T> headList;
    private Node<T> endList;

    public OrderedList(){
        this.headList = null;
        this.endList = null;
    }

    public void insertNode(T item){
        if(this.headList == null){
            this.headList = new Node<T>(item);
            this.headList.next = null;
            this.endList = this.headList;
        }
        else{
            Node<T> currentNode = this.headList;
            Node<T> tempNode = null;
            while(currentNode.next != null){
                if(currentNode.data.compareTo(item) > 0)
                    break;
                tempNode = currentNode;
                currentNode = currentNode.next;
            }
            if(currentNode == this.headList){
                tempNode = new Node<T>(item);
                tempNode.next = this.headList;
                this.headList = tempNode;
            }
            else if (currentNode.next == null){
                if(currentNode.data.compareTo(item) > 0){
                    tempNode.next = new Node<T>(item);
                    tempNode.next.next = currentNode;
                }
                else {
                    currentNode.next = new Node<T>(item);
                    currentNode.next.next = null;
                    this.endList = currentNode.next;
                }
            }
            else {
                tempNode.next = new Node<T>(item);
                tempNode.next.next = currentNode;
            }
        }
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

    private void removeNode(T item){
        Node<T> currentNode = this.headList;
        Node<T> tempNode = null;
        while(currentNode.next != null){
            if(currentNode.data.compareTo(item) == 0)
                break;
            tempNode = currentNode;
            currentNode = currentNode.next;
        }
        if(this.headList == currentNode){
            this.headList = this.headList.next;
        }
        else if(currentNode == this.endList){
            this.endList = tempNode;
            this.endList.next = null;
        }
        else{
            tempNode.next = currentNode.next;
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

    public void removemNodeElement(T item){
        int index = returnIndexOfItem(item);
        if(index > -1)
            removeNode(item);
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

    public static OrderedList segregateNumbersIntoList(String inputString){
        OrderedList<Integer> list = new OrderedList<Integer>();
        UnorderedList<String> tempList = new UnorderedList<String>();
        tempList = segregateWordsIntoList(inputString);
//        tempList.displayList();
//        System.out.println("Without Insertion!");
        for(int i = 0 ; i < tempList.lengthOfList();i++){
            list.insertNode(Integer.parseInt(tempList.getElementAtIndex(i)));
//            list.displayList();
//            System.out.println("After Round :" + i);
        }
        return list;
    }

    public void popList(){
        Node<T> currentNode = this.headList;
        Node<T> tempNode = null;
        while(currentNode.next != null){
            tempNode = currentNode;
            currentNode = currentNode.next;
        }
        this.endList = tempNode;
        this.endList.next = null;
    }

}
