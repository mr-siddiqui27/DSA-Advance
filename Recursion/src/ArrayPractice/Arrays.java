package ArrayPractice;

import java.util.Scanner;

public class Arrays {
    public static void input(int[] arr){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
    }
}
