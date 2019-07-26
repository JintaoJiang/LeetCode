class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        if(n < 3) return 0;
        int[] dp = new int[n];
        int res = 0;
        for(int i = 2; i < n; i++){
            if(A[i] + A[i - 2] == 2 * A[i - 1]){
                dp[i] = dp[i - 1] + 1;
            }else{
                res += (1 + dp[i - 1]) * dp[i - 1] / 2;
            }
        }
        res += (1 + dp[n - 1]) * dp[n - 1] / 2;
        return res;
    }
}