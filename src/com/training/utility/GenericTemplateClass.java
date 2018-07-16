package com.training.utility;

import java.util.ArrayList;

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

    public static <genericTemplate extends Comparable<genericTemplate>> ArrayList<genericTemplate> bubbleSortGeneric(ArrayList<genericTemplate> list){
        genericTemplate temp ;

        GenericTemplateClass genericTemplateClassObj = new GenericTemplateClass();

        for(int i=0;i<list.size()-1;i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    temp = list.get(j);
                    list.add(j, list.get(j + 1));
                    list.add(j + 1, temp);
                }
            }
        }


        return list;
    }

    public static <genericTemplate extends Comparable<genericTemplate>> boolean binarySearchGeneric(ArrayList<genericTemplate> list, genericTemplate searchKey){

        list = bubbleSortGeneric(list);

        int leftIndex = 0;
        int rightIndex = list.size() - 1;
        int mid;

        while(leftIndex <= rightIndex){

            mid = (leftIndex + rightIndex)/2;

            if(list.get(mid).compareTo(searchKey) == 0){
                return true;
            }
            else if(list.get(mid).compareTo(searchKey) < 0){
                leftIndex = mid + 1;
            }
            else
                rightIndex = mid -1 ;
        }
        return false;
    }

    public static <genericTemplate extends Comparable<genericTemplate>> ArrayList<genericTemplate> insertionSortGeneric(ArrayList<genericTemplate> list){
        for(int i=1;i<list.size();i++){
            genericTemplate indexKey = list.get(i);
            for(int j = i-1; j >= 0 && list.get(j).compareTo(indexKey) > 0; j--){
                list.add(j+1,list.get(j));
            }
        }
        return list;
    }

    public static <genericTemplate extends Comparable<genericTemplate>> ArrayList<genericTemplate> mergeGeneric(ArrayList<genericTemplate> list,int leftIndex,int midIndex,int rightIndex){

        int i, j, k;
        int sizeOfLeftArray = midIndex - leftIndex + 1;
        int sizeOfRightArray =  rightIndex - midIndex;

        /* create temp arrays */
        ArrayList<genericTemplate> leftList = new ArrayList<genericTemplate>(sizeOfLeftArray);
        ArrayList<genericTemplate> rightList = new ArrayList<genericTemplate>(sizeOfRightArray);

        /* Copy data to temp arrays L[] and R[] */
        for (i = 0; i < sizeOfLeftArray; i++)
            leftList.add(i,list.get(leftIndex + i));
        for (j = 0; j < sizeOfRightArray; j++)
            rightList.add(j,list.get(midIndex + leftIndex + j));

        /* Merge the temp arrays back into arr[l..r]*/
        i = 0; // Initial index of first subarray
        j = 0; // Initial index of second subarray
        k = leftIndex; // Initial index of merged subarray
        while (i < sizeOfLeftArray && j < sizeOfRightArray)
        {
            if(leftList.get(i).compareTo(rightList.get(j)) <= 0){
                list.add(k,leftList.get(i));
                i++;
            }
            else
            {
                list.add(k,rightList.get(j));
                j++;
            }
            k++;
        }

    /* Copy the remaining elements of L[], if there
       are any */
        while (i < sizeOfLeftArray)
        {
            list.add(k,leftList.get(i));
            i++;
            k++;
        }

    /* Copy the remaining elements of R[], if there
       are any */
        while (j < sizeOfRightArray)
        {
            list.add(k,rightList.get(j));
            j++;
            k++;
        }

        return list;
    }

    public static <genericTemplate extends Comparable<genericTemplate>> ArrayList<genericTemplate> mergeSortGenericAuxillary(ArrayList<genericTemplate> list,int leftIndex, int rightIndex){

        if(leftIndex < rightIndex){
            int midIndex = leftIndex + (rightIndex - leftIndex)/2;

            mergeSortGenericAuxillary(list, leftIndex , midIndex);

            mergeSortGenericAuxillary(list,midIndex + 1,rightIndex);

            mergeGeneric(list,leftIndex,midIndex,rightIndex);
        }

        return list;
    }

    public static <genericTemplate extends Comparable<genericTemplate>> ArrayList<genericTemplate> mergeSortGeneric(ArrayList<genericTemplate> list){

        list = mergeSortGenericAuxillary(list,0,list.size()-1);

        return list;
    }

}
