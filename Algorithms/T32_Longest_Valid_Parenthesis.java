class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length(), res = 0;
        int[] dp = new int[n];
        for(int i = 1; i < n; i++){
            if(s.charAt(i) == ')'){
                int j = i - 1 - dp[i - 1];
                if(j >= 0 && s.charAt(j) == '('){
                    dp[i] = 2 + dp[i - 1];
                    if(j > 0) dp[i] += dp[j - 1];
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}