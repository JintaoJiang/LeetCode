class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n + 1];
        int[] dp2 = new int[n + 1];
        dp2[0] = Integer.MIN_VALUE;
        int res = nums[0];
        for(int i = 0; i < n; i++){
            if(nums[i] >= 0){
                dp1[i + 1] = Math.max(dp1[i], 1) * nums[i];
                dp2[i + 1] = dp2[i] == Integer.MIN_VALUE ? Integer.MIN_VALUE : nums[i] * dp2[i];
            }else{
                dp1[i + 1] = dp2[i] == Integer.MIN_VALUE ? Integer.MIN_VALUE : dp2[i] * nums[i];
                dp2[i + 1] = Math.max(dp1[i], 1) * nums[i];
            }
            res = Math.max(res, dp1[i + 1]);
        }
        return res;
    }
}