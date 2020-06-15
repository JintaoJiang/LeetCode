class Solution {
public:
    int minDistance(vector<int>& houses, int k) {
        int n = houses.size();
        sort(houses.begin(), houses.end());
        vector<vector<int>> dp(k, vector<int>(n, INT_MAX / 2));
        vector<vector<int>> cost(n, vector<int>(n, 0));
        for(int i = 0; i < n; ++i){
            for(int j = i; j < n; ++j){
                int pos = houses[(i + j) / 2];
                int sum = 0;
                for(int jj = i; jj <= j; ++jj){
                    sum += abs(houses[jj] - pos);
                }
                cost[i][j] = sum;
            }
        }
        for(int i = 0; i < n; ++i){
            dp[0][i] = cost[0][i];
        }
        for(int i = 1; i < k; ++i){
            for(int j = 0; j < n; ++j){
                for(int jj = 0; jj < j; ++jj){
                    dp[i][j] = min(dp[i][j], dp[i - 1][jj] + cost[jj + 1][j]);
                }
            }
        }
        return dp[k - 1][n - 1];
    }
};
