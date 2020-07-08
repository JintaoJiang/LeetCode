class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        int m = grid.size();
        if(m == 0) return 0;
        int n = grid[0].size(), res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) res += 4 - count(grid, i, j);
            }
        }
        return res;
    }
    
    int count(vector<vector<int>>& grid, int i, int j){
        int res = 0, m = grid.size(), n = grid[0].size();
        if(i > 0 && grid[i - 1][j] == 1) res++;
        if(i < m - 1 && grid[i + 1][j] == 1) res++;
        if(j > 0 && grid[i][j - 1] == 1) res++;
        if(j < n - 1 && grid[i][j + 1] == 1) res++;
        return res;
    }
};
