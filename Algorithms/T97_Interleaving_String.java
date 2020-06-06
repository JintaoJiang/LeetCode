class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if(m + n != s3.length()) return false;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int i = 1; i <= m; i++) 
            dp[i][0] = (s3.charAt(i - 1) ==  s1.charAt(i - 1)) && dp[i - 1][0];
        for(int j = 1; j <= n; j++) 
            dp[0][j] = (s3.charAt(j - 1) ==  s2.charAt(j - 1)) && dp[0][j - 1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                char c3 = s3.charAt(i + j - 1), c2 = s2.charAt(j - 1), c1 = s1.charAt(i - 1);
                dp[i][j] = (c3 == c2 && dp[i][j - 1]) || (c3 == c1 && dp[i - 1][j]);
            }
        }
        return dp[m][n];
    }
}