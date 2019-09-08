class Solution {
    Map<String, Map<String, Double>> graph = new HashMap();
    double[] res;
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size(), m = queries.size();
        for(int i = 0; i < n; i++){
            List<String> edge = equations.get(i);
            
            Map<String, Double> neighbors = graph.getOrDefault(edge.get(0), new HashMap<String, Double>());
            neighbors.put(edge.get(1), values[i]);
            graph.put(edge.get(0), neighbors);
            
            Map<String, Double> neighbors2 = graph.getOrDefault(edge.get(1), new HashMap<String, Double>());
            neighbors2.put(edge.get(0), 1 / values[i]);
            graph.put(edge.get(1), neighbors2);            
        }
        res = new double[m];
        for(int i = 0; i < m; i++){
            List<String> edge = queries.get(i);
            DFS(edge.get(0), edge.get(1), 1, i, new HashSet<String>());
        }
        return res;
    }
    
    private boolean DFS(String start, String end, double val, int i, HashSet<String> visited){
        if(!graph.containsKey(start)){
            res[i] = -1;
            return false;
        }
        if(start.equals(end)){
            res[i] = val;
            return true;
        }
        Map<String, Double> neighbors = graph.get(start);
        visited.add(start);
        for(String nei : neighbors.keySet()){
            if(visited.contains(nei)) continue;
            if(DFS(nei, end, val * neighbors.get(nei), i, visited)) return true;
        }
        res[i] = -1;
        return false;
    }
}
