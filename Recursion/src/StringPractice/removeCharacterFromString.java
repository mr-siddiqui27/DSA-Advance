package StringPractice;

public class removeCharacterFromString {
    public static void main(String[] args) {
        String processed = "";
        skip(processed, "adiabatic", 'a');
        System.out.println(skip2("","adiabatic",'a'));

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

    public static String skip2(String p, String up, char x) {
        if (up.isEmpty()) {
            return p;
        }
        char ch = up.charAt(0);
        if (ch == x) {
            return skip2(p, up.substring(1), x);
        } else {
            return skip2(p + ch, up.substring(1), x);
        }
    }
}
