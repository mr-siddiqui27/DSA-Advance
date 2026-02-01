package Backtraking;

import java.util.ArrayList;
import java.util.List;

public class NKnights {
    public static void main(String[] args) {
        int n=2;
        NKnightsSolution nKnights = new NKnightsSolution();
        List<List<String>> ans = nKnights.solveNKNights(n);
        System.out.println(ans);
    }
}


class NKnightsSolution {
    public List<List<String>> solveNKNights(int n) {
        boolean[][] board = new boolean[n][n];
        return kKnights(board, 0,0);
    }

    public List<List<String>> kKnights(boolean[][] board, int start, int count) {

        if (count == board.length) {
            List<List<String>> res = new ArrayList<>();
            res.add(convert(board));
            return res;
        }

        List<List<String>> ans = new ArrayList<>();
        int n = board.length;

        for (int i = start; i < n * n; i++) {
            int r = i / n;
            int c = i % n;

            if (isSafe(board, r, c)) {
                board[r][c] = true;
                ans.addAll(kKnights(board, i + 1, count + 1));
                board[r][c] = false; // backtrack
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
                    sb.append('K');
                } else {
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }
        return list;
    }

    public static boolean isSafe(boolean[][] board, int r, int c){
        //upper left
        if((r-2)>=0 && (c-1)>=0 && board[r-2][c-1]) return false;
        // upper right
        if(r-2>=0 && c+1<board.length && board[r-2][c+1]) return false;
        // left upper
        if(r-1>=0 && c-2>=0 && board[r-1][c-2]) return false;
        // right upper
        if(r-1>=0 && c+2<board.length && board[r-1][c+2]) return false;

        return true;

    }

}
