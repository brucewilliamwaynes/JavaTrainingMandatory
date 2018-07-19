package com.training.utility;

public  class MapElement<T,E extends Comparable<? super E>>{
        public T key;
        public MapElement<T,E> next;
        public OrderedList<E> chainList;

        public MapElement(T keyItem, E valueItem){
            this.key = keyItem;
            this.next = null;
            this.chainList = new OrderedList<E>();
            this.chainList.insertNode(valueItem);
        }
}
