class Solution {
    public int findIntegers(int num) {
        char[] s = Integer.toBinaryString(num).toCharArray();
        int n = s.length;
        int[][] dp = new int[n][2];
        dp[n - 1][0] = 1; dp[n - 1][1] = 1;
        for(int i = n - 2; i >= 0; i--){
            dp[i][0] = dp[i + 1][0] + dp[i + 1][1];
            dp[i][1] = dp[i + 1][0];
        }
        int res = dp[0][0] + dp[0][1];
        for(int i = 1; i < s.length; i++){
            if(s[i] == '1' && s[i - 1] == '1') break;
            if(s[i] == '0' && s[i - 1] == '0') res -= dp[i][1];
        }
        return res;
    }
}