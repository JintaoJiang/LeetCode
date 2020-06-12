class Solution {
public:
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        int m = matrix.size();
        if(m == 0) return 0;
        int n = matrix[0].size();
        
        vector<vector<int>> dp(m, vector<int>(n, 0));
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                res = max(res, DFS(matrix, dp, i, j));
            }
        }
        return res;
    }
    
    int DFS(vector<vector<int>>& matrix, vector<vector<int>>& dp, int i, int j){
        int m = matrix.size(), n = matrix[0].size();
        if(dp[i][j] != 0) return dp[i][j];
        int res = 1;
        vector<vector<int>> dir = {{1,0},{0,1},{-1,0},{0,-1}};
        for(auto d : dir){
            int ii = i + d[0], jj = j + d[1];
            if(ii >= m || ii < 0 || jj >= n || jj < 0 || matrix[i][j] >= matrix[ii][jj]) continue;
            res = max(res, 1 + DFS(matrix, dp, ii, jj));
        }
        dp[i][j] = res;
        return res;
    }
};
