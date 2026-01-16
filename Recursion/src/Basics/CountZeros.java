package Basics;

public class CountZeros {

    // Way 1
    static int countZeros(int n, int c){
        if(n==0) return c;
        if(n%10==0) return countZeros(n/10,c+1);
        return countZeros(n/10,c);
    }

    // way 2
    static int countZeros2(int n){
        return countZeros(n,0);
    }

    public static void main(String[] args) {
        int n=10200030;
        // Method 1
        System.out.println(countZeros(n,0));
        // method 2
        System.out.println(countZeros2(n));
    }
}
