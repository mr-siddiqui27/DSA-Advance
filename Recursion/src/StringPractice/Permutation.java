package StringPractice;

import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {

        System.out.println(permutationList("","abc"));
    }


    // Print
    public static void permutation(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        int l = p.length();
        for(int i=0; i<=l; i++){
            String f = p.substring(0,i);
            String s = p.substring(i,l);
            permutation(f+ch+s,up.substring(1));
        }
    }
    public static ArrayList<String> permutationList(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        char ch = up.charAt(0);
        int l = p.length();
        for(int i=0; i<=l; i++){
            String f = p.substring(0,i);
            String s = p.substring(i,l);
            ans.addAll(permutationList(f+ch+s,up.substring(1)));
        }
        return ans;
    }
}
