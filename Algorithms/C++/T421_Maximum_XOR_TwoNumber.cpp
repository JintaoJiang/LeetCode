class Solution {
public:
    vector<vector<int>> tr;

    void insert(int num){
        int p = 0;
        for(int i = 31; i >= 0; i--){
            int c = (num >> i) & 1;
            if(tr[p][c] == 0){
                tr.push_back(vector<int>(2));
                tr[p][c] = tr.size() - 1;
            }
            p = tr[p][c];
        }
    }

    int search(int num){
        int p = 0, res = 0;
        for(int i = 31; i >= 0; i--){
            int c = 1 - ((num >> i) & 1);
            if(tr[p][c] == 0) c = 1 - c;
            p = tr[p][c];
            res |= (c << i);
        }
        return res ^ num;
    }
    
    int findMaximumXOR(vector<int>& nums) {
        int res = 0;
        tr.push_back(vector<int>(2));
        for(int n : nums) insert(n);
        for(int n : nums) res = max(res, search(n));
        return res;
    }

};
