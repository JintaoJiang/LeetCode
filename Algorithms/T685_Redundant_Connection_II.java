class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        //if a node has two parents, record the two edges
        int[] cand1 = null, cand2 = null;
        int[] par = new int[edges.length + 1];
        for(int[] edge : edges){
            if(par[edge[1]] == 0){
                par[edge[1]] = edge[0];
            }else{
                cand1 = new int[]{par[edge[1]], edge[1]}; //old edge
                cand2 = new int[]{edge[0], edge[1]}; //new edge
                edge[1] = 0; //romove the edge
            }
        }
        //test if the cycle is removed
        Dset dset = new Dset(edges.length);
        for(int[] edge : edges){
            if(edge[1] == 0) continue;
            if(dset.union(edge[0], edge[1])){
                if(cand1 == null){
                    //no node has two parents
                    return edge;
                }else{
                    //we removed the wrong edge and disconnected the graph
                    return cand1;
                }                
            }
        }
        //we removed the right edge
        return cand2;
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

