class Solution {
    public int minPushBox(char[][] grid) {
        int res = Integer.MAX_VALUE, m = grid.length, n = grid[0].length, ti = 0, tj = 0;
        Queue<int[]> queue = new LinkedList();
        Map<String, Integer> map = new HashMap();
        int[] start = new int[6]; //si,sj,bi,bj,dir,step; 1->left,2->up,3->right,4->down
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 'S'){
                    start[0] = i; start[1] = j;
                } 
                if(grid[i][j] == 'B'){
                    start[2] = i; start[3] = j;
                }
                if(grid[i][j] == 'T'){
                    ti = i; tj = j;
                }
            }
        }
        queue.add(start);
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0] < 0 || cur[0] >= m || cur[1] < 0 || cur[1] >= n || grid[cur[0]][cur[1]] == '#') continue;
            if(cur[0] == cur[2] && cur[1] == cur[3]){
                if(cur[4] == 1) cur[3]--;
                if(cur[4] == 2) cur[2]--;
                if(cur[4] == 3) cur[3]++;
                if(cur[4] == 4) cur[2]++;
                if(cur[2] < 0 || cur[2] >= m || cur[3] < 0 || cur[3] >= n || grid[cur[2]][cur[3]] == '#') continue;
                cur[5]++;
            }           
            
            String state = cur[0] + " " + cur[1] + " " + cur[2] + " " + cur[3];
            if(map.containsKey(state) && cur[5] >= map.get(state)) continue;
            map.put(state, cur[5]);
            if(ti == cur[2] && tj == cur[3]){
                res = Math.min(res, cur[5]);
                continue;
            }
            queue.add(new int[]{cur[0], cur[1] - 1, cur[2], cur[3], 1, cur[5]});
            queue.add(new int[]{cur[0] - 1, cur[1], cur[2], cur[3], 2, cur[5]});
            queue.add(new int[]{cur[0], cur[1] + 1, cur[2], cur[3], 3, cur[5]});
            queue.add(new int[]{cur[0] + 1, cur[1], cur[2], cur[3], 4, cur[5]});
        }
        
        if(res == Integer.MAX_VALUE) return -1;
        return res;
    }
}