class Solution {
    public int maxProfit(int[] prices) {
        int s0 = 0, s1 = Integer.MIN_VALUE, s2 = 0, s3 = Integer.MIN_VALUE, s4 = Integer.MIN_VALUE;
        for(int p : prices){
            int new_s1 = Math.max(s1, s0 - p);
            int new_s2 = Math.max(s2, s1 + p);
            int new_s3 = Math.max(s3, s2 - p);
            int new_s4 = Math.max(s4, s3 + p);
            s1 = new_s1; s2 = new_s2; s3 = new_s3; s4 = new_s4;
        }
        return Math.max(s0, Math.max(s2, s4));
    }
}