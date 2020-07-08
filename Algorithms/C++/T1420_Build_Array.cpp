class Solution {
public:
    int numOfArrays(int n, int m, int k) {
        int mod = 1e9 + 7, res = 0;
        long long dp[51][51][101] = {0};
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= k; j++){
                for(int l = 1; l <= m; l++){
                    if(i == 1 && j == 1) dp[i][j][l] = 1;
                    dp[i][j][l] += dp[i - 1][j][l] * l % mod;
                    for(int ll = 1; ll < l; ll++){
                        dp[i][j][l] += dp[i - 1][j - 1][ll];
                        dp[i][j][l] %= mod;
                    }                
                }
            }
        }
        for(int i = 1; i <= m; i++){
            res += dp[n][k][i];
            res %= mod;
        }
        return res;
    }
};
