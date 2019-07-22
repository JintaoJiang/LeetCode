class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        for(int i = 0; i < n; i++){
            for(int k = 0; k < n; k++){
                dp[i][i][k] = (k + 1) * (k + 1);
            }
        }
        for(int i = n - 1; i >= 0; i--){
            for(int j = i + 1; j < n; j++){
                for(int k = n - j - 1; k >= 0; k--){
                    int res = dp[i][j - 1][0] + (k + 1) * (k + 1);
                    for(int jj = i; jj < j; jj++){
                        if(boxes[jj] == boxes[j]){
                            res = Math.max(res, dp[i][jj][k + 1] + dp[jj + 1][j - 1][0]);
                        }
                    }
                    dp[i][j][k] = res;
                }    
            }
        }
        return dp[0][n - 1][0];
    }
}