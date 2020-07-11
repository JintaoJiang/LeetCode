class Solution {
public:
    int distinctSubseqII(string S) {
        int n = S.size(), mod = 1e9 + 7;
        vector<long> ends(26);
        for(int i = 0; i < n; i++){
            ends[S[i] - 'a'] = accumulate(ends.begin(), ends.end(), 1L) % mod;
        }
        return accumulate(ends.begin(), ends.end(), 0L) % mod;
    }
};
