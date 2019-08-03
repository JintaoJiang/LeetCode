class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int i : nums) sum += i;
        if(sum < S) return 0;
        int[] dp = new int[2 * sum + 1];
        dp[sum] = 1;
        for(int i = 0; i < nums.length; i++){
            int[] next = new int[2 * sum + 1];
            for(int j = 0; j <= 2 * sum; j++){
                if(dp[j] != 0){
                    next[j + nums[i]] += dp[j];
                    next[j - nums[i]] += dp[j];
                }
            }
            dp = next;
        }
        return dp[sum + S];
    }
}