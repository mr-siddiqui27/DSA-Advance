package ProblemsOn_Grids_2D;

import java.util.Arrays;

public class NinjaTraining {



    // space optimized
    public static int solve2(int[][] days){
        int n = days.length;
        int first = days[0][0];
        int second = days[0][1];
        int third = days[0][2];

        for(int i=1; i<n; i++){
                int curr1 = days[i][0] + Math.max(second,third);
                int curr2 = days[i][1] + Math.max(first, third);
                int curr3 = days[i][2] + Math.max(first, second);

                first = curr1;
                second = curr2;
                third = curr3;

        }
        return Math.max(first, Math.max(second, third));
    }


    // Tabulation
    public static int solve(int[][] days){
        int n = days.length;
        int[][] dp = new int[n][3];
        dp[0][0] = days[0][0];
        dp[0][1] = days[0][1];
        dp[0][2] = days[0][2];
        for(int i=1; i<n; i++){
            for(int j=0; j<3; j++){
                if(j == 0)
                    dp[i][j] = days[i][j] + Math.max(dp[i-1][1], dp[i-1][2]);
                else if(j == 1)
                    dp[i][j] = days[i][j] + Math.max(dp[i-1][0], dp[i-1][2]);
                else
                    dp[i][j] = days[i][j] + Math.max(dp[i-1][0], dp[i-1][1]);
            }
        }
        return Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2]));
    }



    // Memoization
    public static int solve(int[][] days, int ind, int last, int[][] dp){
        if(ind==0){
            int max = 0;
            for(int i=0; i<3; i++)
                if(i!=last)
                    max = Math.max(max, days[0][i]);
            return  max;
        }
        if(dp[ind][last]!=-1) return dp[ind][last];
        int max = 0;
        for(int i=0; i<3; i++){
            if(i!=last){
                int point = days[ind][i] + solve(days, ind-1, i, dp);
                max = Math.max(max, point);
            }
        }
        return dp[ind][last] = max;
    }


    // recursion without DP
    public static int solve(int[][] days, int ind, int last){
        if(ind==0){
            int max = 0;
            for(int i=0; i<3; i++)
                if(i!=last)
                    max = Math.max(max, days[0][i]);
            return max;
        }
        int max = 0;
        for(int i=0; i<3; i++){
            if(i!=last){
                int point = days[ind][i] + solve(days, ind-1, i);
                max = Math.max(max, point);
            }
        }
        return max;
    }



    public static void main(String[] args){
        int[][] days = {{2,1,3}, {3,4,6}, {10,3,7}, {8,3,7}};
        int n = days.length;

        // RECURSION
        int maxPoints = solve(days, n-1, 3);
        System.out.println(maxPoints);


        // MEMOIZATION
        int[][] dp = new int[n][4];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        System.out.println(solve(days, n-1, 3, dp));



        //TABULATION
        System.out.println(solve2(days));
    }

}
