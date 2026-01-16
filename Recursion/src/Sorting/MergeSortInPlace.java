package Sorting;

import java.util.Arrays;

public class MergeSortInPlace {
    public static void merge(int[] arr, int st, int mid, int end) {
        int fl = mid - st + 1;
        int sl = end - mid;

        int[] first = new int[fl];
        int[] second = new int[sl];

        System.arraycopy(arr, st, first, 0, fl);
        System.arraycopy(arr, mid+1, second, 0, sl);
        for (int i = 0; i < sl; i++) {
            second[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = st;

        while (i < first.length && j < second.length) {
            if (first[i] <= second[j]) {
                arr[k] = first[i];
                i++;
            } else {
                arr[k] = second[j];
                j++;
            }
            k++;
        }

        while (i < first.length) {
            arr[k++] = first[i++];
        }

        while (j < second.length) {
            arr[k++] = second[j++];
        }
    }

    public static void sort(int[] arr, int st, int end) {
        if (st >= end) return;

        int mid = (st + end) / 2;
        sort(arr, st, mid);
        sort(arr, mid + 1, end);

        merge(arr, st, mid, end);
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
