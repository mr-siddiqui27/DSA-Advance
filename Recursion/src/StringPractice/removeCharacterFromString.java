package StringPractice;

public class removeCharacterFromString {
    public static void main(String[] args) {
        String processed = "";
//        skip(processed, "adiabatic", 'a');
        System.out.println(skip2("adiabatic",'a'));
        System.out.println(skipApple("abcdappleegt"));

    }

    public static void skip(String p, String up, char x) {
        if (up.isEmpty()) {
            System.out.println("Processed String is " + p);
            return;
        }
        char ch = up.charAt(0);
        if (ch == x) {
            skip(p, up.substring(1), x);
        } else {
            skip(p + ch, up.substring(1), x);
        }
    }

    public static String skip2(String up, char x) {
        if (up.isEmpty()) {
            return "";
        }
        char ch = up.charAt(0);
        if (ch == x) {
            return skip2(  up.substring(1), x);
        } else {
            return ch + skip2(  up.substring(1), x);
        }
    }

    public static String skipApple(String up){
        if(up.isEmpty()){
            return "";
        }
        if(up.startsWith("apple")){
            return skipApple(up.substring(5));
        }else{
            return up.charAt(0) + skipApple(up.substring(1));
        }
    }
}
