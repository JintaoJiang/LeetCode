class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int lo = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            if(nums[i] - nums[i - 1] < lo) lo = nums[i] - nums[i - 1];
        }
        int hi = nums[n - 1] - nums[0];
        
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            int numPair = 0;
            for(int i = 0, j = 0; i < n; i++){
                while(j < n && nums[j] - nums[i] <= mid) j++;
                numPair += j - i - 1;
            }
            if(numPair < k) lo = mid + 1;
            else hi = mid;
        }
        
        return lo;
    }
}