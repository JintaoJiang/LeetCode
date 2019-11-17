class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        for(int n : nums){
            int[] temp = new int[3];
            for(int i = 0; i < 3; i++){
                if(i == 0 || dp[i] > 0){
                    temp[(n + i) % 3] = Math.max(dp[(n + i) % 3], dp[i] + n);
                }else{
                    temp[(n + i) % 3] = dp[(n + i) % 3];
                }
            }
            dp = temp;
        }
        return dp[0];
    }
}