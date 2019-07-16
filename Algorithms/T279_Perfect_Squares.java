class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for(int i = 0; i <= n; i++){
            dp[i] = i;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 2; Math.pow(j, 2) <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - (int)Math.pow(j, 2)] + 1);
            }
        }
        return dp[n];
    }
}