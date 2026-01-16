package Basics;

public class MultiplicationOfDigits {
    public static void main(String[] args) {
        System.out.println(multiDigits(1234));
    }

    public static long multiDigits(int n){
        if(n==0) return 1;
        return n%10 * multiDigits(n/10);
    }
}
