class Solution {
public:
    int lowbit(int x){
        return x & -x;
    }
    
    void add(vector<int>& tr, int idx, int val){
        for(int i = idx; i < tr.size(); i += lowbit(i)) tr[i] += val;
    }
    
    int sum(vector<int>& tr, int idx){
        int res = 0;
        for(int i = idx; i > 0; i -= lowbit(i)) res += tr[i];
        return res;
    }
       
    int reversePairs(vector<int>& nums) {
        int res = 0, n = nums.size();
        vector<int> sn(nums);
        sort(sn.begin(), sn.end());
        vector<int> tr(n + 1);
        for(int i = 0; i < n; i++){
            int search = lower_bound(sn.begin(), sn.end(), nums[i] * 2LL + 1) - sn.begin() + 1;
            if(search <= n) res += sum(tr, n) - sum(tr, search - 1);
            add(tr, lower_bound(sn.begin(), sn.end(), nums[i]) - sn.begin() + 1, 1);
        }
        
        return res;
    }
};
