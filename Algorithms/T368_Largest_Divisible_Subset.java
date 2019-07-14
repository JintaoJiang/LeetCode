class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n == 0) return new LinkedList();
        int[] par = new int[n];
        Arrays.fill(par, -1);
        int[] dp = new int[n];
        int max = 0, idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    par[i] = j;
                }
                if(dp[i] > max){
                    max = dp[i];
                    idx = i;
                }
            }
        }
        List<Integer> res = new LinkedList();
        while(idx != -1){
            res.add(nums[idx]);
            idx = par[idx];
        }
        return res;
    }
}