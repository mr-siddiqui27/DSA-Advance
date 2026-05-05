package ProblemsOn1D;

public class ClimbingStairs {

    public static int climbStairs(int n) {
        int pre = 1;
        int pre2 = 1;
        for(int i=2; i<=n; i++){
            int curr = pre + pre2;
            pre2 = pre;
            pre = curr;
        }
        return pre;
    }

    // public static int climbStairs(int n) {
    //     int[] dp = new int[n+1];
    //     dp[0] = 1;
    //     dp[1] = 1;
    //     for(int i=2; i<=n; i++){
    //         dp[i] = dp[i-1] + dp[i-2];
    //     }
    //     return dp[n];
    // }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

}
