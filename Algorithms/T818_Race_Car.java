class Solution {
    int dp[] = new int[10001];
    
    public int racecar(int target) {
        int t = target;
        if(dp[t] > 0) return dp[t];
        int n = (int) (Math.log(t) / Math.log(2)) + 1;
        if((1 << n) - 1 == t){
            dp[t] = n;
        }else{
            dp[t] = n + 1 + racecar((1 << n) - 1 - t);
            for(int m = 0; m < n - 1; m++){
                dp[t] = Math.min(dp[t], n + m + 1 + racecar(t - ((1 << (n - 1)) - (1 << m))));
            }
        }
        return dp[t];
    }
}