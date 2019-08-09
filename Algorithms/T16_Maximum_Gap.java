class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        if(n < 2) return 0;
        for(int i = 0; i < n; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        int[][] bucket = new int[n + 1][2];
        double r = (max - min) / (double)n;
        for(int i = 0; i < n; i++){
            int j = (int)Math.floor((nums[i] - min) / r);
            bucket[j][0] = bucket[j][0] == 0 ? nums[i] : Math.min(bucket[j][0], nums[i]);
            bucket[j][1] = Math.max(bucket[j][1], nums[i]);
        }
        int res = 0, i = 0;
        while(i < n){
            int small = bucket[i][1];
            i++;
            while(i < n && bucket[i][0] == 0) i++;
            int large = bucket[i][0];
            res = Math.max(res, large - small);
        }
        return res;
    }
}