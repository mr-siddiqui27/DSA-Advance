public class HouseRobber1 {

    // optimized
    private int optimized(int[] nums){
        int n = nums.length;
        int pre1 = 0;
        int pre2 = 0;
        for(int i=0; i<n; i++){
            int curr = Math.max(pre1, nums[i]+pre2);
            pre2 = pre1;
            pre1 = curr;
        }
        return pre1;
    }


    private int tabulation(int[] nums){
        int n = nums.length;
        if(n==1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<n; i++){
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);
        }
        return dp[n-1];
    }

    // memoization
    private int rob(int[] nums, int ind, int[] dp){
        if(ind == 0) return nums[ind];
        if(ind < 0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int pick = nums[ind] + rob(nums, ind-2, dp);
        int notPick = rob(nums, ind-1, dp);
        return dp[ind] = Math.max(pick, notPick);
    }


}
