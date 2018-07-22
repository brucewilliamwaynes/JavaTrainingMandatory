package com.training.utility;

public class QueueCustom<T> {
    Node<T> head;
    Node<T> rear;
    public QueueCustom(){
        this.head = null;
        this.rear = null;
    }

    public void enQueueCustom(T item){
        if(this.head == null){
            this.head = new Node<T>(item);
            this.rear = this.head;
        }
        else{
            this.rear.next = new Node<T>(item);
            this.rear = this.rear.next;
        }
    }

    public T deQueueCustom(){
        if(this.head == null){
            this.rear = null;
            System.out.println("Cannot DeQueue an Empty Queue!");
        }
        else{
            Node<T> temp = this.head;
            this.head = this.head.next;
            return temp.data;
        }
        return null;
    }

    public boolean isEmptyQueueCustom(){
        if(this.head != null)
            return false;
        return true;
    }

    public int sizeOfQueue(){
        int length = 0;
        Node<T> current = head;
        while(current != null){
            length++;
            current = current.next;
        }
        return length;
    }

    public void displayQueue(){
        while (!this.isEmptyQueueCustom()){
            System.out.println(this.deQueueCustom());
        }
    }

}
