package Basics;

import static Basics.ReverseNumber.reverse2;

public class Palindrome {

    static boolean isPalindrome(int n){
         return n==reverse2(n);
    }

    public static void main(String[] args) {
        int n=12321;
        System.out.println(isPalindrome(n));
    }
}
