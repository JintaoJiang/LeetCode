class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 2 != 0) return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for(int j = 0; j < nums.length; j++){
            for(int i = sum; i > 0; i--){
                if(i - nums[j] >= 0) dp[i] = dp[i] || dp[i - nums[j]];
            }
        }
        return dp[sum];
    }
}