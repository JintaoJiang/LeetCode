class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int lo = 0, hi = 0;
        int n = weights.length;
        for(int i = 0; i < n; i++){
            hi += weights[i];
            lo = Math.max(lo, weights[i]);
        }
        while(lo < hi){
            int mid = (lo + hi) / 2;
            int temp = 0, days = 1;
            for(int i = 0; i < n; i++){
                temp += weights[i];
                if(temp > mid){
                    days++;
                    temp = weights[i];
                }
            }
            if(days > D) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}