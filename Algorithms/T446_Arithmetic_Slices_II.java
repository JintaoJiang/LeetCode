class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length, res = 0;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for(int i = 0; i < n; i++){
            dp[i] = new HashMap();
            for(int j = i - 1; j >= 0; j--){
                long d = (long)A[i] - A[j];
                if (d <= Integer.MIN_VALUE || d > Integer.MAX_VALUE) continue;
                
                int diff = A[j] - A[i];
                int c1 = dp[i].getOrDefault(diff, 0);
                int c2 = dp[j].getOrDefault(diff, 0);
                res += c2;
                dp[i].put(diff, c1 + c2 + 1);
            }
        }
        return res;
    }
}