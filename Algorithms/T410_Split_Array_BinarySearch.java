class Solution {
    public int splitArray(int[] nums, int m) {
        //binary search
        long max = 0, sum = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }
        
        long left = max, right = sum;
        while(left < right){
            long mid = (left + right) / 2;
            if(doable(nums, mid, m)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return (int)left;
    }
    
    private boolean doable(int[] nums, long max, int m){
        int numArr = 1;
        long sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum > max){
                sum = nums[i];
                numArr++;
            }
            if(numArr > m) return false;
        }
        return true;
    }
}
