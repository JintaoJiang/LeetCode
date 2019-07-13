class NumArray {
    int nums[], prefix[];
    
    public NumArray(int[] nums) {
        this.nums = nums;
        prefix = new int[nums.length + 1];
        int sum = 0;
        for(int i = 1; i <= nums.length; i++){
            sum += nums[i - 1];
            prefix[i] = sum;
        }
    }
    
    public int sumRange(int i, int j) {
        return prefix[j + 1] - prefix[i];
    }
}