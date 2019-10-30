class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[0] == o2[0]){
                if(o1[1] == o2[1]){
                    return o1[2] - o2[2];
                }    
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        int[] res = new int[workers.length];
        boolean[] bikemask = new boolean[bikes.length];
        for(int i = 0; i < workers.length; i++){
            for(int j = 0; j < bikes.length; j++){
                int dist = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                pq.add(new int[]{dist, i, j});
            }
            res[i] = -1;
        }
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(res[cur[1]] == -1 && !bikemask[cur[2]]){
                res[cur[1]] = cur[2];
                bikemask[cur[2]] = true;
            }
        }
        return res;
    }
}