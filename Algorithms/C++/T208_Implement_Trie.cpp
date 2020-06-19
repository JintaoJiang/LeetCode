class Trie {
public:
    vector<vector<int>> v;
    unordered_set<int> s;
    /** Initialize your data structure here. */
    Trie() {
        v.push_back(vector<int>(26, -1));
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        int pos = 0;
        for(auto c : word){
            if(v[pos][c - 'a'] != -1){
                pos = v[pos][c - 'a'];
            }else{
                v.push_back(vector<int>(26, -1));
                v[pos][c - 'a'] = v.size() - 1;
                pos = v.size() - 1;
            }
        }
        s.insert(pos);
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        int pos = 0;
        for(auto c : word){
            if(v[pos][c - 'a'] != -1){
                pos = v[pos][c - 'a'];
            }else{
                return false;
            }

