package StringPractice;
//  LEETCODE 17 -- GOOGLE PROBLEM
//Given a string containing digits from 2-9 inclusive, return all possible letter combinations that
// the number could represent. Return the answer in any order.
//
// A mapping of digits to letters (just like on the telephone buttons) is given below.
// Note that 1 does not map to any letters.


//Constraints:
//
//        1 <= digits.length <= 4
//        digits[i] is a digit in the range ['2', '9'].



import java.util.List;
import java.util.ArrayList;

public class LetterCombinationOfaPhoneNumber {

    public static void main(String[] args) {
        System.out.println(pad("","234"));
    }

    public static List<String> pad(String p, String up){
        if(up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = up.charAt(0)-'0';
        List<String> ans = new ArrayList<>();
        int st = (digit-2)*3;
        int end = (digit-1)*3;
        if(digit==8 || digit==9) st++;
        if(digit==7 || digit==8) end++;
        if(digit==9) end+=2;
        for(int i=st; i<end; i++){
            char ch = (char)('a'+i);
            ans.addAll(pad(p+ch,up.substring(1)));
        }
        return ans;
    }


}

