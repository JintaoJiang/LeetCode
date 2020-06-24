class Solution {
public:
    int kSimilarity(string A, string B) {
        queue<string> q;
        unordered_set<string> s;
        q.push(A);
        s.insert(A);
        int k = 0;
        while(!q.empty()){
            for(int c = q.size(); c > 0; --c){
                string cur = q.front(); 
                q.pop();
                if(cur == B) return k;
                int i = 0;
                while(cur[i] == B[i]) ++i;                
                for(int j = i + 1; j < cur.size(); ++j){
                    if(cur[j] == B[j] || cur[j] != B[i]) continue;
                    string tmp = cur;
                    swap(tmp[i], tmp[j]);
                    if(!s.count(tmp)){
                        s.insert(tmp);
                        q.push(tmp);
                    }
                }
            }
            ++k;            
        }
        return 0;
    }
};
