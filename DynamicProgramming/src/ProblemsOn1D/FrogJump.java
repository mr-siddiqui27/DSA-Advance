package ProblemsOn1D;

import java.util.Arrays;

public class FrogJump {

    // Memoization
    public static int jump1(int n, int[] height, int[] dp){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int left = jump1(n-1, height, dp) + Math.abs(height[n] - height[n-1]);
        int right = Integer.MAX_VALUE;
        if(n>1) right = jump1(n-2, height, dp) + Math.abs(height[n] - height[n-2]);
        return dp[n] = Math.min(left, right);

    }

    // Tabulation
    public static int jump(int[] height){
        int n = height.length;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = Math.abs(height[0]-height[1]);
        for(int i=2; i<n; i++){
            int oneStep = Math.abs(height[i]-height[i-1]) + dp[i-1];
            int twoSteps = Math.abs(height[i]-height[i-2]) + dp[i-2];
            dp[i] = Math.min(oneStep, twoSteps);
        }
        return dp[n-1];
    }

    // Optimized
    public static int jump2(int[] height){
        int n = height.length;
        int pre2 = 0;
        int pre = Math.abs(height[0]-height[1]);
        for(int i=2; i<n; i++){
            int oneStep = Math.abs(height[i]-height[i-1]) + pre;
            int twoSteps = Math.abs(height[i]-height[i-2]) + pre2;
            int curr = Math.min(oneStep, twoSteps);
            pre2 = pre;
            pre = curr;
        }
        return pre;
    }

    // Memoization with k steps
    public static int jump(int n, int[] height, int k, int[] dp){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int min = Integer.MAX_VALUE;
        for(int j=1; j<=k; j++){
            if(n-j>=0)  min = Math.min(min, jump(n-j, height, k, dp) + Math.abs(height[n] - height[n-j]));
        }
        return dp[n] = min;
    }

    // Tabulation with k jump
    public static int jump(int[] height, int k){
        int n = height.length;
        int[] dp = new int[n];
        dp[0] = 0;
        int min = Integer.MAX_VALUE;
        for(int i=1; i<n; i++){
            for(int j=1; j<=k; j++){
                if(i-j>=0){
                    int cost = Math.abs(height[i]-height[i-j]) + dp[i-j];
                    min = Math.min(min, cost);
                }
            }
            dp[i] = min;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] height = {30, 10, 60, 10, 60, 50, 50, 60};
        int n = height.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        // Memoization
        System.out.println(jump1(n-1, height, dp));

        // Tabulation
        System.out.println(jump(height, 5));

        // Optimized
        System.out.println(jump2(height));
    }
}
