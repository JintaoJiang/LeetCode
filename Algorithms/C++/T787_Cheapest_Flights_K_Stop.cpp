class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int K) {
        queue<pair<int, int>> q;
        vector<vector<pair<int, int>>> graph(n, vector<pair<int, int>>());
        vector<int> map(n, INT_MAX);
        for(auto f : flights){
            graph[f[0]].push_back(pair(f[1], f[2]));
        }
        q.push(pair(src, 0));
        map[src] = 0;
        while(!q.empty() && K >= 0){
            int num = q.size();
            for(int i = 0; i < num; ++i){
                auto cur = q.front();   
                q.pop();
                for(auto p : graph[cur.first]){                
                    int dist = p.second + cur.second;
                    if(p.first == dst){
                        map[dst] = min(map[dst], dist);
                    }else if(dist < map[p.first]){
                        q.push(pair(p.first, dist));
                        map[p.first] = dist;
                    }
                }              
            }   
            --K;    
        }
        return map[dst] == INT_MAX ? -1 : map[dst];
    }
};
