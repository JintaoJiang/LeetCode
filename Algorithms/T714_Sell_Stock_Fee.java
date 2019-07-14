class Solution {
    public int maxProfit(int[] prices, int fee) {
        int s0 = 0, s1 = -50000;
        for(int p : prices){
            int new_s0 = Math.max(s0, s1 + p - fee);
            int new_s1 = Math.max(s1, s0 - p);
            s0 = new_s0; s1 = new_s1;
        }
        return s0;
    }
}