class Solution {
public:
    int findMaxValueOfEquation(vector<vector<int>>& points, int k) {
        int hh = 0, tt = -1, res = INT_MIN;
        vector<vector<int>> q(points.size(), vector<int>());
        for(auto &p : points){
            while(hh <= tt && p[0] - q[hh][0] > k) hh++;       
            if(hh <= tt) res = max(res, q[hh][1] - q[hh][0] + p[0] + p[1]);
            while(hh <= tt && q[tt][1] - q[tt][0] < p[1] - p[0]) tt--;
            q[++tt] = p;
        }
        return res;
    }
};
