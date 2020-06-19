class SummaryRanges {
public:
    struct cmp{ bool operator() (const vector<int> a, const vector<int> b) const { return a[0] < b[0]; } };
    set<vector<int>, cmp> intval;
    /** Initialize your data structure here. */
    SummaryRanges() {
        
    }
    
    void addNum(int val) {
        auto it = intval.lower_bound(vector<int>(2, val));
        int start = val, end = val;
        if(it != intval.begin() && (*(--it))[1] + 1 < val) ++it;
        while(it != intval.end() && val + 1 >= (*it)[0] && val - 1 <= (*it)[1]){
            start = min(start, (*it)[0]);
            end = max(end, (*it)[1]);
            it = intval.erase(it);
        }
        intval.insert(it, vector<int>{start, end});
    }
    
    vector<vector<int>> getIntervals() {
        vector<vector<int>> res;
        for(auto i : intval){
            res.push_back(i);
        }
        return res;
    }
};

