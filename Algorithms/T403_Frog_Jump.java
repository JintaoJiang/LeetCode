class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        Map<Integer, Set<Integer>> map = new HashMap();
        for(int i = 0; i < n; i++){
        	Set<Integer> temp = new HashSet();
            if(i == 0) temp.add(1);
            map.put(stones[i], temp);
        }      
        for(int i = 0; i < n; i++){
            Set <Integer> set = map.get(stones[i]);
            for(int step : set){
            	int next = stones[i] + step;
            	if(next == stones[n - 1]) return true;
                if(map.containsKey(next)){
                	Set nextSet = map.get(next);
                    if(step > 1) nextSet.add(step - 1);
                    nextSet.add(step);
                    nextSet.add(step + 1);
                }
            }
        }
        return map.get(stones[n - 1]).size() > 0;
    }
}