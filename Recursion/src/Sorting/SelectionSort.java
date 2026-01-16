package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void sort(int[] arr, int max, int l, int i){
        if(l==0){
            return;
        }
        if(i<l){
            if(arr[i]>arr[max]) max = i;
            sort(arr, max, l, i+1);
        }else{
            int temp = arr[i-1];
            arr[i-1] = arr[max];
            arr[max] = temp;
            sort(arr, 0, l-1, 0);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 1, 8, 7, 6, 5};
        sort(arr, 0, arr.length, 0);
        System.out.println(Arrays.toString(arr));

    }
}
