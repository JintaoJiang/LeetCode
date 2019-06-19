class Solution {
    public double myPow(double x, int n) {
        int nn = n;
        double xx = x;
        if(n == Integer.MIN_VALUE) nn = Integer.MAX_VALUE;
        else if(n < 0) nn = -n;
        double res = 1;
        boolean first = true;
        
        while(nn != 0){
            if(first){
                first = false;
            }else{
                xx *= xx;
            }
            if((nn & 1) == 1) res *= xx;
            nn = nn >> 1;
        }
        if(n < 0) res = 1 / res;
        if(n == Integer.MIN_VALUE) res = res / x;            
        return res;
    }
}