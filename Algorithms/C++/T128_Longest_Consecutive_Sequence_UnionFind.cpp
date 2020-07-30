class Solution {
public:
    unordered_map<int, int> p;
    
    int find(int x){
        if(p.count(x)) return p[x] = find(p[x]);
        return x;
    }
    
    int longestConsecutive(vector<int>& nums) {
        int res = 0;
        for(int num : nums) p[num] = num + 1;
        for(int num : nums){
            int end = find(num);
            res = max(res, end - num);
        }
        return res;
    }
};
