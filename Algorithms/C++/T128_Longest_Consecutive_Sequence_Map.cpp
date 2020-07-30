class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_map<int, int> dict;
        int res = 0;
        for(int num : nums){
            if(!dict.count(num)){
                int len = 1;      
                if(dict.count(num + 1)) len += dict[num + 1];
                if(dict.count(num - 1)) len += dict[num - 1];
                dict[num] = len;
                if(dict.count(num + 1)) dict[num + dict[num + 1]] = len;
                if(dict.count(num - 1)) dict[num - dict[num - 1]] = len;
                res = max(res, len);
            }
        }
        return res;
    }
};
