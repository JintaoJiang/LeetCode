class Solution {
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int n = group.length;
        int[][][] dp = new int[n + 1][P + 1][G + 1];
        dp[0][0][0] = 1;
        int mod = (int)1e9 + 7;
        for(int k = 1; k <= n; k++){
            int p = profit[k - 1], g = group[k - 1];
            for(int i = 0; i <= P; i++){
                for(int j = 0; j <= G; j++){
                    dp[k][i][j] = dp[k - 1][i][j];
                    if(j >= g){
                        dp[k][i][j] = (dp[k][i][j] + dp[k - 1][Math.max(i - p, 0)][j - g]) % mod;
                    }
                }               
            }
        }
        int res = 0;
        for(int i : dp[n][P]) System.out.println(i);
        for(int i : dp[n][P]) res = (res + i) % mod;
        return res;
    }
}