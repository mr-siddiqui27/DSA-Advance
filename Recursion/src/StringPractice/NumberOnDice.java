package StringPractice;
//given a dice figure out how many way are there in order to form n on the dice

import java.util.List;
import java.util.ArrayList;

public class NumberOnDice {
    public static void main(String[] args) {
        dice("",4);
        System.out.println(diceReturn("",9));
    }


    // print
    public static void dice(String p, int up){
        if(up==0){
            System.out.println(p);
            return;
        }
        for(int i=1; i<=6 && i<=up; i++){
            dice(p+(char)(i+'0'),up-i);
        }
    }
    public static List<String> diceReturn(String p, int up){
        if(up==0){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> ans = new ArrayList<>();
        for(int i=1; i<=6 && i<=up; i++){
            ans.addAll(diceReturn(p+(char)(i+'0'),up-i));
        }
        return ans;
    }
}
