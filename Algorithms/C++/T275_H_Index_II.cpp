class Solution {
public:
    int hIndex(vector<int>& c) {
        int lo = 0, hi = c.size() - 1, n = c.size();
        if(n == 0) return 0;
        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(n - mid > c[mid]){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        return n - hi <= c[hi] ? n - hi : n - hi - 1;
    }
};
