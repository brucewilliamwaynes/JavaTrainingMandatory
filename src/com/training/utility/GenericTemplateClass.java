package com.training.utility;

public class GenericTemplateClass<genericTemplate> {

    genericTemplate genericTemplateElement;

    public GenericTemplateClass(){

    }

    private GenericTemplateClass(genericTemplate genericTemplateElement){
        this.genericTemplateElement = genericTemplateElement;
    }

    public genericTemplate getgenericTemplateElement(){
        return this.genericTemplateElement;
    }

    public static <genericTemplate extends Comparable<genericTemplate>> genericTemplate[] bubbleSortGeneric(genericTemplate list[]){
        genericTemplate temp ;

        GenericTemplateClass genericTemplateClassObj = new GenericTemplateClass();

        for(int i=0;i<list.length-1;i++){
            for(int j=0;j<list.length-i-1;j++){
                if(list[j].compareTo(list[j+1]) > 0){
                    temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        }
        return list;
    }

    public static <genericTemplate extends Comparable<genericTemplate>> boolean binarySearchGeneric(genericTemplate list[],genericTemplate searchKey){

        list = bubbleSortGeneric(list);
        int leftIndex = 0;
        int rightIndex = list.length - 1;
        int mid = (leftIndex + rightIndex)/2;
        while(leftIndex < rightIndex){
            if(list[mid].compareTo(searchKey) == 0){
                return true;
            }
            else if(list[mid].compareTo(searchKey) < 0){
                leftIndex = mid + 1;
            }
            else
                rightIndex = mid -1 ;
        }
        return false;
    }

    public static <genericTemplate extends Comparable<genericTemplate>> genericTemplate[] insertionSortGeneric(genericTemplate list[]){
        for(int i=1;i<list.length;i++){
            genericTemplate indexKey = list[i];
            for(int j = i-1; j >= 0 && list[j].compareTo(indexKey) > 0; j--){
                list[j+1] = list[j];
            }
        }
        return list;
    }

}
