class Solution {
public:
    int smallestDivisor(vector<int>& nums, int threshold) {
        int lo = 1, hi = *max_element(nums.begin(), nums.end());
        while(lo < hi){
            int mid = (lo + hi) / 2;
            int sum = 0;
            for(auto i : nums) sum += ceil((float)i / (float)mid);
            if(sum <= threshold){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        return lo;
    }
};
