package StringPractice;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
//        System.out.println(stepsPrint(3,3, ""));
        System.out.println(stepReturn(3,3,""));
    }


    public static int pathCount(int r, int c){
        if(r==1 || c==1){
            return 1;
        }
        int right = pathCount(r,c-1);
        int down = pathCount(r-1,c);
        return right+down;
    }

    public static int stepsPrint(int r, int c, String s){

        // When reach bottom then add all R
        if(r==1){
            for(int i=1; i<=(c-1); i++){
                s +='R';
            }
            System.out.println(s);
            return 1;
        }
        // when reach right end then add all D
        if(c==1){
            for(int i=1; i<=(r-1); i++){
                s +='D';
            }
            System.out.println(s);
            return 1;
        }
        int right = stepsPrint(r,c-1, s+'R');
        int down = stepsPrint(r-1,c, s+'D');
        return right+down;
    }

    // return steps
    // same as stepPrint but in different way
    public static ArrayList<String> stepReturn(int r, int c, String p){
        if(r==1 && c==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> right = new ArrayList<>();
        ArrayList<String> down = new ArrayList<>();
        if(c>1) right = stepReturn(r,c-1,p+'R');
        if(r>1) down = stepReturn(r-1,c, p+'D');

        right.addAll(down);
        return right;
    }


}
