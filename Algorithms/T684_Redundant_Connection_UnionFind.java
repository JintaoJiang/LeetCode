class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Dset dset = new Dset(edges.length);
        for(int[] edge : edges){
            if(dset.union(edge[0], edge[1])) return edge;
        }
        return null;
    }
}

class Dset{
    int[] set;
    
    public Dset(int n){
        set = new int[n + 1];
    }
    
    //path compression
    public int find(int x){
        if(set[x] <= 0) return x;
        return set[x] = find(set[x]);
    }
    
    //union by height
    public boolean union(int x, int y){
        int px = find(x), py = find(y);
        if(px == py) return true;
        if(set[px] < set[py]) set[py] = px;
        else if(set[px] > set[py]) set[px] = py;
        else { set[px]--; set[py] = px; }
        return false;
    }   
}

