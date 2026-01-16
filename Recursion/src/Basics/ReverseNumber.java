package Basics;

public class ReverseNumber {
    // first way
    static int sum = 0;
    static void reverse1(int n){
        if(n==0) return;
        int rem = n%10;
        sum = sum*10+rem;
        reverse1(n/10);
    }

    // Second way
    static int reverse2(int n){
//        int digits = (""+n).length();
        int digits = (int)Math.log10(n)+1;
        return helper(n,digits);
    }
    static int helper(int n, int d){
        if(n==0) return 0;
        int rem = n%10;
        return rem*(int)Math.pow(10,d-1) + helper(n/10,d-1);
    }

    public static void main(String[] args) {
        int n=1234;
        // first way
        reverse1(n);
        System.out.println(sum);

        // Second way
        int rNum = reverse2(n);
        System.out.println(rNum);

    }

}
