package com.training.utility;

public class StackCustom<T> {
    private Node<T> start;
    private Node<T> top;
    public StackCustom(){
        this.start = null;
        this.top = null;
    }

    public void pushCustomStack(T item){
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

    public boolean isEmptyCustomStack(){
        if(this.top != null)
            return false;
        return true;
    }

    public void popCustomStack(){
        if(this.top == null){
            this.start = null;
            this.top = null;
            System.out.println("Cannot Pop Empty StackCustom!");
        }
        else {
            this.top = this.top.next;
        }
    }

    public T peakCustomStack(){
        if(this.top == null){
            this.start = null;
            System.out.println("Peak A Boo , StackCustom is not foo(l)!");
        }
        else{
            return (this.top.data);
        }
        return null;
    }

    public int sizeCustomStack(){
        Node<T> currentNode = this.top;
        int length = 0;
        while(currentNode != null){
            length++;
            currentNode = currentNode.next;
        }
        return length;
    }

    public void displayStack(){
        while(!this.isEmptyCustomStack()){
            System.out.println(this.peakCustomStack());
            this.popCustomStack();
        }
    }

}
