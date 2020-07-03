class Solution {
public:
    int numSubseq(vector<int>& nums, int target) {
        int mod = 1e9 + 7, res = 0, n = nums.size();
        vector<int> power(n, 1);
        for(int i = 1; i < n; i++) power[i] = (2 * power[i - 1]) % mod;
        sort(nums.begin(), nums.end());
        for(int i = 0; i < nums.size(); i++){
            auto it = upper_bound(nums.begin() + i, nums.end(), target - nums[i]);
            int j = it - nums.begin() - 1;
            if(j < i) continue;
            res = (res + power[j - i]) % mod;
        }
        return res;
    }
};
