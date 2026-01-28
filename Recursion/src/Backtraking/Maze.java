package Backtraking;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
//        System.out.println(stepsPrint(3,3, ""));
//        System.out.println(stepReturn2(3,3,""));


        Boolean[][] board = {
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        pathWithRestriction(0,0,"",board);
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

    // including diagonal
    public static ArrayList<String> stepReturn2(int r, int c, String p){
        if(r==1 && c==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
         if(c>1) ans.addAll(stepReturn2(r,c-1,p+'R'));
        if(r>1) ans.addAll(stepReturn2(r-1,c, p+'D'));
        if(r>1 && c>1) ans.addAll(stepReturn2(r-1,c-1, p+'d')); // 'd'-> diagonal

        return ans;
    }

    public static void pathWithRestriction(int r, int c, String p, Boolean[][] board){
        if(r==board.length-1 && c==board[0].length-1){
            System.out.println(p);
            return;
        }
        // if reach false cell then return
        if(!board[r][c]){
            return;
        }
        if(c<board.length-1) pathWithRestriction(r,c+1,p+'R',board);
        if(r<board[0].length-1) pathWithRestriction(r+1,c,p+'D',board);
    }


}
