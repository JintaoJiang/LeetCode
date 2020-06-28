class Solution {
public:    
    vector<vector<int>> criticalConnections(int n, vector<vector<int>>& connections) {
        vector<vector<int>> graph(n), bridge;
        vector<bool> visit(n);
        vector<int> dfs(n), low(n);   
        for(auto e : connections){
            graph[e[0]].push_back(e[1]);
            graph[e[1]].push_back(e[0]);
        }
        
        int time = 0;
        function<void(int, int)> tarjan = [&](int x, int p){
            dfs[x] = low[x] = ++time;
            visit[x] = true;
            for(auto y : graph[x]){
                if(!visit[y]){
                    tarjan(y, x);
                    low[x] = min(low[x], low[y]);
                    if(dfs[x] < low[y]){
                        vector<int> v({x, y});
                        bridge.push_back(v);
                    }
                }else if(y != p){
                    low[x] = min(low[x], dfs[y]);
                }
            }
        };
        
        tarjan(0, -1);
        
        return bridge;
    }
};
