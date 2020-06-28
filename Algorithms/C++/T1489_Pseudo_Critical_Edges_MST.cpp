class Solution {
public:
    vector<int> p;
    
    vector<vector<int>> findCriticalAndPseudoCriticalEdges(int n, vector<vector<int>>& edges) {
        p = vector<int>(n);
        vector<vector<int>> res(2);
        for(int i = 0; i < edges.size(); i++){
            auto &e = edges[i];
            swap(e[2], e[0]);
            e.push_back(i);
        }
        sort(edges.begin(), edges.end());
        int cost = kruskal_ex(n, edges, -1);
        for(int i = 0; i < edges.size(); i++){
            int cost1 = kruskal_in(n, edges, i);
            int cost2 = kruskal_ex(n, edges, i);
            if(cost2 != cost) res[0].push_back(i);
            else if(cost1 == cost) res[1].push_back(i);
        }
        return res;
    }
    
    int find(int x){
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
    
    int kruskal_ex(int n, vector<vector<int>>& edges, int k){
        int res = 0, cnt = n;
        for(int i = 0; i < n; i++) p[i] = i;
        for(auto &e : edges){
            int w = e[0], u = e[1], v = e[2], idx = e[3];
            if(idx == k) continue;
            int p1 = find(u), p2 = find(v);
            if(p1 != p2){
                res += w;
                p[p1] = p2;
                cnt--;
            }
        }
        if(cnt > 1) return INT_MAX;
        return res;
    }
    
    int kruskal_in(int n, vector<vector<int>>& edges, int k){
        int res = 0, cnt = n;
        for(int i = 0; i < n; i++) p[i] = i;
        for(auto &e : edges){
            int w = e[0], u = e[1], v = e[2], idx = e[3];
            if(idx == k){
                res += w;
                p[u] = v;
                cnt--;
                break;
            }
        }
        for(auto &e : edges){
            int w = e[0], u = e[1], v = e[2], idx = e[3];
            if(idx == k) continue;
            int p1 = find(u), p2 = find(v);
            if(p1 != p2){
                res += w;
                p[p1] = p2;
                cnt--;
            }
        }
        if(cnt > 1) return INT_MAX;
        return res;
    }
};



