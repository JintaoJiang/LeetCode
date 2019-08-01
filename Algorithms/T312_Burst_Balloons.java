class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[][] dp = new int[n][n];
        for(int j = 0; j < n; j++){
            for(int i = j; i >= 0; i--){
                for(int jj = j; jj >= i; jj--){
                    int res = nums[jj];
                    if(i - 1 >= 0) res *= nums[i - 1];
                    if(j + 1 < n) res *= nums[j + 1];
                    if(jj - 1 >= 0) res += dp[i][jj - 1];
                    if(jj + 1 < n) res += dp[jj + 1][j];
                    dp[i][j] = Math.max(dp[i][j], res);
                }
            }
        }
        return dp[0][n - 1];
    }
}