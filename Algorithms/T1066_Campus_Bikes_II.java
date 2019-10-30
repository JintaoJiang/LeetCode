class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        int m = workers.length, n = bikes.length;
        int[][] dp = new int[m][1 << n];
        return DFS(workers, bikes, dp, 0, 0);
    }
    
    private int DFS(int[][] workers, int[][] bikes, int[][] dp, int cur, int taken){
        if(cur == workers.length) return 0;
        if(dp[cur][taken] > 0) return dp[cur][taken];
        int best = Integer.MAX_VALUE;
        for(int i = 0; i < bikes.length; i++){
            if((taken & (1 << i)) != 0) continue;
            int dist = Math.abs(workers[cur][0] - bikes[i][0]) + Math.abs(workers[cur][1] - bikes[i][1]);
            best = Math.min(best, dist + DFS(workers, bikes, dp, cur + 1, taken | (1 << i)));
        }
        dp[cur][taken] = best;
        return best;
    }
}