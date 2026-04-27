import java.util.Arrays;

public class Fibonacci {

    // Memoization
    public static int fibo(int n, int[] dp){
        if(n<=1) return n;

        if(dp[n]!=-1) return dp[n];

        return dp[n] = fibo(n-1, dp) + fibo(n-2, dp);
    }

    // tabulation
    public static int fibo(int n){
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2; i<=n; i++){
            dp[i]=dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // space optimization
    public static int fibo2(int n){
        int pre = 1;
        int pre2 = 0;
        int curr;
        for(int i=2; i<=n; i++){
            curr = pre + pre2;
            pre2 = pre;
            pre = curr;
        }
        return pre;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(fibo2(n));
    }
}
