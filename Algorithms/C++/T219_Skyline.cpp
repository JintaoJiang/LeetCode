class Solution {
public:    
    vector<vector<int>> getSkyline(vector<vector<int>>& buildings) {
        vector<vector<int>> res, build;
        for(auto b : buildings){
            build.push_back({b[0], -b[2]});
            build.push_back({b[1], b[2]});
        }
        sort(build.begin(), build.end());
        multiset<int> ms;
        ms.insert(0);
        int prev = 0, cur = 0;
        for(int i = 0; i < build.size(); i++){
            int x = build[i][0], h = build[i][1];
            if(h < 0) ms.insert(-h);
            else ms.erase(ms.find(h));
            cur = *ms.rbegin();
            if(cur != prev){
                res.push_back({x, cur});
                prev = cur;
            }
        }
        return res;
    }
};
