package Backtraking;

import java.util.Arrays;

public class MazeAllPath {
    public static void main(String[] args) {
        Boolean[][] board = {
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        int[][] path = new int[board.length][board[0].length];
        allPathPrint(0,0,"",board,path,1);
    }

    public static void allPath(int r, int c, String p, Boolean[][] board){
        if(r==board.length-1 && c==board[0].length-1){
            System.out.println(p);
            return;
        }
        // if reach false cell then return
        if(!board[r][c]){
            return;
        }

        // I'm considering this block in my path
        board[r][c] = false;

        if(r<board[0].length-1) allPath(r+1,c,p+'D',board);
        if(c<board.length-1) allPath(r,c+1,p+'R',board);
        if(r>0) allPath(r-1,c,p+'U',board);
        if(c>0) allPath(r,c-1,p+'L',board);
        //this line is where the function will be over
        //so before the function get removed, also remove the changes that were made by the function
        board[r][c] = true;
    }

    public static void allPathPrint(int r, int c, String p, Boolean[][] board, int[][] path, int step){
        if(r==board.length-1 && c==board[0].length-1){
            path[r][c] = step;
            for(int[] arr: path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        // if reach false cell then return
        if(!board[r][c]){
            return;
        }

        // I'm considering this block in my path
        board[r][c] = false;
        path[r][c] = step;

        if(r<board[0].length-1) allPathPrint(r+1,c,p+'D',board, path, step+1);
        if(c<board.length-1) allPathPrint(r,c+1,p+'R',board, path, step+1);
        if(r>0) allPathPrint(r-1,c,p+'U',board, path, step+1);
        if(c>0) allPathPrint(r,c-1,p+'L',board, path, step+1);
        //this line is where the function will be over
        //so before the function get removed, also remove the changes that were made by the function
        board[r][c] = true;
        path[r][c] = 0;
    }
}
