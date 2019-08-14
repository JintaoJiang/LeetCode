class Solution {
    public int splitArray(int[] nums, int m) {
        //DP
        int n = nums.length;
        long[] sums = new long[n + 1];
        sums[0] = 0;
        for(int i = 0; i < n; i++){
            sums[i + 1] = sums[i] + nums[i];
        }
        long[] dp = new long[n];
        for(int i = 0; i < n; i++){
            dp[i] = sums[n] - sums[i];
        }
        for(int s = 2; s <= m; s++){
            for(int i = 0; i < n; i++){
                dp[i] = Integer.MAX_VALUE;
                for(int j = i + 1; j <= n - s + 1; j++){
                    dp[i] = Math.min(dp[i], Math.max(dp[j], sums[j] - sums[i]));
                }
            }
        }
        return (int)dp[0];
    }
}
