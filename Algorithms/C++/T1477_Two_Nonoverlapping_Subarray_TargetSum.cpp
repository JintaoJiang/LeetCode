class Solution {
public:
    int minSumOfLengths(vector<int>& arr, int target) {
        int n = arr.size();
        vector<int> prefix(n + 1, 0);
        unordered_map<int, int> map;
        vector<int> dp(n + 1, INT_MAX);
        map[0] = 0;
        int res = INT_MAX;
        for(int i = 1; i <= n; ++i){
            prefix[i] = prefix[i - 1] + arr[i - 1];
            map[prefix[i]] = i;
            if(map.find(prefix[i] - target) != map.end()){
                int pos = map[prefix[i] - target];
                if(dp[pos] != INT_MAX) res = min(res, dp[pos] + i - pos);
                dp[i] = min(dp[i - 1], i - pos);
            }else{
                dp[i] = dp[i - 1];
            }
            cout <<dp[i]<<" ";
        }
        return res == INT_MAX ? -1 : res;
    }
};
