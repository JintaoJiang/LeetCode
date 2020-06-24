class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        vector<int> res(2);
        int combine = 0, idx = 0;
        for(auto n : nums) combine ^= n;
        for(int i = 0; i < 32; ++i){
            if(((combine >> i) & 1) != 0){
                idx = i;
                break;
            }
        }
        for(auto n : nums){
            if(((n >> idx) & 1) != 0){
                res[0] ^= n;
            }
        } 
        res[1] = combine ^ res[0];
        return res;
    }
};
