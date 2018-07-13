package com.training.utility;

public class Node<genericTemplate> {
    genericTemplate data;
    Node next;

    Node(genericTemplate value){
        this.data = value;
        this.next = null;
    }
}