class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if(n == 0) return 0;
        Arrays.sort(envelopes, (a, b) -> (a[0] - b[0] == 0 ? b[1] - a[1] : a[0] - b[0]));
        int[] tail = new int[n];
        int len = 0;
        for(int[] e : envelopes){
            int cur = Arrays.binarySearch(tail, 0, len, e[1]);
            if(cur < 0) cur = -(cur + 1);
            tail[cur] = e[1];
            if(cur == len) len++;
        }
        return len;
    }
}