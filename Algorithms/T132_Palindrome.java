class Solution {    
    public int minCut(String s) {
        int n = s.length();
        boolean[][] pal = new boolean[n][n];
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            int min = i;
            for(int j = i; j >= 0; j--){
                //is palindrome
                if(s.charAt(j) == s.charAt(i) && (j + 1 >= i - 1 || pal[j + 1][i - 1])){
                    if(j == 0) min = 0;
                    else min = Math.min(min, dp[j - 1] + 1);
                    pal[j][i] = true;
                }
            }
            dp[i] = min;
        }
        return dp[n - 1];
    }
}