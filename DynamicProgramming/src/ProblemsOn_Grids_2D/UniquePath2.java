package ProblemsOn_Grids_2D;

import java.util.Arrays;

public class UniquePath2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return uniquePathsWithObstacles2(obstacleGrid);
    }

    // More optimized
    private int uniquePathsWithObstacles3(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n];

        dp[0] = grid[0][0] == 1 ? 0 : 1;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    dp[j] = 0; // obstacle
                } else if(j > 0){
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }

    // Optimized
    private int uniquePathsWithObstacles2(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] prev = new int[n];
        for(int i = 0; i < n; i++){
            if(obstacleGrid[0][i] == 1) break;
            prev[i] = 1;
        }
        for(int i=1; i<m; i++){
            int[] temp = new int[n];
            for(int j=0; j<n; j++){
                if(obstacleGrid[i][j] != 1){
                    int left = 0;
                    if(j>0) left = temp[j-1];
                    int up = prev[j];
                    temp[j] = left+up;
                }
            }
            System.arraycopy(temp, 0, prev, 0, n);
        }
        return prev[n-1];
    }


    // Tabulation
    private int uniquePathsWithObstacles1(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++){
            if(obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            if(obstacleGrid[0][j] == 1) break;
            dp[0][j] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] != 1)
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }

    // Memoization
    private int uniquePathsWithObstacles(int[][] obstacleGrid, int i, int j, int[][] dp){
        if(i<0 || j<0) return 0;
        if(obstacleGrid[i][j]==1) return 0;
        if(i==0 && j==0) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int left = uniquePathsWithObstacles(obstacleGrid, i, j-1, dp);
        int up = uniquePathsWithObstacles(obstacleGrid, i-1, j, dp);
        return dp[i][j] = left + up;
    }



    // Recursion
    private int uniquePathsWithObstacles(int[][] obstacleGrid, int m, int n, int i, int j){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(obstacleGrid[i][j]==1) return 0;
        int left = uniquePathsWithObstacles(obstacleGrid, m, n, i, j-1);
        int up = uniquePathsWithObstacles(obstacleGrid, m, n, i-1, j);
        return left + up;
    }
}
