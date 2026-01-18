package StringPractice;

import java.util.ArrayList;

public class Subsequence {
    public static void main(String[] args) {
        printSubSeq("", "abc");

        System.out.println(subSeq("", "abc"));
    }

    public static void printSubSeq(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        printSubSeq(p+up.charAt(0), up.substring(1));
        printSubSeq(p, up.substring(1));
    }

    public static ArrayList<String> subSeq(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subSeq(p+ch, up.substring(1));
        ArrayList<String> right = subSeq(p, up.substring(1));
        left.addAll(right);
        return left;
    }
}


