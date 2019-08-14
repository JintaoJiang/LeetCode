class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] res = new int[2];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size(); i++){
            List<Integer> l = nums.get(i);
            pq.add(new int[]{l.get(0), i});
            max = Math.max(max, l.get(0));
        }
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(max - cur[0] < min){
                min = max - cur[0];
                res[0] = cur[0];
                res[1] = max;
            }
            if(nums.get(cur[1]).size() == 0) break;
            int i = nums.get(cur[1]).remove(0);
            max = Math.max(max, i);
            pq.add(new int[]{i, cur[1]});
        }
        return res;
    }
}