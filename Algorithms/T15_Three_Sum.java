class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new LinkedList();
        Arrays.sort(nums);
        for(int i = 0; i < n; i++){
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int lo = i + 1, hi = n - 1;
            while(lo < hi){
                while(lo < hi && lo != i + 1 && nums[lo] == nums[lo - 1]) lo++;
                while(lo < hi && hi != n - 1 && nums[hi] == nums[hi + 1]) hi--;
                if(lo == hi) break;
                if(nums[i] + nums[lo] + nums[hi] > 0) hi--;
                else if(nums[i] + nums[lo] + nums[hi] < 0) lo++;
                else{
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    lo++; hi--;
                }
            }
        }
        return res;
    }
}