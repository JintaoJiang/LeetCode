class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        int n = nums.size();
        if(n == 0) return vector<int>();
        vector<int> dp(n, 0);
        vector<int> p(n, -1);
        vector<int> res;
        int max = 0, idx = 0;
        sort(nums.begin(), nums.end());
        for(int i = 0; i < n; i++){
            for(int j = i - 1; j >= 0; j--){
                if(nums[i] % nums[j] == 0){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        p[i] = j;
                    }                    
                }
            }
            if(dp[i] > max){
                max = dp[i];
                idx = i;
            }
        }
        while(idx != -1){
            res.push_back(nums[idx]);
            idx = p[idx];           
        }
        return res;
    }
};
