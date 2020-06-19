class Solution {
public:
    unordered_map<string, vector<string>> graph;
    unordered_map<string, int> visit;
    vector<string> res;
    
    vector<string> findItinerary(vector<vector<string>>& tickets) {       
        for(auto t : tickets){
            graph[t[0]].push_back(t[1]);
            visit[t[0] + t[1]]++;
        }
        for(auto &g : graph){
            sort(g.second.begin(), g.second.end());
        }
        vector<string> list;
        DFS(list, "JFK", tickets.size(), 0);
        return res;
    }
    
    void DFS(vector<string>& list, string cur, int n, int stops){
        if(res.size() > 0) return;
        list.push_back(cur);
        if(stops == n){
            res = vector<string>(list);
            return;
        }
        for(auto nei : graph[cur]){
            if(visit[cur + nei] == 0) continue; 
            --visit[cur + nei];
            DFS(list, nei, n, stops + 1);  
            ++visit[cur + nei];
        }
        list.pop_back();
    }
};
