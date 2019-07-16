class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		for(int num : nums) {
			sum += num;
		}
		int target = sum / k;
        if(target * k != sum) return false;
		int[] subset = new int[k];
        Arrays.sort(nums);
		return helper(nums, k, nums.length - 1, subset, target);
    }
	
	private boolean helper(int[] nums, int k, int start, int[] subset, int target) {
		if(start < 0) return true;
		for(int i = 0; i < k; i++) {
            if(i > 0 && subset[i - 1] == 0) return false;
			if(subset[i] + nums[start] <= target) {
				subset[i] += nums[start];
				if(helper(nums, k, start - 1, subset, target)) return true;
				subset[i] -= nums[start];
			}
		}
		return false;
	}
}