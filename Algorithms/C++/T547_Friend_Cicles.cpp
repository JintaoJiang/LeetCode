class Solution {
public:
    vector<int> p;
    
    int find(int x){
        if(x != p[x]) p[x] = find(p[x]);
        return p[x];
    }
    
    int findCircleNum(vector<vector<int>>& M) {
        int n = M.size(), res = 0;
        p = vector<int>(n);
        for(int i = 0; i < n; ++i) p[i] = i;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j <= i; ++j){
                if(M[i][j]){                    
                    int p1 = find(i), p2 = find(j);
                    p[p1] = p2;                   
                }
            }
        }
        for(int i = 0; i < n; ++i){
            if(p[i] == i) ++res;
        }
        return res;
    }
};
