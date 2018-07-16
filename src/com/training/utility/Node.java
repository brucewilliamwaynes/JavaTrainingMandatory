package com.training.utility;

public class Node<T> {
    T data;
    Node<T> next;

     Node(T value){
        this.data = value;
        this.next = null;
    }
}