class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        if(forest.size() == 0 || forest.get(0).size() == 0) return -1;
        int m = forest.size(), n = forest.get(0).size();
        int[][] f = new int[m][n];
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int i = 0; i < m; i++){
            List<Integer> list = forest.get(i);
            for(int j = 0; j < n; j++){
                f[i][j] = list.get(j);
                if(f[i][j] > 1) pq.add(f[i][j]);
            }
        }
        int[] cur = new int[]{0, 0};
        int sum = 0;
        while(!pq.isEmpty()){
            int[] res = findPath(cur, f, pq.poll());
            if(res[0] == -1) return -1;
            sum += res[0];
            cur[0] = res[1];
            cur[1] = res[2];
        }
        return sum;
    }
    
    private int[] findPath(int[] pos, int[][] f, int target){
        int m = f.length, n = f[0].length;
        boolean[][] mask = new boolean[m][n];
        Queue<int[]> queue = new LinkedList();
        queue.add(pos);
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k = 0; k < size; k++){
                int[] cur = queue.poll();
                int i = cur[0], j = cur[1];
                if(i >= m || i < 0 || j >= n || j < 0 || f[i][j] == 0 || mask[i][j])
                    continue;
                if(f[i][j] == target) return new int[]{step, i, j};
                queue.add(new int[]{i + 1, j});
                queue.add(new int[]{i - 1, j});
                queue.add(new int[]{i, j + 1});
                queue.add(new int[]{i, j - 1});
                mask[i][j] = true;
            }
            step++;
        }
        return new int[]{-1, -1, -1};
    }
}