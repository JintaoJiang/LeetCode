class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int res = 0, buy = prices[0], sell = Integer.MIN_VALUE;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < sell){
                res += sell - buy;
                buy = prices[i];
                sell = Integer.MIN_VALUE;
            }else{
                if(prices[i] < buy) buy = prices[i];
                else sell = prices[i];
            }
        }
        if(sell > buy) res += sell - buy;
        return res;
    }
}