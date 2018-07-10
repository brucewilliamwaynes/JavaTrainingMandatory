package com.training.utility;

public class GenericTemplateClass<genericTemplate> {

    genericTemplate genericTemplateElement;

    GenericTemplateClass(){

    }

    GenericTemplateClass(genericTemplate genericTemplateElement){
        this.genericTemplateElement = genericTemplateElement;
    }

    public genericTemplate getgenericTemplateElement(){
        return this.genericTemplateElement;
    }

    public int genericComparision(genericTemplate elementOne, genericTemplate elementTwo){
        if(elementOne.getClass().getName().compareTo("java.lang.Integer") == 0)
            return (elementOne - elementTwo);
    }

    public static <genericTemplate> genericTemplate bubbleSortForString(genericTemplate list[]){
        genericTemplate temp ;

        GenericTemplateClass genericTemplateClassObj = new GenericTemplateClass();

        for(int i=0;i<list.length-1;i++){
            for(int j=0;j<list.length-i-1;j++){
                if(genericTemplateClassObj.genericComparision(list[j],list[j+1]) > 0){
                    temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        }
        return list;
    }

}
