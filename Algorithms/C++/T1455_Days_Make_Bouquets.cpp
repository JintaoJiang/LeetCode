class Solution {
public:
    int minDays(vector<int>& bloomDay, int m, int k) {
        int n = bloomDay.size();
        if(n < m * k) return -1;
        int lo = 0, hi = 1e9;
        while(lo < hi){
            int mid = (hi + lo) / 2, flower = 0, bouquet = 0;
            for(int i = 0; i < n; i++){
                if(bloomDay[i] > mid){
                    flower = 0;
                }else if(++flower == k){
                    flower = 0;
                    bouquet++;
                }
            }
            if(bouquet >= m){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        return lo;
    }
};
