class Solution {
    Map<Integer, Integer> map = new HashMap();
    int n;
    Random rand = new Random();

    public Solution(int N, int[] blacklist) {
        n = N - blacklist.length;
        for(int i : blacklist) map.put(i, -1);
        N--;
        for(int i : blacklist){
            if(i < n){
                while(map.containsKey(N)) N--;
                map.put(i, N);
                N--;
            }
        }
    }
    
    public int pick() {
        int r = rand.nextInt(n);
        if(map.containsKey(r)) return map.get(r);
        return r;
    }
}