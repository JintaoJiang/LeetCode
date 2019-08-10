class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] res = Arrays.copyOfRange(nums, 0, n);
        Arrays.sort(res);
        for(int i = 0, j = (n + 1) / 2 - 1, k = n - 1; i < n; i++){
            if(i % 2 == 0) nums[i] = res[j--];
            else nums[i] = res[k--];
        }
    }
}