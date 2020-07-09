class Solution {
public:
    int mergeStones(vector<int>& stones, int K) {
        int n = stones.size(), inf = 1e9;
        vector<vector<vector<int>>> dp(n + 1, vector<vector<int>>(n + 1, vector<int>(n + 1, -1)));
        vector<int> prefix(n + 1);
        for(int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + stones[i];
        
        function<int(int, int, int)> helper = [&](int i, int j, int k){
            if(dp[i][j][k] != -1) return dp[i][j][k];
            int res = inf;
            if(i == j){
                res = k == 1 ? 0 : inf;
            }else if((j - i + 1 - k) % (K - 1) != 0){
                res = inf;
            }else if(k == 1){
                res = helper(i, j, K) + prefix[j] - prefix[i - 1];
            }else{
                for(int mid = i; mid < j; mid += K - 1){
                    res = min(res, helper(i, mid, 1) + helper(mid + 1, j, k - 1));
                }
            }
            dp[i][j][k] = res;
            return res;
        };
        
        int res = helper(1, n, 1);
        return res == inf ? -1 : res;
    }
};
