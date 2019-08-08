class Solution {
    public int jump(int[] nums) {
        int res = 0, curMax = 0, nextMax = 0;
        for(int i = 0; i < nums.length - 1; i++){
            nextMax = Math.max(nextMax, i + nums[i]);
            if(i == curMax){
                curMax = nextMax;
                res++;
            }
        }
        return res;
    }
}