class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<int[]>[] graph = new LinkedList[n];
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int[] edge : flights){
            if(graph[edge[0]] == null) graph[edge[0]] = new LinkedList();
            if(graph[edge[1]] == null) graph[edge[1]] = new LinkedList();
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.add(new int[]{src, 0, K});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[0] == dst) return cur[1];
            if(cur[2] >= 0){
                for(int[] nei : graph[cur[0]]){
                    if(dist[nei[0]] > cur[1] + nei[1]) pq.add(new int[]{nei[0], cur[1] + nei[1], cur[2] - 1});
                }
            }
        }
        return -1;
    }
}