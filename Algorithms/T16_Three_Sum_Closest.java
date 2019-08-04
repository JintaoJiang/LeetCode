class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length, t = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < n - 2; i++){
            int lo = i + 1, hi = n - 1;
            while(lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi] - target;              
                if(Math.abs(sum) < Math.abs(t)) t = sum;
                if(sum > 0){
                    hi--;
                }else if(sum < 0){
                    lo++;   
                }else{
                    return target;
                }
            }
        }
        return t + target;
    }
}