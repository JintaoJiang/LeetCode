class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int res = 0;
        boolean[][] mask = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!mask[i][j] && grid[i][j] == '1'){
                    helper(grid, i, j, mask);
                    res++;
                }
            }
        }
        return res;
    }
    
    private void helper(char[][] grid, int i, int j, boolean[][] mask){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || mask[i][j] || grid[i][j] == '0') return;
        mask[i][j] = true;
        helper(grid, i + 1, j, mask);
        helper(grid, i - 1, j, mask);
        helper(grid, i, j + 1, mask);
        helper(grid, i, j - 1, mask);
        return;
    }
}