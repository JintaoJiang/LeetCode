class Solution {
    public int leastInterval(char[] tasks, int n) {
        int m = tasks.length;
        int[] count = new int[26];
        for(int i = 0; i < m; i++){
            count[tasks[i] - 'A']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for(int i = 0; i < 26; i++){
            if(count[i] > 0) pq.add(new int[]{i, count[i]});
        }
        Queue<int[]> queue = new LinkedList();
        int res = 0;
        while(!pq.isEmpty() || !queue.isEmpty()){
            if(res % (n + 1) == 0){
                while(!queue.isEmpty()) pq.add(queue.poll());
            }
            res++;
            int[] cur = pq.poll();
            if(cur == null) continue;
            cur[1]--;
            if(cur[1] > 0) queue.add(cur);
        }
        return res;
    }
}