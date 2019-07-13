class Solution {
    public int maxProfit(int[] prices) {
        int s0 = 0, s1 = Integer.MIN_VALUE, s2= Integer.MIN_VALUE;
        for(int p : prices){
            int s0_new = Math.max(s0, s2);
            int s1_new = Math.max(s1, s0 - p);
            int s2_new = s1 + p;
            s0 = s0_new; s1 = s1_new; s2 = s2_new;
        }
        return Math.max(s0, s2);
    }
}