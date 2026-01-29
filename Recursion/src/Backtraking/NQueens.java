package Backtraking;

public class NQueens {
    public static void main(String[] args) {
        boolean[][] board = new boolean[5][5];
        System.out.println(queens(board,0));
    }


    public static int queens(boolean[][] board, int r){
        if(r==board.length){
            display(board);
            System.out.println();
            return 1;
        }

        int count=0;
        for(int c=0; c<board.length; c++){
            // place the queen if it is safe
            if(isSafe(board,r,c)){
                board[r][c] = true;
                count += queens(board,r+1);
                board[r][c] = false;
            }
        }
        return count;
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

    public static void display(boolean[][] board){
        for(boolean[] row: board){
            for(boolean element: row){
                if(element)
                    System.out.print("Q ");
                else
                    System.out.print("X ");
            }
            System.out.println();
        }
    }
}
