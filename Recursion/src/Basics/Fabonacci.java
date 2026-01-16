package Basics;

import java.util.Scanner;

public class Fabonacci {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the number: ");
        int n = sc.nextInt();
        for(int i=0; i<=n; i++){
            System.out.println(faboFormula(i));
        }
//        System.out.println(faboFormula(n));
//        System.out.println(fabo(n));
    }

    static int faboFormula(int n){
        return (int)((Math.pow(((1+Math.sqrt(5))/2),n) - Math.pow(((1-Math.sqrt(5))/2),n))/Math.sqrt(5));
//          return (int)((Math.pow(((1+Math.sqrt(5))/2),n))/Math.sqrt(5));
    }

    static int fabo(int n){
        if(n==1) return 1;
        if(n==0) return 0;
        return fabo(n-1) + fabo(n-2);
    }
}
