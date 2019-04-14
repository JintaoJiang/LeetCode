class Solution {
    public int numTrees(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return DFS(1, n, dp);
    }
    
    private int DFS(int left, int right, int[][] dp){
        if(left > right) return 1;
        if(dp[left][right] > 0) return dp[left][right];
        int sum = 0;
        for(int i = left; i <= right; i++){
            int l = DFS(left, i - 1, dp);
            int r = DFS(i + 1, right, dp);
            sum += l * r;
        }
        dp[left][right] = sum;
        return sum;
    }
}
