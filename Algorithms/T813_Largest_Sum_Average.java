class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        double[][] dp = new double[K + 1][n + 1];
        double[] prefix = new double[n + 1];
        for(int i = 1; i <= n; i++){
            prefix[i] = prefix[i - 1] + A[i - 1];   
            dp[1][i] = prefix[i] / i;
        }
        for(int i = 2; i <= K; i++){
            for(int j = i; j <= n; j++){
                for(int jj = i - 1; jj < j; jj++){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][jj] + (prefix[j] - prefix[jj]) / (j - jj));
                }                   
            }
        }
        return dp[K][n];
    }
}