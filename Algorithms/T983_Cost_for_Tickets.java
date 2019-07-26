class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int target = days[days.length - 1], p = 0;
        int[] dp = new int[target + 1];
        for(int i = 1; i <= target; i++){
            if(i == days[p]){
                dp[i] = Math.min(Math.min(costs[0] + dp[i - 1], costs[1] + dp[i - 7 >= 0 ? i - 7 : 0]), costs[2] + dp[i - 30 >= 0 ? i - 30 : 0]);                
                p++;
            }else{
                dp[i] = dp[i - 1];
            }
        }
        return dp[target];
    }
} 