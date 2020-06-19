class Solution {
public:
    vector<int> p;
    
    int find(int x){
        if(x != p[x]) p[x] = find(p[x]);
        return p[x];
    }
    
    int makeConnected(int n, vector<vector<int>>& connections) {
        int extra = 0, comp = 0;
        p = vector<int>(n);
        for(int i = 0; i < n; ++i) p[i] = i;
        for(auto & edge : connections){
            int p1 = find(edge[0]);
            int p2 = find(edge[1]);
            if(p1 == p2) ++extra;
            else p[p1] = p2;
        }
        for(int i = 0; i < n; ++i){
            if(p[i] == i) ++comp;
        }
        return extra >= comp - 1 ? comp - 1 : -1;        
    }
};
