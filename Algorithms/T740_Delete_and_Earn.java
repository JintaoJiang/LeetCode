class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] dp = new int[n];
        int max = 0;
        for(int num : nums){
            dp[num] += num;
        }
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i - 1], dp[i] + dp[i - 2]);
        }
        return dp[n - 1];
    }
}