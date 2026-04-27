import java.util.Arrays;

public class FrogJump {

    public static int jump(int n, int[] height, int[] dp){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int left = jump(n-1, height, dp) + Math.abs(height[n] - height[n-1]);
        int right = Integer.MAX_VALUE;
        if(n>1) right = jump(n-2, height, dp) + Math.abs(height[n] - height[n-2]);
        return dp[n] = Math.min(left, right);

    }

    public static void main(String[] args) {
        int[] height = {30, 10, 60, 10, 60, 50};
        int n = height.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(jump(n-1, height, dp));
    }
}
