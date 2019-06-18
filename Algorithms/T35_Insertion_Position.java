class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while(lo + 1 < hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] < target) lo = mid;
            else if(nums[mid] == target) return mid;
            else hi = mid;
        }
        if(target <= nums[lo]) return lo;
        else if(target <= nums[hi]) return hi;
        else return hi + 1;
    }
}