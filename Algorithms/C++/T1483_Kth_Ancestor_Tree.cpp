class TreeAncestor {
public:
    vector<vector<int>> dp;
    TreeAncestor(int n, vector<int>& parent) {
        dp = vector<vector<int>>(n, vector<int>(17));
        for(int i = 0; i < n; ++i){
            dp[i][0] = parent[i];
        }
        for(int k = 1; k <= 16; ++k){
            for(int i = 0; i < n; ++i){
                if(dp[i][k - 1] == -1) dp[i][k] = -1;
                else dp[i][k] = dp[dp[i][k - 1]][k - 1];
            }
        }
    }
    
    int getKthAncestor(int node, int k) {
        for(int i = 0; i <= 16; ++i){
            if(k & (1 << i)){
                node = dp[node][i];
                if(node == -1) return -1;
            }
        }
        return node;
    }
};
