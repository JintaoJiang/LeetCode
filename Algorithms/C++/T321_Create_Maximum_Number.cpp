class Solution {
public:
    vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
        int n = nums1.size(), m = nums2.size();
        vector<int> res(k, 0);
        for(int i = max(0, k - m); i <= min(k, n); i++){
            vector<int> l1 = LIS(nums1, i);
            vector<int> l2 = LIS(nums2, k - i);
            vector<int> tmp;
            //absolutely don't just merge it, use lexical compare instead!
            auto iter1 = l1.begin(), iter2 = l2.begin();
            while (iter1 != l1.end() || iter2 != l2.end())
                tmp.push_back(lexicographical_compare(iter1, l1.end(), iter2, l2.end()) ? *iter2++ : *iter1++);
            if(lexicographical_compare(res.begin(), res.end(), tmp.begin(), tmp.end())) 
                res = tmp;
        }
        return res;
    }
    
    /*
    vector<int> merge(vector<int>& nums1, vector<int>& nums2){
        int n = nums1.size(), m = nums2.size(), i = 0, j = 0;
        vector<int> res;
        while(res.size() < m + n){
            if(i == n) res.insert(res.end(), nums2.begin() + j, nums2.end());
            else if(j == m) res.insert(res.end(), nums1.begin() + i, nums1.end());
            else if(nums1[i] >= nums2[j]) res.push_back(nums1[i++]);
            else res.push_back(nums2[j++]);
        }
        return res;
    }
    */
    
    vector<int> LIS(vector<int>& nums, int k){
        int n = nums.size(), pop = n - k;
        vector<int> res;
        for(int i = 0; i < n; i++){            
            while(!res.empty() && nums[i] > res.back() && pop-- > 0) res.pop_back();
            res.push_back(nums[i]);
        }
        res.resize(k);
        return res;
    }
};
