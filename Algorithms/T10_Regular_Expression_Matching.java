class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int j = 2; j <= n; j += 2){
            if(p.charAt(j - 1) == '*') dp[0][j] = true; 
            else break;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                char c1 = s.charAt(i - 1), c2 = p.charAt(j - 1);
                if(c2 == '*'){
                    dp[i][j] = dp[i][j - 2] || ((p.charAt(j - 2) == c1 || p.charAt(j - 2) == '.') && (dp[i][j - 1] || dp[i - 1][j]));
                }else if(c2 == '.' || c2 == c1){
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }        
        return dp[m][n];
    }
}