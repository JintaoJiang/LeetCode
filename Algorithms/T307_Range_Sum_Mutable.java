class NumArray {
    
    int[] BIT, nums;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        BIT = new int[n + 1];
        this.nums = new int[n];
        for(int i = 0; i < n; i++){
            update(i, nums[i]);
        }
    }
    
    public void update(int i, int val) {
        int up = val - nums[i];
        nums[i] = val;
        i++;
        while(i <= n){
            BIT[i] += up;
            i = i + (i & (-i));
        }
    }
    
    public int sumRange(int i, int j) {
        int ival = 0, jval = 0;
        while(i > 0){
            ival += BIT[i];
            i = i - (i & (-i));
        }
        j++;
        while(j > 0){
            jval += BIT[j];
            j = j - (j & (-j));
        }
        return jval - ival;
    }
}