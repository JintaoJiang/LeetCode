class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return -1;
        int lo = 0, hi = n - 1;
        //find the trough
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] > nums[hi]) lo = mid + 1;
            else hi = mid;
        }
        //find the peak
        if(lo == 0) hi = n - 1;
        else hi = lo - 1;
        //find target
        if(target >= nums[lo] && target <= nums[hi]){
            if(target >= nums[0]) lo = 0;
            else hi = n - 1;
            while(lo < hi){
                int mid = lo + (hi - lo) / 2;
                if(nums[mid] < target) lo = mid + 1;
                else hi = mid;
            }
            if(nums[lo] != target) return -1;
            return lo;
        }else{
            return -1;
        }
    }
}