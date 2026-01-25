package StringPractice;

public class Permutation {
    public static void main(String[] args) {
        permutation("","abc");
    }

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
}
