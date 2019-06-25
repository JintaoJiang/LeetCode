class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] party = new int[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(party[i] == 0){
                Queue<Integer> queue = new LinkedList();
                queue.add(i);
                party[i] = 1;
                while(!queue.isEmpty()){
                    int node = queue.poll();
                    for(int nei : graph[node]){                        
                        if(party[nei] == party[node]) return false;
                        if(party[nei] == -party[node]) continue;
                        queue.add(nei);
                        party[nei] = -party[node];
                    }
                }
            }              
        }
        return true;
    }
}