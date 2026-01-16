package Sorting;

import java.util.Arrays;

public class MergeSort {

    public static int[] merge(int[] first, int[] second){
        int[] mix = new int[first.length+second.length];
        int i=0, j=0, k=0;
        while(i<first.length && j<second.length){
            if(first[i]<second[j]) {
                mix[k] = first[i];
                i++;
            }else{
                mix[k] = second[j];
                j++;
            }
            k++;
        }
        while(i<first.length){
            mix[k] = first[i];
            i++;
            k++;
        }
        while(j<second.length){
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }

    public static int[] sort(int[] arr){
        if(arr.length==1) return arr;
        int mid = arr.length/2;
        int[] left = sort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = sort(Arrays.copyOfRange(arr, mid,arr.length));

        return merge(left, right);
    }

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        int[] sorted = sort(arr);
        System.out.println(Arrays.toString(sorted));
    }
}
