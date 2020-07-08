class Solution {
public:
    int maxSatisfaction(vector<int>& sat) {
        sort(sat.begin(), sat.end());
        int pos = lower_bound(sat.begin(), sat.end(), 0) - sat.begin();
        int res = 0, n = sat.size();
        if(pos >= n) return 0;
        int sum = accumulate(sat.begin() + pos, sat.end(), 0);
        for(int i = 1; i < n - pos + 1; i++){
            res += i * sat[i + pos - 1];
        }    
        for(int i = 1; i < pos + 1; i++){
            int tmp = res + sum + sat[pos - i];
            sum += sat[pos - i];
            res = max(res, tmp);
        }
        return res;
    }
};
