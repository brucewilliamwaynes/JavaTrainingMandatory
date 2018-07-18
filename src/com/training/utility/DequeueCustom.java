package com.training.utility;

public class DequeueCustom <T>{
    Node<T> head;
    Node<T> rear;

    public DequeueCustom(){
        this.head = null;
        this.rear = null;
    }

    public boolean isEmptyDeQueue(){
        if(this.head != null)
            return false;
        return true;
    }

    public void addFrontDeQueue(T item){
        if(this.head == null){
            this.head = new Node<T>(item);
            this.rear = head;
        }
        else{
            Node<T> temp = this.head;
            this.head = new Node<T>(item);
            this.head.next = temp;
        }
    }

    public void addRearDeQueue(T item){
        if(this.head == null){
            this.head = new Node<T>(item);
            this.rear = head;
        }
        else{
            this.rear.next = new Node<T>(item);
            this.rear = this.rear.next;
        }
    }

    public void removeFrontDeQueue(){
        if(this.head == null){
            this.rear = null;
            System.out.println("Cannot remove from an empty DeQueue!");
        }
        else{
            head = head.next;
        }
    }

    public void removeRearDeQueue(){
        if(this.rear == null){
            this.head = null;
            System.out.println("Cannot remove from an empty DeQueue!");
        }
        else{
            Node<T> currentNode = this.head;
            Node<T> prevNode = currentNode;
            while(currentNode.next != null){
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
            this.rear = prevNode;
            this.rear.next = null;
        }
    }

    public int sizeDeQueue(){
        Node<T> currentNode = head;
        int length= 0;
        while(currentNode != null){
            length++;
            currentNode = currentNode.next;
        }
        return length;
    }

    public T peekFrontDeQueue(){
        if(this.head == null){
            this.rear = null;
            System.out.println("Cannot peek on an empty DeQueue!");
            return null;
        }
        else{
            return this.head.data;
        }
    }

    public T peekRearDeQueue(){
        if(this.rear == null){
            this.head = null;
            System.out.println("Cannot peek on an empty DeQueue!");
            return null;
        }
        else{
            return this.rear.data;
        }
    }
}
