package com.training.utility;

public class Stack<T> {
    private Node<T> start;
    private Node<T> top;
    public Stack(){
        this.start = null;
        this.top = null;
    }

    public void push(T item){
        if(this.start == null){
            this.start = new Node<T>(item);
            this.start.next = null;
            this.top = start;
        }
        else{
            Node<T> newNode = new Node<T>(item);
            newNode.next = this.top;
            this.top = newNode;
        }
    }

    public boolean isEmpty(){
        if(this.top != null)
            return false;
        return true;
    }

    public void pop(){
        if(this.top == null){
            this.start = null;
            this.top = null;
            System.out.println("Cannot Pop Empty Stack!");
        }
        else {
            top = top.next;
        }
    }

    public T peak(){
        if(this.top == null){
            this.start = null;
            System.out.println("Peak A Boo , Stack is not foo(l)!");
        }
        else{
            return (this.top.data);
        }
        return null;
    }

    public int size(){
        Node<T> currentNode = top;
        int length = 0;
        while(currentNode != null){
            length++;
            currentNode = currentNode.next;
        }
        return length;
    }

}
