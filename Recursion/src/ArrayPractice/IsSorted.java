package ArrayPractice;

import java.util.Scanner;

public class IsSorted {

    // without recursion
//    public static boolean isSorted(int[] arr){
//        int i=1;
//        while(i<arr.length && arr[i-1]<=arr[i]){
//            i++;
//        }
//        return i==arr.length;
//    }

    public static boolean isSorted(int[] arr){
        return helper2(arr,0);
    }
    static int helper(int[] arr, int i){
        if(i<arr.length && arr[i-1]<=arr[i]) return helper(arr,i+1);;
        return i;
    }
    static boolean helper2(int[] arr, int i){
        if(i==arr.length-1) return true;
        return arr[i]<=arr[i+1] && helper2(arr,i+1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        Arrays.input(arr);
        System.out.println(isSorted(arr));
    }
}
