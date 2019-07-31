class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i = 1; i < n; i++){
            if(i == 1 || i == n - 1) dp[i] = dp[i - 1];
            else dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        int res = dp[n - 1];
        dp[0] = 0;
        for(int i = 1; i < n; i++){
            if(i == 1) dp[i] = nums[1];
            else dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        res = Math.max(res, dp[n - 1]);
        return res;
    }
}