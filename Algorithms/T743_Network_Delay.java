class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        List<int[]>[] graph = new LinkedList[N + 1];
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i = 0; i < times.length; i++){
            int u = times[i][0], v = times[i][1], time = times[i][2];
            if(graph[u] == null) graph[u] = new LinkedList();
            if(graph[v] == null) graph[v] = new LinkedList();
            graph[u].add(new int[]{v, time});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        dist[K] = 0;
        pq.add(new int[]{K, 0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(visited[cur[0]]) continue;
            visited[cur[0]] = true;
            for(int[] nei : graph[cur[0]]){
                if(visited[nei[0]]) continue;
                if(dist[nei[0]] > cur[1] + nei[1]){
                    dist[nei[0]] = cur[1] + nei[1];
                    pq.add(new int[]{nei[0], dist[nei[0]]});
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            if(dist[i] > max) max = dist[i];
        }
        return max;
    }
}