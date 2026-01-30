package Backtraking;
import java.util.List;
import java.util.ArrayList;
public class NQueenLeetCode {
    public static void main(String[] args) {
        int n=5;
        Solution nQueen = new Solution();
        List<List<String>> ans = nQueen.solveNQueens(n);
        System.out.println(ans);
    }
}

class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return queen(board, 0);
    }

    public List<List<String>> queen(boolean[][] board, int r){
        if(r==board.length){
            List<String> ConvertToStr = convert(board);
            List<List<String>> list= new ArrayList<>();
            list.add(ConvertToStr);
            return list;
        }

        List<List<String>> ans= new ArrayList<>();
        for(int c=0; c<board.length; c++){
            if(isSafe(board, r, c)){
                board[r][c] = true;
                ans.addAll(queen(board, r+1));
                board[r][c] = false;
            }
        }
        return ans;
    }

    public List<String> convert(boolean[][] board) {
        List<String> list = new ArrayList<>();
        for (boolean[] row : board) {
            StringBuilder sb = new StringBuilder();
            for (boolean cell : row) {
                if (cell) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }
        return list;
    }

    public static boolean isSafe(boolean[][] board, int r, int c){
        // left upper
        int minLeft = Math.min(r,c);
        for(int i=1; i<=minLeft; i++){
            if(board[r-i][c-i]) return false;
        }
        // right upper
        int minRight = Math.min(r,(board.length-c-1));
        for(int i=1; i<=minRight; i++){
            if(board[r-i][c+i]) return false;
        }
        // upper
        for(int i=0; i<=r; i++){
            if(board[i][c]) return false;

        }
        return true;
    }

}
