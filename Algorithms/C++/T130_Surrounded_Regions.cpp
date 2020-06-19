class Solution {
public:
    void solve(vector<vector<char>>& board) {
        int m = board.size();
        if(m == 0) return;
        int n = board[0].size();
        vector<vector<bool>> mask(m, vector<bool>(n, 0));
        
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O')
                    DFS(board, mask, i, j);
            }
        }
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(!mask[i][j]) board[i][j] = 'X';
            }
        }
    }
    void DFS(vector<vector<char>>& board, vector<vector<bool>>& mask, int i, int j){
        int m = board.size(), n = board[0].size();
        if(i < 0 || i >= m || j < 0 || j >= n || mask[i][j] || board[i][j] == 'X') return;
        mask[i][j] = true;
        vector<vector<int>> dir = {{-1,0},{1,0},{0,-1},{0,1}};
        for(auto d : dir){
            DFS(board, mask, i + d[0], j + d[1]);
        }
    }
};
