class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        int[][] dp = new int[2][len];
        if(len < 2) return 0;
        
        //For edge cases that will result in TLE
        if (k >= len / 2) {
            int res = 0;
            for (int i = 1; i < len; i++) {
                if (prices[i] > prices[i - 1]) res += prices[i] - prices[i-1];
            }
            return res;
        }
        
        for(int i = 1; i <= k; i++){
            int curr = i % 2, past = (i + 1) % 2;
            int localMax = dp[past][0] - prices[0];
            for(int j = 1; j < len; j++){
                dp[curr][j] = Math.max(prices[j] + localMax, dp[curr][j - 1]);
                localMax = Math.max(localMax, dp[past][j - 1] - prices[j]);
            }
        }
        return Math.max(dp[0][len - 1], dp[1][len - 1]);
    }
}