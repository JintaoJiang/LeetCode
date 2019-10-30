class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        DSet dset = new DSet(n);
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int[] s1 = stones[i], s2 = stones[j];
                if(s1[0] == s2[0] || s1[1] == s2[1]) dset.union(i + 1, j + 1);
            }
        }
        return n - dset.count;
    }
}

class DSet{
    int[] par;
    int count;
    
    public DSet(int n){
        par = new int[n + 1];
        count = n;
    }
    
    public int find(int x){
        if(par[x] == 0) return x;
        return par[x] = find(par[x]);
    }
    
    public boolean union(int x, int y){
        int px = find(x), py = find(y);
        if(px == py) return true;
        par[py] = px;
        count--;
        return false;
    }
}