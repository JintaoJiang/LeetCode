class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k < 1 || t < 0) return false;
        TreeSet<Long> set = new TreeSet();
        for(int i = 0; i < nums.length; i++){
            Long floor = set.ceiling((long)nums[i] - t);
            if(floor != null && floor <= (long)nums[i] + t) return true;
            if(i >= k) set.remove((long)nums[i - k]);
            set.add((long)nums[i]);
        }
        return false;
    }
}