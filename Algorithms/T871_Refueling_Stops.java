class Solution {   
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        int[] dp = new int[n + 1];
        dp[0] = startFuel;
        for(int i = 1; i <= n; i++){
            for(int j = i ; j > 0; j--){
                if(dp[j - 1] >= stations[i - 1][0]) dp[j] = Math.max(dp[j], dp[j - 1] + stations[i - 1][1]);
            }
        }
        for(int i = 0; i <= n; i++){
            if(dp[i] >= target) return i;
        }
        return -1;
    }   
}