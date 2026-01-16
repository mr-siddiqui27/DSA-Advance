package Sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void sort(int[] arr, int l, int c){
        if(l==0){
            return;
        }
        if(c<l){
            if(arr[c-1]>arr[c]) {
                int temp = arr[c-1];
                arr[c-1] = arr[c];
                arr[c] = temp;
            }
            sort(arr, l,c+1);
        }else{
            sort(arr,l-1,1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {90,40,-4,1,3,2,5,7,4};
        sort(arr,arr.length,1);
        System.out.println(Arrays.toString(arr));
    }
}
