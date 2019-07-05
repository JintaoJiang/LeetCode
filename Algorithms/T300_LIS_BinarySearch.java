class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[] tails = new int[n];
        int res = 0;
        for(int num : nums){
            int lo = 0, hi = res;
            while(lo != hi){
                int mid = (lo + hi) / 2;
                if(num > tails[mid]) lo = mid + 1;
                else hi = mid;
            }
            tails[lo] = num;
            if(lo == res) res++;
        }
        return res;
    }
}