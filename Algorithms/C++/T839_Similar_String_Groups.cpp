class Solution {
public:
    vector<int> p;
    
    int numSimilarGroups(vector<string>& A) {
        int n = A.size(), res = 0;
        p = vector<int>(n);
        for(int i = 0; i < n; ++i) p[i] = i;
        for(int i = 0; i < n; ++i){
            for(int j = i + 1; j < n; ++j){
                int pa = find(i), pb = find(j);
                if(pa == pb || similar(A[i], A[j])) p[pb] = pa;
            }
        }
        for(int i = 0; i < n; ++i){
            if(p[i] == i) ++res;
        }
        return res;
    }
    
    bool similar(string s1, string s2){
        int count = 0;
        for(int i = 0; i < s1.size(); ++i){
           if(s1[i] != s2[i] && ++count > 2)
               return false;
        }
        return true;
    }
    
    int find(int x){
        if(x != p[x]) p[x] = find(p[x]);
        return p[x];
    }
};
