package Basics;

public class Concept {
    public static void main(String[] args) {
        fun(5);
    }
    public static void fun(int n){
        if(n==0) return ;
        System.out.println(n);
//        fun(n--);           // first pass value 5 then decrease to 4;  so always passes 5
        fun(--n);
    }
}
