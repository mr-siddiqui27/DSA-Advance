package ProblemsOn_Grids_2D;

import java.util.Arrays;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        return uniquePaths2(m, n);
    }

    // Optimized
    private int uniquePaths2(int m, int n){

        int[] prev = new int[n];
        Arrays.fill(prev, 1);

        for(int i=1; i<m; i++){
            int[] temp = new int[n];
            for(int j=0; j<n; j++){
                int left = 0;
                if(j>0) left = temp[j-1];
                int up = prev[j];
                temp[j] = left+up;
            }
            System.arraycopy(temp, 0, prev, 0, n);
        }
        return prev[n-1];
    }

    // Tabulation
    private int uniquePaths1(int m, int n){
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            dp[0][j] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }





    // Memoization
    private int uniquePaths(int m, int n, int i, int j, int[][] ways) {
        if(i==m-1 && j==n-1) return 1;
        if(i>=m || j>=n) return 0;
        if(ways[i][j]!=-1) return ways[i][j];
        int right = uniquePaths(m, n, i+1, j, ways);
        int down = uniquePaths(m, n, i, j+1, ways);
        return ways[i][j] = right + down;
    }


    // Recursion
    private int uniquePaths(int m, int n, int i, int j) {
        if(i==m-1 && j==n-1) return 1;
        int right = 0;
        if(i<m) right = uniquePaths(m, n, i+1, j);
        int down = 0;
        if(j<n) down = uniquePaths(m, n, i, j+1);
        return right + down;
    }
}
