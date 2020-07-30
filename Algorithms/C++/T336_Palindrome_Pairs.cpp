class Solution {
public:
    vector<vector<int>> tr;
    unordered_map<int, int> ends;
    unordered_map<int, vector<int>> dict;
    vector<vector<int>> res;
    
    vector<vector<int>> palindromePairs(vector<string>& words) {
        int n = words.size();      
        tr.push_back(vector<int>(26));
        for(int i = 0; i < n; i++) add(words, i);
        for(int i = 0; i < n; i++) search(words, i);
        return res;
    }
    
    void add(vector<string>& words, int idx){
        int p = 0;
        string s = words[idx];
        if(valid(s, 0, s.size() - 1)) dict[p].push_back(idx);
        for(int i = s.size() - 1; i >= 0; i--){
            char c = s[i];                     
            if(tr[p][c - 'a'] == 0){
                tr.push_back(vector<int>(26));
                tr[p][c - 'a'] = tr.size() - 1;
            }
            p = tr[p][c - 'a']; 
            //add palindrome substring
            if(valid(s, 0, i - 1)) dict[p].push_back(idx);                 
        }
        ends[p] = idx;
    }
    
    void search(vector<string>& words, int idx){
        int p = 0;
        string s = words[idx];
        for(int i = 0; i < s.size(); i++){
            char c = s[i];         
            //current word is longer            
            if(ends.count(p) && valid(s, i, s.size() - 1)) 
                res.push_back({idx, ends[p]});            
            if(tr[p][c - 'a'] == 0) return;
            p = tr[p][c - 'a'];
        }
        //current word is shorter
        for(int cand : dict[p])
            if(cand != idx) res.push_back({idx, cand});
    }
    
    bool valid(string s, int i, int j){
        while(i < j){
            if(s[i++] != s[j--]) return false;
        }
        return true;
    }
};
